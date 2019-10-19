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
    public int AddUser(User user) {
        int a = userDao.AddUser(user);
        return a;
    }

    @Override
    public Boolean FindUser(String username) {
        User user = userDao.FindUser(username);
        if (user == null) {
            return false;
        } else {
            return true;

        }

    }

    @Override
    public Boolean CheckUser(User user) {
        User u_ser = userDao.CheckUser(user);
        if (u_ser == null) {
            return false;
        } else {
            return true;

        }


    }


}
