package com.ilacad.aop.aopexercise.controller;

import com.ilacad.aop.aopexercise.dto.UserDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/add-user")
    public String getUser(Model model) {

        model.addAttribute("userDto", new UserDto());

        return "user";
    }

    @PostMapping("/add-user")
    public String addUser(@Valid @ModelAttribute(name = "userDto") UserDto userDto) {

        return "redirect:/add-user?success";
    }

}
