package com.budak.netaschallenge;

import com.budak.netaschallenge.domain.MobileDeviceData;
import com.budak.netaschallenge.enums.EnumOperatingSystem;
import com.budak.netaschallenge.service.MobileDeviceDataService;
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
    MobileDeviceDataService mobileDeviceDataService;

	@Test
	void contextLoads() {
	}

	@Test()
	public void when_adding_duplicate_record_then_throws_exception_test() throws DataIntegrityViolationException{
        MobileDeviceData mobileDeviceData = new MobileDeviceData();
        mobileDeviceData.setOs(EnumOperatingSystem.IOS);
        mobileDeviceData.setBrand("GM");
        mobileDeviceData.setModel("GM 8");
        mobileDeviceData.setOsVersion("8.1.0");

        assertThrows(DataIntegrityViolationException.class, () -> {
            mobileDeviceDataService.saveOrUpdate(mobileDeviceData);
        });
    }

}
