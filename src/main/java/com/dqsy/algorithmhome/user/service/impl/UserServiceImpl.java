package com.dqsy.algorithmhome.user.service.impl;

import com.dqsy.algorithmhome.user.dao.UserDao;
import com.dqsy.algorithmhome.user.domain.User;
import com.dqsy.algorithmhome.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Resource(name = "UserDao")
    UserDao userDao;

    //JDBC  --->
    public int add(User user) {
        int a = userDao.add(user);
        return a;
    }
}
