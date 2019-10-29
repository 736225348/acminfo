package com.dqsy.algorithmhome.user.service;

import com.dqsy.algorithmhome.user.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    //增加一条信息
    int AddUser(User user);
    
    List<User> ViewRough(User user);

    User CheckUser(User user);

    int updateUser(User user);

}
