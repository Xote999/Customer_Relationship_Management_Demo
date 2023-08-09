package com.xxxx.service;

import com.xxxx.entity.Customer;
import com.xxxx.entity.User;
import com.xxxx.entity.vo.MessageModel;
import com.xxxx.mapper.CustomerMapper;
import com.xxxx.mapper.UserMapper;
import com.xxxx.util.GetSqlSession;
import com.xxxx.util.StringUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;

public class UserService {
    public MessageModel userLogin(String uname, String upwd) {
        MessageModel messageModel = new MessageModel();

        //入力されたデータを返す
        User u = new User();
        u.setUserName(uname);
        u.setUserPwd(upwd);
        messageModel.setObject(u);

        //　空白になる場合
        if (StringUtil.isEmpty(uname) || StringUtil.isEmpty(upwd)) {
            messageModel.setCode(0);
            messageModel.setMsg("ユーザーIDとパスワードを空白にすることができません!");
            return messageModel;
        }

        SqlSession session = GetSqlSession.createSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.queryUserByName(uname);

        //　該当のユーザーが存在しない
        if (user == null) {
            messageModel.setCode(0);
            messageModel.setMsg("該当のユーザーが存在しません。");
            return messageModel;
        }

        //　パスワードが正しくない
        if (!upwd.equals(user.getUserPwd())) {
            messageModel.setCode(0);
            messageModel.setMsg("パスワードが正しくありません。");
            return messageModel;
        }

        //　ログイン成功
        messageModel.setObject(user);
        return messageModel;
    }


    public void LoginService(HttpServletRequest request, HttpServletResponse response, Integer userId) throws ServletException, IOException {
        //　sqlSessionの取得
        SqlSession sqlSession = GetSqlSession.createSqlSession();
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        //　データを検索する
        List<Customer> customers = customerMapper.getCustomer(userId);
        for (Customer customer : customers) {
            customer.setRegisteredTime(customer.getRegisteredTime().substring(0,10));
            customer.setUpdatedTime(customer.getUpdatedTime().substring(0,10));
        }
        //　sqlSessionを閉じる
        sqlSession.close();

        // 格納した顧客情報を遷移先の画面に渡す
        request.setAttribute("customer", customers);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher("WEB-INF/jsp/customer_list.jsp");
        dispatcher.forward(request, response);
    }
}
