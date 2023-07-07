package com.zzl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
@EnableCaching
@Slf4j
@SpringBootApplication
public class Springboot18SpringcacheApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Springboot18SpringcacheApplication.class, args);
        System.out.println(run);
        System.out.println("启动成功");
    }

}
