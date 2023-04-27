package com.roadrash.usermanagement.api;

import com.roadrash.usermanagement.domain.UserAccountDomain;
import com.roadrash.usermanagement.domain.UserInfo;
import com.roadrash.usermanagement.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserManagementRestApi {
    @Autowired
    private UserManagementService userManagementService;

    public UserManagementRestApi(UserManagementService userManagementService){
        this.userManagementService = userManagementService;
    }

    @GetMapping
    public List<UserInfo> getAllUsers() {
        return userManagementService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<UserInfo> getUserById(@PathVariable Long id) {
        return userManagementService.findById(id);
    }

    @PostMapping
    public UserInfo createUser(@RequestBody UserInfo UserInfo) {
        return userManagementService.createUser(UserInfo);
    }

    @PutMapping("/{id}")
    public UserInfo updateUser(@PathVariable Long id, @RequestBody UserInfo UserInfo) {
        return userManagementService.updateUser(id, UserInfo);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userManagementService.deleteUser(id);
    }
}
