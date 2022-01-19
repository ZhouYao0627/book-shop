package com.book.bookshop.web;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.bookshop.entity.Book;
import com.book.bookshop.entity.enums.Category;
import com.book.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 @author：ZhouYao
 @create：2022-01-16 22:28
 图书控制器
 */

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 获取图书信息
     */
    @RequestMapping("/getBookData")
    public String getBookData(Model model, Integer page, Integer category) {
        // Mybatis plus提供的分页方法Ipage
        IPage<Book> ipage = bookService.page(new Page<>(page, 4), // 当前页为page，记录数为4
                new QueryWrapper<Book>().eq("category", category));

        model.addAttribute("bookList", ipage.getRecords());
        model.addAttribute("pre", ipage.getCurrent() - 1); // 上一页
        model.addAttribute("next", ipage.getCurrent() + 1); // 下一页
        model.addAttribute("cur", ipage.getCurrent()); // 当前页的值
        model.addAttribute("last", ipage.getPages()); // 总页数
        model.addAttribute("category", category); // 点击上一页/下一页时，category类型也需要传递

        return "bookData";
    }

    /**
     * 图书列表页
     */
    @RequestMapping("/bookList")
    public String bookList(String category, Model model) {
        model.addAttribute("category", category);

        return "books_list";
    }

    /**
     * 获取图书列表内容
     */
    @RequestMapping("/getBookListData")
    public String getBookListData(String category, Integer page, Integer pageSize, Model model) {
        IPage<Book> ipage = bookService.page(new Page<>(page, pageSize),
                new QueryWrapper<Book>().eq("category", category));
        model.addAttribute("bookList", ipage.getRecords());

        model.addAttribute("pre", ipage.getCurrent() - 1); // 上一页
        model.addAttribute("next", ipage.getCurrent() + 1); // 下一页
        model.addAttribute("cur", ipage.getCurrent()); // 当前页的值
        model.addAttribute("pages", ipage.getPages()); // 总页数

        model.addAttribute("category", category);

        model.addAttribute("pageSize", pageSize);

        return "booksListData";
    }

    /**
     * 图书详情
     */
    @RequestMapping("/detail")
    public String detail(Integer id,Model model){
        Book book = bookService.getById(id);
        model.addAttribute("book", book);
        return "details";
    }

}




















