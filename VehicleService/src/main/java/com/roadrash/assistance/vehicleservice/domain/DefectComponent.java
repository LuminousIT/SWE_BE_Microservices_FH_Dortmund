package com.roadrash.assistance.vehicleservice.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class DefectComponent {
    @Id
    @GeneratedValue
    private Long id;

    private Long vehicleID;

    @JsonProperty("defectComponentType")
    private String defectComponentType;

    @JsonProperty("supportID")
    private String supportID;

    public String getSupportID() {
        return supportID;
    }

    public void setSupportID(String supportID) {
        this.supportID = supportID;
    }

    public String getSupportTel() {
        return supportTel;
    }

    public void setSupportTel(String supportTel) {
        this.supportTel = supportTel;
    }

    @JsonProperty("supportTel")
    private String supportTel;

    @JsonProperty("isComponentAvailable")
    private boolean isComponentAvailable;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public GeoLocation getLocation() {
        return location;
    }

    public void setLocation(GeoLocation location) {
        this.location = location;
    }

    private String errorCode;

    @JsonProperty("userID")
    private String userID;

    @OneToOne
    @JoinColumn(name = "id")
//    @JsonProperty("location")
    private GeoLocation location;

    public DefectComponent(){

    }

    public DefectComponent(Long vehicleID, String defectComponentType, boolean isComponentAvailable, String supportTel){
        this.vehicleID = vehicleID;
        this.defectComponentType = defectComponentType;
        this.isComponentAvailable = isComponentAvailable;
        this.supportID = "";
        this.supportTel = supportTel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(Long vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getDefectComponentType() {
        return defectComponentType;
    }

    public void setDefectComponentType(String defectComponentType) {
        this.defectComponentType = defectComponentType;
    }

    public boolean isComponentAvailable() {
        return isComponentAvailable;
    }

    public void setComponentAvailable(boolean componentAvailable) {
        isComponentAvailable = componentAvailable;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

}
