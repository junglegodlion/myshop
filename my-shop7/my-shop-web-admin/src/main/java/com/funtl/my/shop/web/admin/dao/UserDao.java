package com.funtl.my.shop.web.admin.dao;

import com.funtl.my.shop.domain.User;

public interface UserDao {
    /**
     * 根据邮箱和密码获取用户信息
     * @param email 邮箱
     * @param password 密码
     * @return 用户
     */
    public User getUserByEmailAndPassword(String email, String password);
}
