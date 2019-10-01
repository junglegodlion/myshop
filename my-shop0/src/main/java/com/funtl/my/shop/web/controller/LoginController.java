package com.funtl.my.shop.web.controller;

import com.funtl.my.shop.commons.context.SpringContext;
import com.funtl.my.shop.entity.User;
import com.funtl.my.shop.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

    private UserService userService = (UserService) SpringContext.getBean("userService");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
        //Alt+F8 查看变量的值
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email =req.getParameter("email");
        String password =req.getParameter("password");
        SpringContext context =new SpringContext();
        UserService userService = (UserService) context.getBean("userService");
        User admin = userService.login(email,password);
        System.out.println(admin);
        // 登录成功
        if (admin!=null){
            resp.sendRedirect("/main.jsp");

        }
        //登录失败
        else{
            req.setAttribute("message","用户名或密码错误");
            req.getRequestDispatcher("/index.jsp").forward(req,resp);
        }
    }
}
