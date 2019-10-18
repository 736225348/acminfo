package com.dqsy.algorithmhome.user.controller;

import com.dqsy.algorithmhome.user.domain.User;
import com.dqsy.algorithmhome.user.domain.daom;
import com.dqsy.algorithmhome.user.domain.peo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/luo")
public class UserController {

    @RequestMapping("/login/{id}")
    public String login(@PathVariable(name = "id") String a) {
        System.out.println(a);
        return "login";
    }

    @RequestMapping("/succ")
    public String succ(String da) {
        System.out.println(da);
        return "succ";
    }

    @RequestMapping("/succ1")
    public String succ1(Model model) {
        //这句画的底层会将这个键值对 存在request 中
        model.addAttribute("msg", "翔泽");
        //r
        return "succ1";
    }


    @RequestMapping("/succ2")
    public String succ2(@RequestBody peo peo) {
        //这句画的底层会将这个键值对 存在request 中
        System.out.println(peo);
        return "login";
    }


}
