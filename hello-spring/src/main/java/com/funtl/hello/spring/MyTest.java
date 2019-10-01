package com.funtl.hello.spring;

import com.funtl.hello.spring.service.UserService;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    //饿汉式的单例模式
    public static final org.slf4j.Logger logger = LoggerFactory.getLogger(MyTest.class);
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.sayHi();

        logger.info("info级别的日志");
        logger.debug("debug级别的日志");
        logger.warn("warn级别的日志");
        logger.error("error级别的日志");

        String message1 = "测试";
        String message2 = "测试2";

        //占位符{},%s
        logger.info("message is: {} {}",message1,message2);
        System.out.println(String.format("message is : %s %s",message1,message2));
    }
}
