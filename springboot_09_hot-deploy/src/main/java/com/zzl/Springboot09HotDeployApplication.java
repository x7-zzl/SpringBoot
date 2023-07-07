package com.zzl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// 在入口类使用注解开启事务
@EnableTransactionManagement
@SpringBootApplication
public class Springboot09HotDeployApplication {

    public static void main(String[] args) {
        //系统设置热部署级别，高于配置文件设置的
        System.setProperty("spring.devtools.restart.enabled","false");
        SpringApplication.run(Springboot09HotDeployApplication.class, args);
    }

}
