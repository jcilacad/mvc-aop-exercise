package com.ilacad.aop.aopexercise.controller;

import com.ilacad.aop.aopexercise.dto.UserDto;
import com.ilacad.aop.aopexercise.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add-user")
    public String getUser(Model model) {

        model.addAttribute("userDto", new UserDto());

        return "user";
    }

    @PostMapping("/add-user")
    public String addUser(@Valid @ModelAttribute(name = "userDto") UserDto userDto, Model model, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("userDto", userDto);
            return "user";
        }

        userService.addUser(userDto);

        return "redirect:/add-user?success";
    }

}
