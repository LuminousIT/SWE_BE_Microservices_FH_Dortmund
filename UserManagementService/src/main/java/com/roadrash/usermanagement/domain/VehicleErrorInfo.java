package com.roadrash.usermanagement.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class VehicleErrorInfo {
    @Id
    @GeneratedValue
    private Long id;

    private String userID;

    private String errorCode;

    private Long vehicleID;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Column(updatable = false)
    @CreationTimestamp
    private Date createdAt;

    private String latitude;

    private String longitude;

    public VehicleErrorInfo(){

    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VehicleErrorInfo(String userID, String errorCode, Long vehicleID, String latitude, String longitude){
        this.userID = userID;
        this.errorCode = errorCode;
        this.vehicleID = vehicleID;
        this.latitude = latitude;
        this.longitude = longitude;
        this.createdAt = new Date();
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public Long getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(Long vehicleID) {
        this.vehicleID = vehicleID;
    }


}
