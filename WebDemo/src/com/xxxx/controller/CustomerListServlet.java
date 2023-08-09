package com.xxxx.controller;

import com.xxxx.entity.User;
import com.xxxx.service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Objects;

@WebServlet("/CustomerListServlet")
public class CustomerListServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 管理者情報の取得
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        // ユーザーが空でログインしていないためログインページにジャンプ
        if (Objects.isNull(user)){
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }else {
            userService.LoginService(request,response,user.getUserId());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
