package com.book.bookshop.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.bookshop.entity.Book;
import com.book.bookshop.mapper.BookMapper;
import org.springframework.stereotype.Service;

/**
 @author：ZhouYao
 @create：2022-01-16 22:04
 图书服务层/业务层
 */

@Service
public class BookService extends ServiceImpl<BookMapper, Book> {


}
