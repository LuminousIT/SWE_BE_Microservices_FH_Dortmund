package com.roadside.assistance.configurationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigurationServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(com.roadside.assistance.configurationservice.ConfigurationServiceApplication.class, args);
    }

}
