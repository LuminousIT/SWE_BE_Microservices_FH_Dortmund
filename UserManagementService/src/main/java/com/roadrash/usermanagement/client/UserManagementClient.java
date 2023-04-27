package com.roadrash.usermanagement.client;

import com.roadrash.usermanagement.domain.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@FeignClient(name = "another-microservice", url = "${another-microservice.url}")
public interface UserManagementClient {

    @GetMapping("/api/some-resource/{userId}")
    UserInfo getSomeResourceFromAnotherMicroservice(@PathVariable("userId") Long userId);

    // Add more methods to interact with other microservices as needed
}
