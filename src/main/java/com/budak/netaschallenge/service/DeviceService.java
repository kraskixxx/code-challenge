package com.budak.netaschallenge.service;

import com.budak.netaschallenge.domain.Device;
import com.budak.netaschallenge.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

/**
 * @author Samet BUDAK
 * @since
 */
@Service
public class DeviceService {

    @Autowired
    DeviceRepository deviceRepository;

    public Device saveOrUpdate(Device device) throws DataIntegrityViolationException {
        return deviceRepository.save(device);
    }

    public Page<Device> findAll(Specification<Device> mobileDeviceDataSpecification) {
        return (Page<Device>) deviceRepository.findAll(mobileDeviceDataSpecification);
    }
}
