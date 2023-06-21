package com.roadrash.assistance.vehicleservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.roadrash.assistance.vehicleservice.domain.DefectComponent;
import com.roadrash.assistance.vehicleservice.domain.VehicleDemoData;
import com.roadrash.assistance.vehicleservice.repository.DefectComponentRepository;
import org.json.JSONObject;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DefectComponentService {
    DefectComponentRepository defectComponentRepository;
    public DefectComponentService(DefectComponentRepository defectComponentRepository){
        this.defectComponentRepository = defectComponentRepository;
    }

    public List<DefectComponent> findAll() {
        return defectComponentRepository.findAll();
    }

    public Optional<DefectComponent> findById(Long userId) {
        return defectComponentRepository.findById(userId);
    }

    public DefectComponent createDefectComponent(DefectComponent defectComponent){
        return defectComponentRepository.save(defectComponent);
    }

    public DefectComponent updateVehicle(Long id, DefectComponent defectComponent){
        return defectComponentRepository.save(defectComponent);
    }

    public DefectComponent save(DefectComponent defectComponent) {
        return defectComponentRepository.save(defectComponent);
    }

    public VehicleDemoData getDefectVehicleInformationByErrorCode(String code){
        UriComponents uriComponents = UriComponentsBuilder.newInstance()
                .scheme("http")
                .host("localhost:8081")
                .path("/api/vehicles/error-information/" + code)
                .build();

        String url = uriComponents.toUriString();
        System.out.println("URL " + url);
        RestTemplate restTemplate = new RestTemplate();

        VehicleDemoData response = restTemplate.getForObject(url, VehicleDemoData.class);
        return response;
    }

    public DefectComponent getDefectComponentByCode(String code) {
        try {
            File jsonFile = new ClassPathResource("./static/defectComponentData.json").getFile();
            ObjectMapper objectMapper = new ObjectMapper();
            DefectComponent[] testData = objectMapper.readValue(jsonFile, DefectComponent[].class);
            for (DefectComponent defectComponent : testData) {
                if (defectComponent.getErrorCode().toString().equals(code)) {
                    return defectComponent;
                }
            }
            return null;
        } catch(Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public DefectComponent[] getDefectComponentVehData() throws IOException {
        File jsonFile = new ClassPathResource("./static/defectComponentData.json").getFile();
        ObjectMapper objectMapper = new ObjectMapper();
        DefectComponent[] defectComponentData = objectMapper.readValue(jsonFile, DefectComponent[].class);

        return defectComponentData;
    }
}
