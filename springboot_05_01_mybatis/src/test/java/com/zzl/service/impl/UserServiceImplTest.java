package com.zzl.service.impl;

import com.zzl.dto.UserDTO;
import com.zzl.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;
    @Test
    public void test(){
        userService.saveUserACG(new UserDTO());
    }
}