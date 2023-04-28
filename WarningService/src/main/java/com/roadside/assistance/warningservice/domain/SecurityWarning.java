package com.roadside.assistance.warningservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SecurityWarning {

    @Id
    @GeneratedValue
    private Long id;

    private String vehicleLocation;
    private int unauthorizedAccessAttempts;
    private String sensorData;
    private boolean alarmStatus;
    private boolean vehicleTrackingCapability;
    private String emergencyAssistanceContact;

    public SecurityWarning() {
    }

    public SecurityWarning(String vehicleLocation, int unauthorizedAccessAttempts, String sensorData,
                           boolean alarmStatus, boolean vehicleTrackingCapability, String emergencyAssistanceContact) {
        this.vehicleLocation = vehicleLocation;
        this.unauthorizedAccessAttempts = unauthorizedAccessAttempts;
        this.sensorData = sensorData;
        this.alarmStatus = alarmStatus;
        this.vehicleTrackingCapability = vehicleTrackingCapability;
        this.emergencyAssistanceContact = emergencyAssistanceContact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVehicleLocation() {
        return vehicleLocation;
    }

    public void setVehicleLocation(String vehicleLocation) {
        this.vehicleLocation = vehicleLocation;
    }

    public int getUnauthorizedAccessAttempts() {
        return unauthorizedAccessAttempts;
    }

    public void setUnauthorizedAccessAttempts(int unauthorizedAccessAttempts) {
        this.unauthorizedAccessAttempts = unauthorizedAccessAttempts;
    }

    public String getSensorData() {
        return sensorData;
    }

    public void setSensorData(String sensorData) {
        this.sensorData = sensorData;
    }

    public boolean isAlarmStatus() {
        return alarmStatus;
    }

    public void setAlarmStatus(boolean alarmStatus) {
        this.alarmStatus = alarmStatus;
    }

    public boolean isVehicleTrackingCapability() {
        return vehicleTrackingCapability;
    }

    public void setVehicleTrackingCapability(boolean vehicleTrackingCapability) {
        this.vehicleTrackingCapability = vehicleTrackingCapability;
    }

    public String getEmergencyAssistanceContact() {
        return emergencyAssistanceContact;
    }

    public void setEmergencyAssistanceContact(String emergencyAssistanceContact) {
        this.emergencyAssistanceContact = emergencyAssistanceContact;
    }
}
