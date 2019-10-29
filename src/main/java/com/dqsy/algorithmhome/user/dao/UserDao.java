package com.dqsy.algorithmhome.user.dao;


import com.dqsy.algorithmhome.user.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserDao")
public interface UserDao {
    /**
     * 增加一条 用户信息
     * 输入 user   返回值 int
     *
     * @param user
     * @return
     */
    @Insert("insert into user(username,password,eml,tel,idCard,info,uName,grade,sNumber,tNumber,photo,sitNumber,tSize,remark) values(#{username},#{password},#{eml},#{tel},#{idCard},#{info},#{uName},#{grade},#{sNumber},#{tNumber},#{photo},#{sitNumber},#{tSize},#{remark})")
    int AddUser(User user);

    /**
     * 查找 是否有这个用户
     * 输入  username   输出 User
     *
     * @param username
     * @return
     */
    @Select("select * from user where username = #{username}")
    User FindUser(String username); // 是否有指定用户 最多只能查到一个


    /**
     * 根据邮件查找是否有这个用户
     *
     * @param eml 电子邮寄
     * @return user 对象
     */
    @Select("select * from user where eml = #{eml}")
    User FindEml(String eml); // 是否有指定用户 最多只能查到一个

    /**
     * 用户登陆
     *
     * @param User
     * @return User
     */
    @Select("select * from user where username = #{username} and password = #{password} ")
    User CheckUser(User user);   // 检查账号密码是否正确


    /**
     * 返回 一个 角色等级的 的User数组
     *
     * @param 查找用户等级为 user.playerID
     * @return 返回List User 数组
     */
    @Select("select * from user where playerID = #{playerID}")
    List<User> ViewRough(User user);


    /**
     * 修改部分信息  （电话   座位号  T恤尺码  个人简介）
     *
     * @param user
     * @return int
     */
    @Update("update user set tel=#{tel},grade=#{grade},tSize=#{tSize},info=#{info} where userID=#{userID}")
    int updateUser(User user);


    /**
     * 修改全部个人信息
     *
     * @param user
     * @return int
     */
    @Update("update user set username=#{username},password=#{password},eml=#{eml},tel=#{tel},idCard=#{idCard},info=#{info},uName=#{uName},grade=#{grade},sNumber=#{sNumber},tNumber=#{tNumber},photo=#{photo},sitNumber=#{sitNumber},sitNumber=#{tSize},sitNumber=#{remark}")
    int updateUserAll(User user);







}
