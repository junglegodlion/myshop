package com.funtl.my.shop.web.controller;

import com.funtl.my.shop.commons.context.SpringContext;
import com.funtl.my.shop.commons.utils.CookieUtils;
import com.funtl.my.shop.entity.User;
import com.funtl.my.shop.service.UserService;
import org.apache.commons.lang3.StringUtils;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class LoginController extends HttpServlet {
    //应用常量
    private  static final String COOK_NAME_USER_INFO="userInfo";
    private UserService userService = SpringContext.getBean("userService");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userInfo = CookieUtils.getCookieValue(req,COOK_NAME_USER_INFO);
        if(!StringUtils.isBlank(userInfo)){
            String[] userInfoArray = userInfo.split(":");
            String email = userInfoArray[0];
            String password = userInfoArray[1];
            req.setAttribute("email",email);
            req.setAttribute("password",password);
            req.setAttribute("isRemember",true);

        }
        req.getRequestDispatcher("/login.jsp").forward(req,resp);

    }
        //Alt+F8 查看变量的值
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email =req.getParameter("email");
        String password =req.getParameter("password");
        boolean isRemember = req.getParameter("isRemember") == null?false:true;
        //用户选择不记住
        if(!isRemember){
            CookieUtils.deleteCookie(req,resp,COOK_NAME_USER_INFO);
        }

        User admin = userService.login(email,password);

        // 登录成功
        if (admin!=null){
            if (isRemember){
        //   用户信息存储一周
                CookieUtils.setCookie(req,resp,COOK_NAME_USER_INFO,String.format("%s:%s",email,password),7*24*60*60);
            }
            resp.sendRedirect("/main.jsp");

        }
        //登录失败
        else{
            req.setAttribute("message","用户名或密码错误");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }
}
