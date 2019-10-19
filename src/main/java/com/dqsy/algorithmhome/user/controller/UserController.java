package com.dqsy.algorithmhome.user.controller;


import com.dqsy.algorithmhome.user.domain.User;
import com.dqsy.algorithmhome.user.service.UserService;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Resource(name = "UserService")
    UserService userService;


    @GetMapping("/index")
    public String login() {
        return "index";
    }

    @GetMapping("/main")
    public String succ() {
        return "main";
    }


    /**
     * 判断是否可以登陆，如果登陆成功的话，在sesstion中存
     *
     * @param user
     * @param request
     * @return
     */
    @ResponseBody
    @PostMapping("/proving")
    public Boolean proving(User user, HttpServletRequest request) {
        Boolean aBoolean = userService.CheckUser(user);
        HttpSession session = request.getSession();
        if (aBoolean == true) {
            session.setAttribute("username", user.getUsername());
        }

        return aBoolean;
    }
}
