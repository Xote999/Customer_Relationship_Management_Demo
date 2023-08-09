package com.xxxx.controller;

import com.xxxx.entity.User;
import com.xxxx.mapper.CustomerMapper;
import com.xxxx.service.UserService;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/CustomerRegisterServlet")
public class CustomerRegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    private UserService userService = new UserService();

    // 顧客登録画面を表示させる
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher =
                request.getRequestDispatcher("WEB-INF/jsp/customer_register.jsp");
        dispatcher.forward(request, response);
    }

    // 顧客登録画面より入力された値をもとにデータベースへ顧客情報を登録する
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 文字コードの設定
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        // 顧客登録画面で入力された値を取得
        String customer_name = request.getParameter("customer_name");
        String customer_address = request.getParameter("address");

        // 管理者情報の取得
        HttpSession session = request.getSession(true);
        User user = (User) session.getAttribute("user");
        // ユーザーが空でログインしていないためログインページにジャンプ
        if (Objects.isNull(user)){
            RequestDispatcher dispatcher =
                    request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
            return;
        }
        // データ挿入
        SqlSession sqlSession = GetSqlSession.createSqlSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        int i = customerMapper.insertAll(user.getUserId(), customer_name, customer_address);
        // 送信
        sqlSession.commit();
        // sqlSessionを閉じる
        sqlSession.close();
        if (i > 0) {
            // データ挿入成功 お客様ページへ戻る
            userService.LoginService(request,response,user.getUserId());
        }
    }
}