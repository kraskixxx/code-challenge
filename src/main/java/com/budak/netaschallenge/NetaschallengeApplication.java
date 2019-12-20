package com.budak.netaschallenge;

import com.budak.netaschallenge.domain.MobileDeviceData;
import com.budak.netaschallenge.service.MobileDeviceDataService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class NetaschallengeApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetaschallengeApplication.class, args);
	}

    @Bean
    CommandLineRunner runner(MobileDeviceDataService mobileDeviceDataService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
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
