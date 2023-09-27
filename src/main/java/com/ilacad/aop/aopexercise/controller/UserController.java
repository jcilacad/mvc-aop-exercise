package com.ilacad.aop.aopexercise.controller;

import com.ilacad.aop.aopexercise.dto.EmailDto;
import com.ilacad.aop.aopexercise.dto.UserDto;
import com.ilacad.aop.aopexercise.entity.User;
import com.ilacad.aop.aopexercise.service.UserService;
import jakarta.validation.Valid;
import org.hibernate.collection.spi.PersistentBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add-user")
    public String getUser(Model model) {

        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);

        return "user";
    }

    @PostMapping("/add-user")
    public String addUser(@Valid @ModelAttribute(name = "userDto") UserDto userDto, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "user";
        }

        userService.addUser(userDto, true);

        // Calling getter and setter for name and service code for development.

        // Setter inside user service impl
        userService.setName("John");
        userService.setServiceCode("Agent 444");

        // Getter inside user service impl
        userService.getName();
        userService.getServiceCode();

        return "redirect:/add-user?success";
    }

    @GetMapping("/users-list")
    public String getAllUsers(Model model) {

        List<User> users = userService.findAllUsers();

        model.addAttribute("users", users);
        model.addAttribute("emailDto", new EmailDto());

        return "users-list";
    }


    @PostMapping("/find-user")
    public String findUserByEmail(@Valid @ModelAttribute("emailDto") EmailDto emailDto,
                                  BindingResult result,
                                  Model model) {

        if (result.hasErrors()) {
            List<User> users = userService.findAllUsers();
            model.addAttribute("users", users);
            model.addAttribute("emailDto", emailDto);

            return "users-list";
        }

        try {
            User user = userService.findUserByEmail(emailDto);
            List<User> users = new ArrayList<>();
            users.add(user);
            model.addAttribute("users", user);
        } catch (RuntimeException e) {
            System.out.println("Exception from main app for finding user - "  + e.getMessage());
            return "redirect:/users-list";
        }

        return "users-list";
    }
}
