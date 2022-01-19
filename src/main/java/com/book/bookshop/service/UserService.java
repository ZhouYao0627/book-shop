package com.book.bookshop.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.bookshop.entity.User;
import com.book.bookshop.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 @author：ZhouYao
 @create：2022-01-17 16:08
 */

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
    @Autowired
    private UserMapper userMapper;

    /**
     * 验证用户的存在性
     */
    public String checkUser(String username) {
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));

        if (user == null) { // 用户不存在
            return "101";
        } else { // 用户已存在
            return "102";
        }
    }

    /**
     * 登录验证
     */
    public String loginCheck(User loginUser, HttpSession session) {

        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", loginUser.getUsername()));
        if (user == null) {
            return "101"; // 用户不存在
        } else {
            // 判断密码
            if (loginUser.getPassword().equals(user.getPassword())) {
                session.setAttribute("user", user);
                return "100"; // 密码正确
            } else {
                return "102"; // 密码错误
            }
        }


    }
}











