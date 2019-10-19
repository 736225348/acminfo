package com;


import com.dqsy.algorithmhome.user.dao.UserDao;
import com.dqsy.algorithmhome.user.domain.User;
import com.dqsy.algorithmhome.user.service.UserService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.io.InputStream;


public class Main {

    @Resource(name = "UserDao")
    UserDao userDao;

    @Test
    public void main1() throws Exception {


//        InputStream resourceAsStream = Resources.getResourceAsStream("SqlMapConfig.xml");
//
//        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//


//
//        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);


//        SqlSession sqlSession = build.openSession();

//        UserDao mapper = sqlSession.getMapper(UserDao.class);
//        User user = new User();
//        user.setUsername("4564654");
//        user.setPassword("46456");
//        mapper.add(user);
//        sqlSession.commit();
//        sqlSession.close();


        // 现在 证明配置文件好使
    }

}
