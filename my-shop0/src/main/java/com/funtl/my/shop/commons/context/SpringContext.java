package com.funtl.my.shop.commons.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//不需要被继承，用final
public final class SpringContext {
    //启动时，sping被应用，饿汉式
//    public static ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
private static ApplicationContext context;
static {
    context=new ClassPathXmlApplicationContext("spring-context.xml");
}
    public static Object getBean(String beanId){
    return context.getBean(beanId);
    }
}
