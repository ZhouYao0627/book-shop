package com.book.bookshop;

import com.book.bookshop.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookShopApplicationTests {

    @Autowired
    private BookService bookService;

    @Test
    void findBookList() {
        bookService.list().forEach(System.out::println);
    }

}
