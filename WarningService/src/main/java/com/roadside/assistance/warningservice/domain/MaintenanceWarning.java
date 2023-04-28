package com.roadside.assistance.warningservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class MaintenanceWarning {
    @Id
    @GeneratedValue
    private Long id;
    private Long mileageSinceLastService;
    private Long timeSinceLastService;
    private Double engineOilLevel;
    private Double tirePressure;
    private Double batteryChargeLevel;

    public MaintenanceWarning() {}

    public MaintenanceWarning(Long id, Long mileageSinceLastService, Long timeSinceLastService,
                              Double engineOilLevel, Double tirePressure, Double batteryChargeLevel) {
        this.id = id;
        this.mileageSinceLastService = mileageSinceLastService;
        this.timeSinceLastService = timeSinceLastService;
        this.engineOilLevel = engineOilLevel;
        this.tirePressure = tirePressure;
        this.batteryChargeLevel = batteryChargeLevel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMileageSinceLastService() {
        return mileageSinceLastService;
    }

    public void setMileageSinceLastService(Long mileageSinceLastService) {
        this.mileageSinceLastService = mileageSinceLastService;
    }

    public Long getTimeSinceLastService() {
        return timeSinceLastService;
    }

    public void setTimeSinceLastService(Long timeSinceLastService) {
        this.timeSinceLastService = timeSinceLastService;
    }

    public Double getEngineOilLevel() {
        return engineOilLevel;
    }

    public void setEngineOilLevel(Double engineOilLevel) {
        this.engineOilLevel = engineOilLevel;
    }

    public Double getTirePressure() {
        return tirePressure;
    }

    public void setTirePressure(Double tirePressure) {
        this.tirePressure = tirePressure;
    }

    public Double getBatteryChargeLevel() {
        return batteryChargeLevel;
    }

    public void setBatteryChargeLevel(Double batteryChargeLevel) {
        this.batteryChargeLevel = batteryChargeLevel;
    }
}
