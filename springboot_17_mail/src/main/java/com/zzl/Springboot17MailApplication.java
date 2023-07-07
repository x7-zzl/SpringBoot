package com.zzl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//开启定时任务功能
@EnableScheduling
@SpringBootApplication
public class Springboot17MailApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot17MailApplication.class, args);
    }

}
