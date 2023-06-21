package com.roadrash.usermanagement.service;

import com.roadrash.usermanagement.domain.LoginDTO;
import com.roadrash.usermanagement.domain.UserAccountDomain;
//import com.roadrash.usermanagement.domain.UserAccountDomainDomain;
//import com.roadrash.usermanagement.repo.UserAccountDomainRepository;
import com.roadrash.usermanagement.domain.UserInfo;
//import com.roadrash.usermanagement.repo.UserAccountRepository;
import com.roadrash.usermanagement.repo.UserInfoRepository;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserManagementService {

    public UserInfoRepository userInfoRepository;
//    Logger logger = LoggerFactory.(UserManagementService.class);
    Logger logger = LoggerFactory.getLogger(UserManagementService.class);
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

    public Object login(LoginDTO userdata){
        logger.info(userdata.password);
        logger.info(userdata.getPassword());
        logger.info("reached");
        Map<String, Object> obj = new HashMap<>();
        if (userdata.getPassword() == null && userdata.getUsername().trim().isEmpty()  || userdata.password == null && userdata.password.trim().isEmpty() ) {
            // return "Username or Password cannot be empty";;
//            return Object();
            obj.put("status", "0");
            obj.put("message", "Username or Password cannot be empty");
            logger.info("user/pass cannot be empty", userdata);
            return obj;
        }

        UserInfo user = userInfoRepository.findByUsername(userdata.username);
        if (user == null) {
            obj.put("status", "0");
            obj.put("message", "User does not exist");
            logger.info("user does not exist", userdata);
            return obj;
        }

//            return null;
//        TODO: Encrypt password in DB. Decrypt then compare.
        if (!userdata.password.equals(user.getPassword())) {
//            return "Username / Password incorrect";
            obj.put("status", "0");
            obj.put("message", "Username / Password incorrect");
            logger.info(userdata.password);
            logger.info(user.getPassword());
            logger.info("Username / Password incorrect", userdata.password);
            return obj;
        }
        logger.info("end ", user);
        System.out.println(user);
        System.out.println("hello dear");
        obj.put("status", "1");
        obj.put("message", user);
        return obj;
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

    public UserInfo findByUsername(String username) {
        return userInfoRepository.findByUsername(username);
    }

    public void deleteById(UUID userId) {
//        UserAccountDomainRepository.deleteById(userId);
    }

    // Add more methods as needed
}
