package com.roadrash.usermanagement.client;

import com.roadrash.usermanagement.domain.UserAccount;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "another-microservice", url = "${another-microservice.url}")
public interface UserManagementClient {

    @GetMapping("/api/some-resource/{userId}")
    UserAccount getSomeResourceFromAnotherMicroservice(@PathVariable("userId") UUID userId);

    // Add more methods to interact with other microservices as needed
}
