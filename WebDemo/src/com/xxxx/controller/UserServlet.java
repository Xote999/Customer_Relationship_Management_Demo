package com.xxxx.controller;

import com.xxxx.entity.User;
import com.xxxx.entity.vo.MessageModel;
import com.xxxx.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uname = request.getParameter("uname"); //id
        String upwd = request.getParameter("upwd"); //password

        MessageModel messageModel = userService.userLogin(uname, upwd);

        if (messageModel.getCode() == 1) {
            //　ログインIDの取得
            User user = (User) messageModel.getObject();
            //　sessionに格納する
            // 管理者情報の取得
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            // データベースから取得した顧客情報を格納
            userService.LoginService(request,response,user.getUserId());
        } else {

            request.setAttribute("messageModel", messageModel);
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }
}
