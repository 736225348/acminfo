package com.dqsy.algorithmhome.user.controller;

import com.dqsy.algorithmhome.user.domain.User;
import com.dqsy.algorithmhome.user.domain.judge;
import com.dqsy.algorithmhome.user.service.UserService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Source;
import java.io.File;
import java.io.IOException;
import java.util.List;

@SessionAttributes("ayUser")
@Controller
public class UserController {
    @Resource(name = "UserService")
    UserService userService;

    @GetMapping("/index")
    public String login() {
        return "index";
    }

    @GetMapping("/main")
    public String succ(@SessionAttribute User ayUser) {
        System.out.println(ayUser);
        return "main";
    }

    /**
     * 判断是否可以登陆，如果登陆成功的话，在sesstion中存
     * 登陆成功 返回真
     *
     * @param user
     * @return
     */
    @ResponseBody
    @PostMapping("/proving")
    public Boolean proving(User user, HttpServletRequest request) {
        User u_ser = userService.CheckUser(user);
        System.out.println(u_ser);
        HttpSession session = request.getSession();
        if (u_ser == null || u_ser.getPlayerID() == 3) {
//           表示没有此账号
            return false;
        } else {
            //登陆成功 存入sesstion
            session.setAttribute("ayUser", u_ser);
            return true;
        }
    }


    @PostMapping("fileup")
    public String fileup(HttpServletRequest request, @RequestParam("fileup") List<MultipartFile> fileup) throws IOException {
        //上传文件路径
        if (!fileup.isEmpty() && fileup.size() > 0) {
            for (MultipartFile file : fileup) {
                String org = file.getOriginalFilename();
                String dirPath = request.getServletContext().getRealPath("/upload/");
                System.out.println(dirPath);
                File filepath = new File(dirPath);
                if (!filepath.exists()) {
                    filepath.mkdirs();
                }
                try {
                    file.transferTo(new File(dirPath + org));
                } catch (Exception e) {

                }
                return "index";
            }
        }
        return "index";
    }

    @GetMapping("test")
    public String test() {
        return "test";

    }

    @GetMapping("register")
    public String register() {
        return "register";

    }

    @ResponseBody
    @PostMapping("registerUser")
    public judge registerUser(User user) {
        System.out.println(user);
        int i = userService.AddUser(user);
        if (i == 0) {
            return new judge(false);
        } else {
            return new judge(true);

        }


    }
}