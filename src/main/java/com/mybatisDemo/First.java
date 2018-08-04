package com.mybatisDemo;


import com.mybatisDemo.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * Created by lenovo on 2018/8/4.
 */
public class First {

    @Test
    public void selectOne(){
        SqlSession sqlSession = null;

        try {
            InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
/*            User user = sqlSession.selectOne("test.findUserById",1);
            System.out.println(user);*/
/*            List<User> users = sqlSession.selectList("test.findUserByUsername", "小明");
            System.out.println(users);*/
            User user = new User();
            user.setUsername("新小明");
            user.setBirthday(new Date());
            user.setSex("1");
            user.setAddress("423fsfs");
            sqlSession.insert("test.insertUser", user);
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) sqlSession.close();
        }
    }
}
