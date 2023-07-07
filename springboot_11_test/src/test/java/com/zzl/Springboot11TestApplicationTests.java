package com.zzl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
//properties可以为当前的测试用例添加临时的属性配置
//@SpringBootTest(properties = {"test.prop=zzl777"})
//可以为当前的测试用例添加临时的命令行参数
// args参数级别最高
@SpringBootTest(args = {"--test.prop=yuhan"})
class Springboot11TestApplicationTests {


    @Value("${test.prop}")
    private String testMsg;

    @Test
    void contextLoads() {
        System.out.println(testMsg);
    }

}
