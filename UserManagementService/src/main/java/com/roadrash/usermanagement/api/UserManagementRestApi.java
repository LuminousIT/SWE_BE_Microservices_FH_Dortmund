package com.roadrash.usermanagement.api;

import com.roadrash.usermanagement.domain.UserAccount;
import com.roadrash.usermanagement.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserManagementRestApi {
    @Autowired
    private UserManagementService userManagementService;

    @GetMapping
    public List<UserAccount> getAllUsers() {
        return userManagementService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserAccount getUserById(@PathVariable UUID id) {
        return userManagementService.getUserById(id);
    }

    @PostMapping
    public UserAccount createUser(@RequestBody UserAccount userAccount) {
        return userManagementService.createUser(userAccount);
    }

    @PutMapping("/{id}")
    public UserAccount updateUser(@PathVariable UUID id, @RequestBody UserAccount userAccount) {
        return userManagementService.updateUser(id, userAccount);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable UUID id) {
        userManagementService.deleteUser(id);
    }
}
