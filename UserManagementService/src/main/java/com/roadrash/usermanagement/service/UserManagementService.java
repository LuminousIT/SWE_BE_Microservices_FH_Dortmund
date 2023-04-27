package com.roadrash.usermanagement.service;

import com.roadrash.usermanagement.domain.UserAccount;
import com.roadrash.usermanagement.repo.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserManagementService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    public List<UserAccount> findAll() {
        return userAccountRepository.findAll();
    }

    public Optional<UserAccount> findById(UUID userId) {
        return userAccountRepository.findById(userId);
    }

    public UserAccount save(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    public void deleteById(UUID userId) {
        userAccountRepository.deleteById(userId);
    }

    // Add more methods as needed
}
