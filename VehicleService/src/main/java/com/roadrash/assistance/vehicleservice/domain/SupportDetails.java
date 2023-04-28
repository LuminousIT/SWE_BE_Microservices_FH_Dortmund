package com.roadrash.assistance.vehicleservice.domain;

import java.util.Date;

public class SupportDetails {
    private Long id;

    private String errorCode;
    private String name;
    private String supportType;
    private boolean isSupportDeployed;
    private GeoLocation vehicleGeoLocation;
    private String supportPersonName;
    private String supportPersonPhone;
    private Date estimatedTimeOfSupportArrival;

    public SupportDetails(){

    }

}
