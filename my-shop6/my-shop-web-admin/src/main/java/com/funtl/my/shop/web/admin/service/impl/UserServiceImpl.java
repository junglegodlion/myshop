package com.funtl.my.shop.web.admin.service.impl;

import com.funtl.my.shop.domain.User;
import com.funtl.my.shop.web.admin.dao.UserDao;
import com.funtl.my.shop.web.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {



    @Autowired
    private UserDao useDao;

    public User login(String email, String password) {
        return useDao.getUserByEmailAndPassword(email,password);

    }
}
