package com.zzl.controller;

import com.zzl.domain.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Rest模式
@RestController
@RequestMapping("/books")
public class BookController {

    //读取yaml中的单一数据
    @Value("${country}")
    private String country;

    //读取yaml中的数据,层级渐渐深入
    @Value("${user1.name}")
    private String userName;

    @Value("${a.b.c.d.e}")
    private String value;

    //读取数组中的值
    @Value("${likes[1]}")
    private String item1;

    @Value("${likes[3]}")
    private String item2;

    @Value("${users1[1].name}")
    private String name1;

    @Value("${users3[1].age}")
    private String age1;

    @Value("${server.port}")
    private String port;

    @Value("${tempDir2}")
    private String tempDir;



    @Autowired
    private Environment environment;

    @Autowired
    private MyDataSource myDataSource;
    @GetMapping
    public String getById() {
        System.out.println("读取yaml中的数据");
        System.out.println("country中的值为:"+country);
        System.out.println("user1的name值:"+ userName);
        System.out.println("abcde:"+value);
        System.out.println("数组likes中的值:"+item1);
        System.out.println("数组likes中的值:"+item2);
        System.out.println("对象值:"+name1);
        System.out.println("对象值:"+age1);
        System.out.println("端口号:"+port);
        System.out.println("关联修改:"+tempDir);

        System.out.println("《---------------------这是一条华丽的分割线---------------------》");
        System.out.println(environment);
        System.out.println(environment.getProperty("users1[1].name"));
        System.out.println(environment.getProperty("tempDir2"));
        return "读取yaml中的数据";
    }


    @GetMapping("/{id}")
    public String getByIdEnvironment(@PathVariable Integer id){
        System.out.println(environment.getProperty("enterprise.name"));
        System.out.println(environment.getProperty("enterprise.subject[1]"));
        System.out.println(myDataSource);
        return "springboot success";
    }

}