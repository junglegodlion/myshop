package com.funtl.my.shop.service.impl;

import com.funtl.my.shop.commons.context.SpringContext;
import com.funtl.my.shop.dao.UserDao;
import com.funtl.my.shop.dao.impl.UserDaoImpl;
import com.funtl.my.shop.entity.User;
import com.funtl.my.shop.service.UserService;
import org.springframework.stereotype.Service;


@Service(value = "userService")
public class UserServiceImpl implements UserService {


  private UserDao useDao=SpringContext.getBean("userDao");

    public User login(String email, String password) {
        return useDao.getUserByEmailAndPassword(email,password);

    }
}
