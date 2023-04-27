package com.roadrash.usermanagement.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roadrash.usermanagement.domain.UserInfo;
import com.roadrash.usermanagement.domain.VehicleDemoData;
import com.roadrash.usermanagement.domain.VehicleInfo;
import com.roadrash.usermanagement.service.VehicleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleManagementRestApi {

    @Autowired
    private VehicleInfoService vehicleInfoService;
    public VehicleManagementRestApi(VehicleInfoService vehicleInfoService) {
        this.vehicleInfoService = vehicleInfoService;
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

    @GetMapping("/information")
    public VehicleDemoData[] getVehicleData(Model model) throws IOException {
        File jsonFile = new ClassPathResource("vehicleInfo.json").getFile();
        ObjectMapper objectMapper = new ObjectMapper();
        VehicleDemoData[] testData = objectMapper.readValue(jsonFile, VehicleDemoData[].class);

//        model.addAttribute("vehicleBreakdowns", testData);
//
//        for (VehicleDemoData vehicle : testData) {
//            model.addAttribute("model", vehicle.getModel());
//            model.addAttribute("timestamp", vehicle.getTimestamp().toString());
//            model.addAttribute("location", (vehicle.getLocation().getLatitude() + "(lat) " + vehicle.getLocation().getLongitude() + "(lon)").toString());
//            model.addAttribute("Hardware Fault Code", vehicle.getErrorCode());
//        }

        return testData;
    }
}
