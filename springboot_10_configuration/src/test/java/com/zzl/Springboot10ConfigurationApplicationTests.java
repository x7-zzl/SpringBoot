package com.zzl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springboot10ConfigurationApplicationTests {

    @Value("${servers1.ipAddress}")
    private String ip;

    @Value("${datasource.password}")
    private String message;

    @Test
    void contextLoads() {
        System.out.println(ip);
        System.out.println(message);
    }


}
