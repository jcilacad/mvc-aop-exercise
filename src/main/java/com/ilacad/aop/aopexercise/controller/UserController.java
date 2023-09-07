package com.ilacad.aop.aopexercise.controller;

import com.ilacad.aop.aopexercise.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/add-user")
    public String addUser(Model model) {

        model.addAttribute("userDto", new UserDto());
        
        return "add-user";
    }
}
