package com.zzl.testCase;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(value = "testcase.book")
public class BookCase {
    private int  id;
    private String name;
    private String uuid;
    private long publishTime;

}
