package com.budak.netaschallenge.service;

import com.budak.netaschallenge.domain.Device;
import com.budak.netaschallenge.exception.DeviceNotFoundException;
import com.budak.netaschallenge.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public Page<Device> findAllWithSpecification(Specification<Device> deviceSpecification, Pageable pageable) {
        return (Page<Device>) deviceRepository.findAll(deviceSpecification, pageable);
    }

    public Optional<Device> findDeviceById(Long deviceId) throws DeviceNotFoundException {
        return deviceRepository.findById(deviceId);
    }
}
