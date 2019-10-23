package com.dqsy.algorithmhome.user.service;

import com.dqsy.algorithmhome.user.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    int AddUser(User user);

    List<User> ViewRough(User user);

    User CheckUser(User user);
}
