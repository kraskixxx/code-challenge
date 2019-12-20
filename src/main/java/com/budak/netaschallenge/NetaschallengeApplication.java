package com.budak.netaschallenge;

import com.budak.netaschallenge.domain.MobileDeviceData;
import com.budak.netaschallenge.service.MobileDeviceDataService;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.deser.BeanDeserializerModifier;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableSwagger2
public class NetaschallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetaschallengeApplication.class, args);
	}

    @Bean
    CommandLineRunner runner(MobileDeviceDataService mobileDeviceDataService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS);

            SimpleModule module = new SimpleModule();
            module.setDeserializerModifier(new BeanDeserializerModifier() {
                @Override
                public JsonDeserializer<Enum> modifyEnumDeserializer(DeserializationConfig config,
                                                                     final JavaType type,
                                                                     BeanDescription beanDesc,
                                                                     final JsonDeserializer<?> deserializer) {
                    return new JsonDeserializer<Enum>() {
                        @Override
                        public Enum deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
                            Class<? extends Enum> rawClass = (Class<Enum<?>>) type.getRawClass();
                            return Enum.valueOf(rawClass, jp.getValueAsString().toUpperCase());
                        }
                    };
                }
            });
            module.addSerializer(Enum.class, new StdSerializer<Enum>(Enum.class) {
                @Override
                public void serialize(Enum value, JsonGenerator jgen, SerializerProvider provider) throws IOException {
                    jgen.writeString(value.name().toLowerCase());
                }
            });
            mapper.registerModule(module);

            TypeReference<List<MobileDeviceData>> typeReference = new TypeReference<List<MobileDeviceData>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/devices.json");
            try {
                List<MobileDeviceData> mobileDeviceDataList = mapper.readValue(inputStream,typeReference);
                Set<MobileDeviceData> mobileDeviceDataSet = new HashSet<>();
                mobileDeviceDataSet.addAll(mobileDeviceDataList);

                for (MobileDeviceData mobileDeviceData : mobileDeviceDataSet) {
                    mobileDeviceDataService.saveOrUpdate(mobileDeviceData);
                }
                System.out.println("Mobile Device Datas are Saved!");
            } catch (IOException e){
                System.out.println("Unable to save Mobile Device Datas: " + e.getMessage());
            }
        };
    }
}
