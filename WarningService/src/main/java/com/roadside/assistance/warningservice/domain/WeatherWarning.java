package com.roadside.assistance.warningservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WeatherWarning {
    @Id
    @GeneratedValue
    private Long id;
    private double temperature;
    private double humidity;
    private String precipitationType;
    private double precipitationIntensity;
    private double windSpeed;
    private String windDirection;
    private String roadSurfaceCondition;
    private double visibility;

    public WeatherWarning() {}

    public WeatherWarning(double temperature, double humidity, String precipitationType,
                          double precipitationIntensity, double windSpeed, String windDirection,
                          String roadSurfaceCondition, double visibility) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.precipitationType = precipitationType;
        this.precipitationIntensity = precipitationIntensity;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.roadSurfaceCondition = roadSurfaceCondition;
        this.visibility = visibility;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public String getPrecipitationType() {
        return precipitationType;
    }

    public void setPrecipitationType(String precipitationType) {
        this.precipitationType = precipitationType;
    }

    public double getPrecipitationIntensity() {
        return precipitationIntensity;
    }

    public void setPrecipitationIntensity(double precipitationIntensity) {
        this.precipitationIntensity = precipitationIntensity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getRoadSurfaceCondition() {
        return roadSurfaceCondition;
    }

    public void setRoadSurfaceCondition(String roadSurfaceCondition) {
        this.roadSurfaceCondition = roadSurfaceCondition;
    }

    public double getVisibility() {
        return visibility;
    }

    public void setVisibility(double visibility) {
        this.visibility = visibility;
    }
}
