package com.zzl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class Springboot15CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot15CacheApplication.class, args);
    }

}
