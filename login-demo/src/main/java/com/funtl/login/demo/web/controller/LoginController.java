package com.funtl.login.demo.web.controller;

import com.funtl.login.demo.entity.User;
import com.funtl.login.demo.service.UserService;
import com.funtl.login.demo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * 登录控制器
 */
public class LoginController extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginId = req.getParameter("loginId");
        String loginPwd = req.getParameter("loginPwd");
        User user = userService.login(loginId, loginPwd);
        //登录失败的处理
        if (user == null) {
            req.getRequestDispatcher("/fall.jsp").forward(req,resp);
        }
        //登录失败的处理
        else {
            req.getRequestDispatcher("/success.jsp").forward(req,resp);
        }
    }
}
