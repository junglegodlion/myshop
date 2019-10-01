package com.funtl.my.shop.service.impl;

import com.funtl.my.shop.commons.context.SpringContext;
import com.funtl.my.shop.dao.UserDao;
import com.funtl.my.shop.entity.User;
import com.funtl.my.shop.service.UserService;

public class UserServiceImpl implements UserService {

//    private UserDao userDao = (UserDao) SpringContext.getBean("userDao");
    @Override
    public User login(String email, String password) {
        SpringContext context = new SpringContext();
        UserDao userDao = (UserDao) context.getBean("userDao");
        return userDao.getUserByEmailAndPassword(email,password);
    }
}
