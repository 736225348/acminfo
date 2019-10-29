package com.dqsy.algorithmhome.user.service.impl;

import com.dqsy.algorithmhome.user.dao.UserDao;
import com.dqsy.algorithmhome.user.domain.User;
import com.dqsy.algorithmhome.user.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

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
        User name_per = userDao.FindUser(user.getUsername());
        User eml_per = userDao.FindEml(user.getEml());
        if (name_per == null && eml_per == null) {
            int sum = userDao.AddUser(user);
            //正确返回 1
            return sum; // 1
        } else {
            if (name_per == null) { // 邮箱重复
                return 0;
            } else {
                return 2; //用户名重复
            }
        }

    }

    @Override
    public List<User> ViewRough(User user) {
        List<User> users = userDao.ViewRough(user);
        return users;
    }


    @Override
    public User CheckUser(User user) {
        User u_ser = userDao.CheckUser(user);
        return u_ser;
    }

    @Override
    public int updateUser(User user) {
        int i = userDao.updateUser(user);
        return i;
    }


}
