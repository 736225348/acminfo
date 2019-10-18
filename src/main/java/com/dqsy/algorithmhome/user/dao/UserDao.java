package com.dqsy.algorithmhome.user.dao;


import com.dqsy.algorithmhome.user.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository("UserDao")
public interface UserDao {

    @Insert("insert into user(username,password) values (#{username} , #{password})")
    int add(User user);

    @Select("select * from user where username = #{username}")
    User tao(String username); // 查找指定用户
}
