package com.zzl;

import com.zzl.dao.BookDao;
import com.zzl.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Springboot05MybatisApplicationTests {

    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById() {
        Book book = bookDao.getById(1);
        System.out.println(book);
    }

    @Test
    void testGetAll() {
        List<Book> all = bookDao.getAll();
        System.out.println(all);
    }
}
