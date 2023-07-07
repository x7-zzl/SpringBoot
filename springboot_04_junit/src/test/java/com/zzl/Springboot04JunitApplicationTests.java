package com.zzl;

import com.zzl.dao.BookDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//如果2移动位置，设置对应的引导类位置
//@SpringBootTest(classes = Springboot04JunitApplication.class)
//@ContextConfiguration(classes = Springboot04JunitApplication.class)//
@SpringBootTest
class Springboot04JunitApplicationTests {
    @Autowired
    private BookDao dao;

    @Test
    void contextLoads() {
        dao.save();
    }

}
