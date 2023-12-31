package com.roadrash.usermanagement.domain;

import org.apache.catalina.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserInfo {

    @Id
    @GeneratedValue
    private Long Id;

    private String name;
    private String phone;
    private String email;

    private String password;
    private String username;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
//    private Long vehicleInfoID;

    public UserInfo(){

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserInfo(String name, String phone, String email, String username, String password){
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.username = username;
        this.password = password;
//        this.vehicleInfo = vehicleInfo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

//    public VehicleInfo getVehicleInfo() {
//        return vehicleInfo;
//    }
//
//    public void setVehicleInfo(VehicleInfo vehicleInfo) {
//        this.vehicleInfo = vehicleInfo;
//    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
