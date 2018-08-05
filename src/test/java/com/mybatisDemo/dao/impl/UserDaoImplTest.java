package com.mybatisDemo.dao.impl;

import com.mybatisDemo.dao.UserDao;
import com.mybatisDemo.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by lenovo on 2018/8/5.
 */
public class UserDaoImplTest {

    private UserDao userDao;

    @Before
    public void setUp() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        userDao = new UserDaoImpl(sqlSessionFactory);
    }

    @Test
    public void findUserById() throws Exception {
        System.out.println(userDao.findUserById(1));
    }

    @Test
    public void insertUser() throws Exception {
        User user = new User();
        user.setUsername("new小明");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("423fsfs");

        userDao.insertUser(user);
    }

    @Test
    public void updateUser() throws Exception {
        User user = new User();
        user.setId(30);
        user.setUsername("新小明");
        user.setBirthday(new Date());
        user.setSex("1");
        user.setAddress("423fsfs更新");

        userDao.updateUser(user);
    }

    @Test
    public void deleteUserById() throws Exception {
        userDao.deleteUserById(32);
    }

}