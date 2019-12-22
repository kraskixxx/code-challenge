package com.budak.netaschallenge.controller;

import com.budak.netaschallenge.domain.Device;
import com.budak.netaschallenge.enums.EnumOperatingSystem;
import com.budak.netaschallenge.exception.DeviceNotFoundException;
import com.budak.netaschallenge.service.DeviceService;
import com.budak.netaschallenge.specs.DeviceSpecification;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/devices")
    public Page<Device> getDevices(
                              @RequestParam(value = "brand", required = false) String brand,
                              @RequestParam(value = "model", required = false) String model,
                              @RequestParam(value = "os", required = false) EnumOperatingSystem os,
                              @RequestParam(value = "osVersion", required = false) String osVersion,
                              @RequestParam(value = "page", defaultValue = "0") int page,
                              @RequestParam(name = "size", defaultValue = "20") int size) {
        Device sampleDevice = new Device();
               sampleDevice.setBrand(brand);
               sampleDevice.setModel(model);
               sampleDevice.setOs(os);
               sampleDevice.setOsVersion(osVersion);

        PageRequest pageable = PageRequest.of(page, size);
        DeviceSpecification deviceSpecification = new DeviceSpecification(sampleDevice);
        Page<Device> deviceList = deviceService.findAllWithSpecification(deviceSpecification, pageable);

        return deviceList;
    }

    @GetMapping("/device/{id}")
    public Device getDevice(@PathVariable Long id) throws DeviceNotFoundException {
        return deviceService.findDeviceById(id).orElseThrow(() -> new DeviceNotFoundException(id));
    }
}
