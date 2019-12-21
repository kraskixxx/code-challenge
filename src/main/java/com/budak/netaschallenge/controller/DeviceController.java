package com.budak.netaschallenge.controller;

import com.budak.netaschallenge.domain.Device;
import com.budak.netaschallenge.service.DeviceService;
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
public class DeviceController {

    @Autowired
    DeviceService deviceService;

    @PostMapping(value = "/saveDevice", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation("Saves Device to H2 DB")
    private Long saveDevice(@Valid @RequestBody Device device) {
        Device savedDevice = deviceService.saveOrUpdate(device);
        return savedDevice.getId();
    }
}
