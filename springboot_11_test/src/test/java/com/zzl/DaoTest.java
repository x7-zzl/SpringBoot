package com.zzl;


import com.zzl.domain.Book;
import com.zzl.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
//添加事务，测试产生的结果不加入数据库
//其实是添加成功后回滚，数据库中的id自增
@Transactional
@SpringBootTest

//默认回滚
//@Rollback(value = true)
public class DaoTest {
    @Autowired
    private BookService bookService;


    @Test
    public void testSave(){
        Book book = new Book();
        book.setName("zzzz");
        book.setType("sasd");
//        book.setDescription("qsfhnqiufh");
        System.out.println(bookService.save(book));
        System.out.println(book);
    }

}
