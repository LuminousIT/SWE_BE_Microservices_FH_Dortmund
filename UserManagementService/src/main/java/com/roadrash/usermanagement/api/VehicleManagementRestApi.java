package com.roadrash.usermanagement.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roadrash.usermanagement.domain.DefectComponent;
import com.roadrash.usermanagement.domain.VehicleDemoData;
import com.roadrash.usermanagement.domain.VehicleErrorInfo;
import com.roadrash.usermanagement.domain.VehicleInfo;
import com.roadrash.usermanagement.service.VehicleErrorInfoService;
import com.roadrash.usermanagement.service.VehicleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/vehicles")
public class VehicleManagementRestApi {

    @Autowired
    private VehicleInfoService vehicleInfoService;

    @Autowired
    private VehicleErrorInfoService vehicleErrorInfoService;

    public VehicleManagementRestApi(VehicleInfoService vehicleInfoService, VehicleErrorInfoService vehicleErrorInfoService) {
        this.vehicleInfoService = vehicleInfoService;
        this.vehicleErrorInfoService = vehicleErrorInfoService;
    }

    @GetMapping
    public List<VehicleInfo> getAllVehicles() {
        return vehicleInfoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<VehicleInfo> getVehicleById(@PathVariable Long id) {
        return vehicleInfoService.findById(id);
    }

    @PostMapping
    public VehicleInfo createVehicle(@RequestBody VehicleInfo vehicleInfo) {
        return vehicleInfoService.createVehicle(vehicleInfo);
    }

    @PutMapping("/{id}")
    public VehicleInfo updateUser(@PathVariable Long id, @RequestBody VehicleInfo vehicleInfo) {
        return vehicleInfoService.updateVehicle(id, vehicleInfo);
    }

    @GetMapping("/information/all")
    public VehicleDemoData[] getVehicleData(Model model) throws IOException {
        File jsonFile = new ClassPathResource("vehicleInfo.json").getFile();
        ObjectMapper objectMapper = new ObjectMapper();
        VehicleDemoData[] testData = objectMapper.readValue(jsonFile, VehicleDemoData[].class);
        return testData;
    }

    @PostMapping("/information")
    public DefectComponent getVehicleSupportInformation(@RequestBody VehicleErrorInfo vehicleErrorInfo) {
          return vehicleErrorInfoService.reportVehicleError(vehicleErrorInfo);

    }

    @GetMapping("/information/{id}")
    public VehicleDemoData getVehicleDataByUserID(@PathVariable int id) throws IOException {
        File jsonFile = new ClassPathResource("vehicleInfo.json").getFile();
        ObjectMapper objectMapper = new ObjectMapper();
        VehicleDemoData[] testData = objectMapper.readValue(jsonFile, VehicleDemoData[].class);

        for (VehicleDemoData vehicle : testData) {
            if(vehicle.getUserID() == id){
                return vehicle;
            }
        }
        return null;
    }

    @PostMapping("/error-information/log")
    public VehicleErrorInfo logVehicleError(@RequestBody VehicleErrorInfo vehicleErrorInformation)  {
       return vehicleErrorInfoService.logVehicleError(vehicleErrorInformation);
    }

    @GetMapping("/error-information/log")
    public List<VehicleErrorInfo> getAllLogs() {
        return vehicleErrorInfoService.findAll();
    }


    @GetMapping("/error-information/log/{errorCode}")
    public VehicleErrorInfo getLogByErrorCode(@PathVariable String errorCode) {
        return vehicleErrorInfoService.findByErrorCode(errorCode);
    }


//    @GetMapping("/error-information/{code}")
//    public VehicleDemoData getVehicleDataByErrorCode(@PathVariable String code) throws IOException {
//        File jsonFile = new ClassPathResource("vehicleInfo.json").getFile();
//        ObjectMapper objectMapper = new ObjectMapper();
//        VehicleDemoData[] testData = objectMapper.readValue(jsonFile, VehicleDemoData[].class);
//
//        for (VehicleDemoData vehicle : testData) {
//            if(vehicle.getErrorCode().equals(code)){
//                return vehicle;
//            }
//        }
//
//        return null;
//    }
}
