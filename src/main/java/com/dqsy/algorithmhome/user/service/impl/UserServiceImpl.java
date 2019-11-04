package com.dqsy.algorithmhome.user.service.impl;

import com.dqsy.algorithmhome.user.dao.UserDao;
import com.dqsy.algorithmhome.user.domain.EasyGrid;
import com.dqsy.algorithmhome.user.domain.User;
import com.dqsy.algorithmhome.user.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
    //    @Resource(name = "UserDao")
    @Autowired
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
    public EasyGrid ViewRough(User user, int pages, int rows) {//第几页 pages   rows 一共有几页
        PageHelper.startPage(pages, rows);
        List<User> users = userDao.ViewRough(user);
        PageInfo<User> userPageInfo = new PageInfo<User>(users);
        EasyGrid easyGrid = new EasyGrid();
        easyGrid.setTotal((int) userPageInfo.getTotal());
        easyGrid.setRows(users);
        return easyGrid;

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
