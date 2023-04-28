package com.roadrash.assistance.vehicleservice.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.roadrash.assistance.vehicleservice.domain.DefectComponent;
import com.roadrash.assistance.vehicleservice.domain.VehicleDemoData;
import com.roadrash.assistance.vehicleservice.service.DefectComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vehicle-fix")
public class DefectComponentRestApi {
    @Autowired
    private DefectComponentService defectComponentService;
    public DefectComponentRestApi(DefectComponentService defectComponentService) {
        this.defectComponentService = defectComponentService;
    }

    @GetMapping
    public List<DefectComponent> getAllDefectComponent() {
        return defectComponentService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<DefectComponent> getDefectComponentById(@PathVariable Long id) {
        return defectComponentService.findById(id);
    }

    @PostMapping
    public DefectComponent createVehicle(@RequestBody DefectComponent defectComponent) {
        return defectComponentService.createDefectComponent(defectComponent);
    }

    @PutMapping("/{id}")
    public DefectComponent updateDefectComponent(@PathVariable Long id, @RequestBody DefectComponent defectComponent) {
        return defectComponentService.updateVehicle(id, defectComponent);
    }

    @GetMapping("/information")
    public DefectComponent[] getDefectComponentVehicleData(Model model) throws IOException {
        File jsonFile = new ClassPathResource("./static/defectComponentData.json").getFile();
        ObjectMapper objectMapper = new ObjectMapper();
        DefectComponent[] defectComponentData = objectMapper.readValue(jsonFile, DefectComponent[].class);

        return defectComponentData;
    }

    @GetMapping("/information/{code}")
    public DefectComponent getDefectComponentDataByErrorCode(@PathVariable String code, Model model) throws IOException {
        // fetch record of defect components
        File jsonFile = new ClassPathResource("./static/defectComponentData.json").getFile();
        ObjectMapper objectMapper = new ObjectMapper();
        DefectComponent[] testData = objectMapper.readValue(jsonFile, DefectComponent[].class);
//    System.out.println("error code " + code + " " + model.toString());
        for (DefectComponent defectComponent : testData) {
            if (defectComponent.getErrorCode().toString().equals(code)) {
                // fetch record of vehicle with that error code from UserMgmtService
                VehicleDemoData vehicleDefectInfo = defectComponentService.getDefectVehicleInformationByErrorCode(code);
                defectComponent.setUserID(vehicleDefectInfo.getUserID().toString());
                defectComponent.setLocation(vehicleDefectInfo.getLocation());
//                defectComponent.setUserID(defect.get("userID"));

                model.addAttribute("errorCode", defectComponent.getErrorCode());
                model.addAttribute("isComponentAvailable", defectComponent.isComponentAvailable());
                model.addAttribute("defectComponentType", defectComponent.getDefectComponentType());
//                return "defectComponent";
                return defectComponent;
            }
        }



        return null;
    }

    // TODO: Dispatch / Respond with SupportDetails
}
