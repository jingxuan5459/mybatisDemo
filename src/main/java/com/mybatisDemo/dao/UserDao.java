package com.mybatisDemo.dao;

import com.mybatisDemo.po.User;

/**
 * Created by lenovo on 2018/8/5.
 */
public interface UserDao {

    User findUserById(int id) throws Exception;

    void insertUser(User user) throws Exception;

    void updateUser(User user) throws Exception;

    void deleteUserById(int id) throws Exception;
}
