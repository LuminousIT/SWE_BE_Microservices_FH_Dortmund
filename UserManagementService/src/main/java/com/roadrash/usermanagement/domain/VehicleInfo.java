package com.roadrash.usermanagement.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VehicleInfo {

    public VehicleInfo(){

    }

    @Id
    @GeneratedValue
    private Long id;

    private String vehicleName;

    private String vehicleModel;

    private VehicleType vehicleType;

    private Long userID;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public VehicleInfo (String vehicleName, String vehicleModel, VehicleType vehicleType, Long userID){
        this.vehicleName = vehicleName;
        this.vehicleModel = vehicleModel;
        this.vehicleType = vehicleType;
        this.userID = userID;
    }

}

enum VehicleType {
    CAR, TRUCK, MOTOCYCLE, SEDAN
}
