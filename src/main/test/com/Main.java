package com;


import com.dqsy.algorithmhome.user.dao.UserDao;
import com.dqsy.algorithmhome.user.domain.User;
import com.dqsy.algorithmhome.user.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.io.InputStream;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Main {

    public static void main(String[] args) {
        //发件人电子邮箱
        String from = "a736225348@163.com";
        //收件人电子邮箱
        String to = "736225348@qq.com";

        //也可以以此来获得系统属性：Properties properties = System.getProperties();
        Properties properties = new Properties();
        // 设置邮件服务器主机名
        properties.setProperty("mail.host", "smtp.163.com");

        //这行代码是我在遇到554返回码时加上的，同时也将发送内容中的“test，测试”等关键字去掉了
        //在163邮箱的白名单也设置了本地ip，后来注释掉这行代码发送消息也没有报错了
        //properties.setProperty("mail.smtp.localhost", "127.0.0.1");

        // 发送邮件协议名称
        properties.setProperty("mail.transport.protocol", "smtp");
        //这行代码网上有说必须要将后面设为“true”，经过亲测，后面改为“false”也不会报错
        properties.setProperty("mail.smtp.auth", "true");
        //debug时使用，可以看到发送的状态，十分有用
        properties.setProperty("mail.debug", "true");
        //获取默认的session
        Session session = Session.getDefaultInstance(properties);

        try {
            //创建一个默认的Message对象
            Message message = new MimeMessage(session);
            //设置发件人信息
            message.setFrom(new InternetAddress(from));
            //设置邮件的标题
            message.setSubject("新势!");
            //设置邮件内容
            message.setText("收到请回复");
            Transport transport = session.getTransport();
            // 连接邮件服务器
            transport.connect(from, "gxw948192694");
            //发送消息，多个收件人后面地址填上多个
            transport.sendMessage(message, new Address[]{new InternetAddress(to)});
            transport.close();
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            System.out.println("Error: unable to send message....");
            mex.printStackTrace();
        }
    }
}
