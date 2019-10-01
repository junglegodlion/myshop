package com.funtl.login.demo.dao;


import com.funtl.login.demo.entity.User;

/**
 * 用户数据访问
 */
public interface UserDao {

    public User login(String loginId, String loginPwd);
}
