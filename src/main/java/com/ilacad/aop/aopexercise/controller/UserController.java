package com.ilacad.aop.aopexercise.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/add-user")
    public String addUser() {
        return "add-user";
    }
}
