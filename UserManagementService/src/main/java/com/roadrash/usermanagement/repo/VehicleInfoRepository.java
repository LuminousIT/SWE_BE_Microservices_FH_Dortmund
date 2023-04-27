package com.roadrash.usermanagement.repo;

import com.roadrash.usermanagement.domain.VehicleInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleInfoRepository extends JpaRepository<VehicleInfo, Long> {
}
