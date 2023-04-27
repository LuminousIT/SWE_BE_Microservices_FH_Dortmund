package com.roadrash.usermanagement.service;

import com.roadrash.usermanagement.domain.UserInfo;
import com.roadrash.usermanagement.domain.VehicleInfo;
import com.roadrash.usermanagement.repo.UserInfoRepository;
import com.roadrash.usermanagement.repo.VehicleInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleInfoService {
    public VehicleInfoRepository vehicleInfoRepository;
    public UserInfoRepository userInfoRepository;
    
    public VehicleInfoService(VehicleInfoRepository vehicleInfoRepository, UserInfoRepository userInfoRepository){
        this.vehicleInfoRepository = vehicleInfoRepository;
        this.userInfoRepository = userInfoRepository;
    }

    public List<VehicleInfo> findAll() {
        return vehicleInfoRepository.findAll();
    }

    public Optional<VehicleInfo> findById(Long userId) {
        return vehicleInfoRepository.findById(userId);
    }

    public VehicleInfo createVehicle(VehicleInfo vehicleInfo){
        try {
            Long userID = vehicleInfo.getUserID();
            System.out.println("My user here " + userID);
            UserInfo user = userInfoRepository.getById(vehicleInfo.getUserID());
            System.out.println("My user here " + user.getName());
            if (user != null)
                return vehicleInfoRepository.save(vehicleInfo);
            throw new RuntimeException("User not found");
        } catch (Exception e) {
            System.out.println("error here: " + e.getMessage());
            vehicleInfo.setVehicleName(e.getMessage());
            return vehicleInfo;
        }
    }

    public VehicleInfo updateVehicle(Long id, VehicleInfo VehicleInfo){
        return vehicleInfoRepository.save(VehicleInfo);
    }

    public VehicleInfo save(VehicleInfo VehicleInfo) {
        return vehicleInfoRepository.save(VehicleInfo);
    }


}
