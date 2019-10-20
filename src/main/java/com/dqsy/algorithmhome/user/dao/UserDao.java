package com.dqsy.algorithmhome.user.dao;


import com.dqsy.algorithmhome.user.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository("UserDao")
public interface UserDao {
    /**
     * 增加一条 用户信息
     *
     * @param user
     * @return
     */
    @Insert("@Insert(\"insert into user values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)\")\n" +
            "    public void insert(Integer userID, Integer playerID, String username, String password, String eml, String tel, String idCard, String uName, Integer grade, String sNumber, String tNumber, String photo, String joinDate, Integer sitNumber, String tSize, String remark, String info);")
    int AddUser(User user);

    /**
     * 查找 是否有这个用户
     *
     * @param username
     * @return
     */
    @Select("select * from user where username = #{username}")
    User FindUser(String username); // 是否有指定用户 最多只能查到一个

    /**
     * 用户登陆
     *
     * @param user
     * @return
     */
    @Select("select * from user where username = #{username} and password = #{password} ")
    User CheckUser(User user);   // 检查账号密码是否正确


}
