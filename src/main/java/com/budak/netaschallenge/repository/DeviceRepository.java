package com.budak.netaschallenge.repository;

import com.budak.netaschallenge.domain.Device;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Samet BUDAK
 * @since
 */
public interface DeviceRepository extends PagingAndSortingRepository<Device, Long>, JpaSpecificationExecutor<Device> {

}
