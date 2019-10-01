package com.funtl.login.demo.service;

import com.funtl.login.demo.entity.User;

public interface UserService {
    public User login(String loginId, String loginPwd);
}
