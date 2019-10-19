package com.dqsy.algorithmhome.user.dao;


import com.dqsy.algorithmhome.user.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository("UserDao")
public interface UserDao {

    @Insert("insert into user(username,password) values (#{username} , #{password})")
    int AddUser(User user);

    @Select("select * from user where username = #{username}")
    User FindUser(String username); // 是否有指定用户 最多只能查到一个

    @Select("select * from user where username = #{username} and password = #{password} ")
    User CheckUser(User user);   // 检查账号密码是否正确
}
