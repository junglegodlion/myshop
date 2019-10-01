package com.funtl.my.shop.service.impl;

import com.funtl.my.shop.service.UserService;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
    @Override
    public void sayHi() {
        System.out.println("Hi");
    }
}
