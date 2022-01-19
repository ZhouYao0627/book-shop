package com.book.bookshop.web;

import com.book.bookshop.entity.User;
import com.book.bookshop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 @author：ZhouYao
 @create：2022-01-17 16:02
 用户控制器
 */

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    // 验证用户名是否存在
    @ResponseBody // 因为是异步的，所以以JSON格式响应回去就可以了
    @RequestMapping("/checkUserName")
    public String checkUserName(String username) {
        return userService.checkUser(username);
    }

    // 用户注册
    @ResponseBody
    @RequestMapping("/register")
    public String register(User user) {
        userService.save(user);
        System.out.println("保存的用户信息为：" + user);

        return "success";
    }

    // 用户登录
    @ResponseBody
    @RequestMapping("/login")
    public String login(User user, HttpSession session) {
        return userService.loginCheck(user, session);
    }

    /**
     * 安全退出
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/home/index";
    }


}















