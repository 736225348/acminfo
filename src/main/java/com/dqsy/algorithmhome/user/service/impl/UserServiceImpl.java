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

    /**
     * 插入一条用户信息 插入错误返回0
     *
     * @param user
     * @return
     */
    public int AddUser(User user) {
        User people = userDao.FindUser(user.getUsername());
        if (people == null) {
            int sum = userDao.AddUser(user);
            return sum;
        } else {
            return 0;

        }

    }


    @Override
    public User CheckUser(User user) {
        User u_ser = userDao.CheckUser(user);
        return u_ser;
    }


}
