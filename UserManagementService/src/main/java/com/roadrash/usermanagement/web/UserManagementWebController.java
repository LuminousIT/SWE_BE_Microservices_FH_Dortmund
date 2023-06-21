package com.roadrash.usermanagement.web;

import com.roadrash.usermanagement.domain.UserAccountDomain;
import com.roadrash.usermanagement.service.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/usermanagement")
public class UserManagementWebController {

    @Autowired
    private UserManagementService userManagementService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userManagementService.findAll());
        return "usermanagement/list";
    }

}
