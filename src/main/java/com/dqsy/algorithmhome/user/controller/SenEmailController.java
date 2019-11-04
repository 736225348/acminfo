package com.dqsy.algorithmhome.user.controller;

import com.dqsy.algorithmhome.user.domain.judge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Author: 小莫
 * Date: 2018-11-12 18:10
 * Description:<描述>
 */
@Controller
public class SenEmailController {

    @GetMapping("sends")
    public String aaa() {
        return "sends";
    }

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${mail.smtp.username}")
    private String emailFrom;

    //kfc
    @ResponseBody
    @PostMapping("send")
    public judge senMsg(String name) {
        SimpleMailMessage message = new SimpleMailMessage();
        //发件人的邮箱地址
        message.setFrom(emailFrom);
        //收件人的邮箱地址
        message.setTo(name);
        //邮件主题
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();

        message.setSubject("大庆师范学院ACM406实验室");
        //邮件内容
        message.setText("收到的邮件内容：恭喜你被翔泽想了一下 （密令:" + uuid + ")");
        //发送邮件
        try {
            javaMailSender.send(message);
            judge judge = new judge("发送成功");
            return judge;
        } catch (Exception e) {
            judge judge = new judge("发送失败");
            return judge;
        }
    }
}
