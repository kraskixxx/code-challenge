package com.budak.netaschallenge.controller;

import com.budak.netaschallenge.domain.MobileDeviceData;
import com.budak.netaschallenge.service.MobileDeviceDataService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author Samet BUDAK
 * @since
 */
@RestController
public class MobileDeviceDataController {

    @Autowired
    MobileDeviceDataService mobileDeviceDataService;

    @PostMapping(value = "/saveMobileDeviceData", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Saves MobileDeviceData to H2 DB")
    private Long saveMobileDeviceData(@Valid @RequestBody MobileDeviceData mobileDeviceData) {
        MobileDeviceData savedMobileDeviceData = mobileDeviceDataService.saveOrUpdate(mobileDeviceData);
        return savedMobileDeviceData.getId();
    }
}
