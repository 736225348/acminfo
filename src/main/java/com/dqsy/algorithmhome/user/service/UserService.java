package com.dqsy.algorithmhome.user.service;

import com.dqsy.algorithmhome.user.domain.User;
import org.springframework.stereotype.Service;


public interface UserService {
    int AddUser(User user);



    User CheckUser(User user);
}
