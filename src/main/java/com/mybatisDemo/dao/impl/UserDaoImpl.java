package com.mybatisDemo.dao.impl;

import com.mybatisDemo.dao.UserDao;
import com.mybatisDemo.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * Created by lenovo on 2018/8/5.
 */
public class UserDaoImpl implements UserDao{

    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public User findUserById(int id) throws Exception {
        User user = null;
        /* SqlSession是线程不安全的，定义为局部变量*/
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            user = sqlSession.selectOne("test.findUserById",id);
        }catch (Exception e){
            throw e;
        }finally {
            if (sqlSession != null) sqlSession.close();
        }
        return user;
    }

    public void insertUser(User user) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.insert("test.insertUser", user);
            sqlSession.commit();
        }catch (Exception e){
            throw e;
        }finally {
            sqlSession.close();
        }
    }

    public void updateUser(User user) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.update("test.updateUser", user);
            sqlSession.commit();
        }catch (Exception e){
            throw e;
        }finally {
            sqlSession.close();
        }
    }

    public void deleteUserById(int id) throws Exception {
        SqlSession sqlSession = null;
        try {
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.delete("test.deleteUser", id);
            sqlSession.commit();
        }catch (Exception e){
            throw e;
        }finally {
            sqlSession.close();
        }
    }
}
