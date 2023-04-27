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

//    @GetMapping("/add")
//    public String showAddUserForm(Model model) {
//        model.addAttribute("userAccount", new UserAccount());
//        return "usermanagement/add";
//    }
//
//    @PostMapping("/add")
//    public String addUser(UserAccount userAccount) {
//        userManagementService.save(userAccount);
//        return "redirect:/usermanagement";
//    }
//
//    @GetMapping("/edit")
//    public String showEditUserForm(@RequestParam("id") UUID userId, Model model) {
//        Optional<UserAccount> userAccount = userManagementService.findById(userId);
//        userAccount.ifPresent(account -> model.addAttribute("userAccount", account));
//        return "usermanagement/edit";
//    }
//
//    @PostMapping("/edit")
//    public String editUser(UserAccount userAccount) {
//        userManagementService.save(userAccount);
//        return "redirect:/usermanagement";
//    }
//
//    @GetMapping("/delete")
//    public String deleteUser(@RequestParam("id") UUID userId) {
//        userManagementService.deleteById(userId);
//        return "redirect:/usermanagement";
//    }

    // Add more methods as needed
}
