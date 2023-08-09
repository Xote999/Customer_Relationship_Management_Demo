package com.xxxx.test;

import com.xxxx.entity.User;
import com.xxxx.mapper.UserMapper;
import com.xxxx.util.GetSqlSession;
import org.apache.ibatis.session.SqlSession;

import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args){
        SqlSession session= GetSqlSession.createSqlSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);
        User user = userMapper.queryUserByName("admin");
        System.out.println(user);
    }
}
