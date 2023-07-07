package com.zzl;

import com.zzl.controller.BookController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Springboot0101QuickstartApplication {

    public static void main(String[] args) {

//        SpringApplication.run(Springboot0101QuickstartApplication.class, args);
        //获得spring的容器
        ConfigurableApplicationContext ctx=SpringApplication.run(Springboot0101QuickstartApplication.class, args);
        BookController bean=ctx.getBean(BookController.class);
        System.out.println(bean);
    }

}
