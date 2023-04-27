package com.roadrash.usermanagement.service;

import com.roadrash.usermanagement.domain.UserAccountDomain;
//import com.roadrash.usermanagement.domain.UserAccountDomainDomain;
//import com.roadrash.usermanagement.repo.UserAccountDomainRepository;
import com.roadrash.usermanagement.domain.UserInfo;
//import com.roadrash.usermanagement.repo.UserAccountRepository;
import com.roadrash.usermanagement.repo.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserManagementService {

    public UserInfoRepository userInfoRepository;
    public UserManagementService(UserInfoRepository userInfoRepository){
        this.userInfoRepository = userInfoRepository;
    }

//    @Autowired
//    private UserAccountRepository UserAccountDomainRepository;
//    private UserInfoRepository UserInfoRepository;

    public List<UserInfo> findAll() {
        return userInfoRepository.findAll();
    }

    public Optional<UserInfo> findById(Long userId) {
        return userInfoRepository.findById(userId);
    }

    public UserInfo createUser(UserInfo userAccountDomain){
        return userInfoRepository.save(userAccountDomain);
    }

    public UserInfo updateUser(Long id, UserInfo userInfo){
        return userInfoRepository.save(userInfo);
    }

    public UserInfo save(UserInfo userInfo) {
        return userInfoRepository.save(userInfo);
    }

    public void deleteUser(Long userId) {
        userInfoRepository.deleteById(userId);
    }

    public void deleteById(UUID userId) {
//        UserAccountDomainRepository.deleteById(userId);
    }

    // Add more methods as needed
}
