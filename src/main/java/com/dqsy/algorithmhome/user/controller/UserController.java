package com.dqsy.algorithmhome.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/login2")
    public String login2() {
        return "login2";

    }
}
