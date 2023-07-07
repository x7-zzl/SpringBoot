package com.zzl;

import com.zzl.domain.Book;
import com.zzl.domain.User;
import com.zzl.service.BookService;
import com.zzl.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Springboot15CacheApplicationTests {

    @Autowired
    private BookService service;
    @Autowired()
    private UserService userService;

    @Test
    void contextLoads() {
        Book book = service.getById(5);
        System.out.println(book);
    }


}
