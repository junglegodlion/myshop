package com.funtl.login.demo.dao.impl;

import com.funtl.login.demo.dao.UserDao;
import com.funtl.login.demo.entity.User;


public class UserDaoImpl implements UserDao {

    /**
     * 用户登录
     * @param loginId 登录Id
     * @param loginPwd 登录密码
     * @return String：登录结果
     */
    @Override
    public User login(String loginId, String loginPwd) {
        User user = null;
        //直接根据LoginId查询这个用户信息
        if("admin".equals(loginId)){
            //在根据传入的密码匹配
            if ("admin".equals(loginPwd)){
                user=new User();
                user.setLoginId("admin");
                user.setLoginPwd("admin");
                user.setUsername("jungle");

            }
        }


        return user;
    }
}
