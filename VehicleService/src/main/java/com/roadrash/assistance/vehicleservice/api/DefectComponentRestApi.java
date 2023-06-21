package com.roadrash.assistance.vehicleservice.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonObject;
import com.roadrash.assistance.vehicleservice.domain.DefectComponent;
import com.roadrash.assistance.vehicleservice.domain.Place;
import com.roadrash.assistance.vehicleservice.domain.VehicleDemoData;
import com.roadrash.assistance.vehicleservice.service.DefectComponentService;
import com.roadrash.assistance.vehicleservice.service.PlacesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/vehicle-fix")
public class DefectComponentRestApi {
    @Autowired
    private DefectComponentService defectComponentService;

    @Autowired
    private PlacesService placesService;
    public DefectComponentRestApi(DefectComponentService defectComponentService, PlacesService placesService) {
        this.defectComponentService = defectComponentService;
        this.placesService = placesService;
    }

    @GetMapping("/place")
    public ArrayList<Place> getPlace() {
        return placesService.search("restaurant", 123, 456, 20);
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
        return defectComponentService.getDefectComponentVehData();
    }

    @GetMapping("/information/{code}")
    public DefectComponent getDefectComponentDataByErrorCode(@PathVariable String code, Model model) throws IOException {
        // fetch record of defect components
       return defectComponentService.getDefectComponentByCode(code);
    }

}
