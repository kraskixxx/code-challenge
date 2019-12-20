package com.budak.netaschallenge.service;

import com.budak.netaschallenge.domain.MobileDeviceData;
import com.budak.netaschallenge.repository.MobileDeviceDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Samet BUDAK
 * @since
 */
@Service
public class MobileDeviceDataService {

    @Autowired
    MobileDeviceDataRepository mobileDeviceDataRepository;

    public MobileDeviceData saveOrUpdate(MobileDeviceData mobileDeviceData){
        return mobileDeviceDataRepository.save(mobileDeviceData);
    }
}
