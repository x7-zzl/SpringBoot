package com.zzl.service.impl;

import com.zzl.service.SendMailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MutiSendMailServiceImplTest {


    @Autowired
    private SendMailService javaMailSender;
    @Test
    void sendMail() {
//        for (int i = 0; i < 10; i++)
            javaMailSender.sendMail();
            System.out.println("已发送");


    }
}