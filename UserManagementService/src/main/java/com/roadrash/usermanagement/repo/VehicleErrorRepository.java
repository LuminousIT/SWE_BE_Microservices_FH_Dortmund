package com.roadrash.usermanagement.repo;

import com.roadrash.usermanagement.domain.VehicleErrorInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleErrorRepository extends JpaRepository<VehicleErrorInfo, Long> {
    VehicleErrorInfo findByErrorCode(String errorCode);
}
