package com.zzl.service.impl;

import com.zzl.entity.User;
import com.zzl.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;
    @Test
    void selectAll() {
        List<User> users = userService.selectAll();
        System.out.println(users);
    }

    @Test
    void save() {
        boolean flag=userService.save(66,"t1","t2");
        System.out.println(flag);
    }

    @Test
    void update() {
        boolean f=userService.update("ttt",66);
        System.out.println(f);
    }

    @Test
    void delete() {
       boolean f= userService.delete(8);
        System.out.println(f);
    }
}