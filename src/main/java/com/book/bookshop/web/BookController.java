package com.book.bookshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 @author：ZhouYao
 @create：2022-01-16 22:28
 图书控制器
 */

@Controller
@RequestMapping("/home")
public class BookController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }


}
