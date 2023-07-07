package com.zzl;

import com.zzl.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

@SpringBootTest
class Springboot14MongodbApplicationTests {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void testSave() {
        Book book = new Book();
        book.setId(11);
        book.setName("zzl");
        book.setType("yuhan");
        book.setDescription("uuuuuuuuuu");
        mongoTemplate.save(book);
    }

    @Test
    void testFindAll() {
        List<Book> books = mongoTemplate.findAll(Book.class);
        System.out.println(books);
    }
}
