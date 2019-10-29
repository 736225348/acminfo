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
    @PostMapping("/index") // 不被拦截的主要原因 就是拦截 index
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
     *
     */
    @ResponseBody
    @PostMapping("/updateUser")
    public judge updateUser(User user, @SessionAttribute User ayUser) {
        user.setUserID(ayUser.getUserID());
        int i = userService.updateUser(user);

        if (i == 1) {
            return new judge("修改成功");

        } else {

            return new judge("修改失败");

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
    ///root/apache-tomcat-9.0.27/webapps/AlgorithmHome/upload/
    @PostMapping("fileup") // 上传文件D:\IDEA\apache-tomcat-9.0.12\webapps\ROOT\upload\到目录下
    public String FileUp(HttpServletRequest request, @RequestParam("fileup") List<MultipartFile> fileup, @SessionAttribute User ayUser) throws IOException {
        //上传文件路径
        if (!fileup.isEmpty() && fileup.size() > 0) {
            for (MultipartFile file : fileup) {
//                String org = file.getOriginalFilename();
                String username = ayUser.getUsername();
                String org = username;
                String dirPath = request.getServletContext().getRealPath("/upload/");
                System.out.println(dirPath); // 打因出路径
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

    // 验证注册
    @ResponseBody
    @PostMapping("register")
    public judge registerUser(User user) {
        System.out.println(user);
        int i = userService.AddUser(user);
        if (i == 2) {
            return new judge("用户名已被注册");
        } else if (i == 1) {
            return new judge("注册信息已成功，等待教师或管理员的审核");
        } else {
            return new judge("邮箱已被使用");

        }
    }


    @GetMapping("outLogin")
    public String outLogin(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "index";
    }

}