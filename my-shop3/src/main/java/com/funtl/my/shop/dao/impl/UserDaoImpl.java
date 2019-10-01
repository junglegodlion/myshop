package com.funtl.my.shop.dao.impl;

import com.funtl.my.shop.dao.UserDao;
import com.funtl.my.shop.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


@Repository(value = "userDao")
public class UserDaoImpl implements UserDao{
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);


    @Override
    public User getUserByEmailAndPassword(String email, String password) {

        logger.debug("调用 getUser(),email；{} password:{}",email,password);
        User user = null;
        if("admin@funtl.com".equals(email)){
            if("admin".equals(password)){
                user = new User();
                user.setEmail("admin@funtl.com");
                user.setUsername("jungle");
                logger.info("成功获取 \"{}\"的用户信息",user.getPassword());
            }else {
                logger.info("获取\"{}\"的用户信息失败",email);
            }
        }
        return user;
    }
}
