package com.dqsy.algorithmhome.user.controller;

import com.dqsy.algorithmhome.user.domain.User;
import com.dqsy.algorithmhome.user.domain.judge;
import com.dqsy.algorithmhome.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
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
    //注入service
    @Resource(name = "UserService")
    UserService userService;

    //转到 登陆页面
    @GetMapping("/index")
    public String login() {
        return "index";
    }

    //转到 主页面
    @GetMapping("/main")
    public String succ() {
        return "main";
    }

    // 测试 进入主页 显示部分个人信息
    @ResponseBody
    @GetMapping("/testInfo")
    public User testInfo(@SessionAttribute User ayUser) {
        return ayUser;
    }


    /**
     * 判断是否可以登陆，如果登陆成功的话，在sesstion中存
     * 登陆成功 返回真
     *
     * @param user
     * @return
     */
    @ResponseBody
    @PostMapping("/index")
    public Boolean proving(User user, HttpServletRequest request) {
        User u_ser = userService.CheckUser(user);
        HttpSession session = request.getSession();
        if (u_ser == null || u_ser.getPlayerID() == 3) {
//           表示没有此账号
            return false;
        } else {
            //登陆成功 存入sesstion
            u_ser.setPassword(null); // 清空一下 密码
            session.setAttribute("ayUser", u_ser);
            return true;
        }
    }
    /**
     * 文集按上传，暂时没有用上
     *
     * @param request
     * @param fileup
     * @return
     * @throws IOException
     */
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

    /**
     * 展示数据
     *
     * @return
     */
    @ResponseBody()
    @PostMapping("/viewData")
    public List<User> viewData() {
        User user = new User();
        user.setPlayerID(3); // 展示用户等级为三的用户
        List<User> users = userService.ViewRough(user);
        return users;

    }


    //  注册页面
    @GetMapping("register")
    public String register() {
        return "register";

    }


    // 验证注册 成功就返回true 失败就返回 fa
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


    @GetMapping("outLogin")
    public String outLogin(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "index";
    }

}