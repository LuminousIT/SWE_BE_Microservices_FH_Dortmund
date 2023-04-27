package com.roadrash.assistance.vehicleservice.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class DefectComponent {
    @Id
    @GeneratedValue
    private Long id;

    private Long vehicleID;

    private String defectComponentType;

    private boolean isDefect;

    public DefectComponent(Long vehicleID, String defectComponentType, boolean isDefect){

    }
}
