package com.zzl;

import com.zzl.controller.BookController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Springboot07ConfigProfileApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Springboot07ConfigProfileApplication.class, args);
        BookController bean = ctx.getBean(BookController.class);
        System.out.println(bean);
    }

}
