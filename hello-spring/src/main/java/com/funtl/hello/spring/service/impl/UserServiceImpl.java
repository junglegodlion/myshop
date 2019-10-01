package com.funtl.hello.spring.service.impl;

import com.funtl.hello.spring.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void sayHi() {
        System.out.println("Hello Spring");
    }
}
