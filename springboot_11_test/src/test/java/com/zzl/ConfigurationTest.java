package com.zzl;

import com.zzl.config.MPConfig;
import com.zzl.testCase.BookCase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@SpringBootTest
//加载到当前环境中
//局部配置导入
@Import({MPConfig.class})
public class ConfigurationTest {

    @Autowired
    private BookCase bookCase;
    @Autowired
    private String  msg;
    @Test
    void contextLoads() {
        System.out.println(bookCase);
        System.out.println(msg);
    }
}
