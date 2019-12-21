package com.budak.netaschallenge;

import com.budak.netaschallenge.domain.Device;
import com.budak.netaschallenge.enums.EnumOperatingSystem;
import com.budak.netaschallenge.service.DeviceService;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class NetaschallengeApplicationTests {

    @Spy
    @Autowired
    DeviceService deviceService;

	@Test
	void contextLoads() {
	}

	@Test()
	public void when_adding_duplicate_record_then_throws_exception_test() throws DataIntegrityViolationException{
        Device device = new Device();
        device.setOs(EnumOperatingSystem.IOS);
        device.setBrand("GM");
        device.setModel("GM 8");
        device.setOsVersion("8.1.0");

        assertThrows(DataIntegrityViolationException.class, () -> {
            deviceService.saveOrUpdate(device);
        });
    }

}
