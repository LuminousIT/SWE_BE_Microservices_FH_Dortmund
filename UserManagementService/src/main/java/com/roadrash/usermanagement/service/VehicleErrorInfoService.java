package com.roadrash.usermanagement.service;

import com.roadrash.usermanagement.domain.DefectComponent;
import com.roadrash.usermanagement.domain.VehicleDemoData;
import com.roadrash.usermanagement.domain.VehicleErrorInfo;
import com.roadrash.usermanagement.repo.VehicleErrorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleErrorInfoService {
    public VehicleErrorRepository vehicleErrorRepository;

    Logger logger = LoggerFactory.getLogger(VehicleErrorInfoService.class);
    public VehicleErrorInfoService(VehicleErrorRepository vehicleErrorRepository){
        this.vehicleErrorRepository = vehicleErrorRepository;
    }

    public VehicleErrorInfo logVehicleError(VehicleErrorInfo vehicleErrorInformation) {
        return vehicleErrorRepository.save(vehicleErrorInformation);
    }

    public DefectComponent reportVehicleError(VehicleErrorInfo vehicleErrorInfo) {
        VehicleErrorInfo log = logVehicleError(vehicleErrorInfo);
        if(log == null) return null;
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost:8085")
                .path("/api/vehicle-fix/information/" + vehicleErrorInfo.getErrorCode())
                .build();

        String url = uriComponents.toUriString();
        System.out.println("URL " + url);
        logger.info(url);
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<DefectComponent> obj=  new RestTemplate().getForEntity(url, DefectComponent.class);
        logger.info( String.valueOf(obj.getStatusCodeValue()));
        DefectComponent response = obj.getBody();
        response.setLatitude(vehicleErrorInfo.getLatitude());
        response.setLongitude(vehicleErrorInfo.getLongitude());
        return response;
    }

    public List<VehicleErrorInfo> findAll() {
        return vehicleErrorRepository.findAll();
    }

    public VehicleErrorInfo findByErrorCode(String errorCode) {
        return vehicleErrorRepository.findByErrorCode(errorCode);
    }

    public Object getVehicleDefectFromVehicleService(){
//        UriComponents uriComponents = UriComponentsBuilder.newInstance()
//                .scheme("http")
//                .host("localhost:8081")
//                .path("/api/vehicles/error-information/" + code)
//                .build();
//
//        String url = uriComponents.toUriString();
//        System.out.println("URL " + url);
//        RestTemplate restTemplate = new RestTemplate();
//
//        VehicleDemoData response = restTemplate.getForObject(url, VehicleDemoData.class);
return null;
    }

}
