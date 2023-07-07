package com.zzl.controller;


import org.springframework.web.bind.annotation.*;
/*@RestController是@Controller和@ResponseBody的结合体，两个标注合并起来的作用。
@Controller类中的方法可以直接通过返回String跳转到jsp、ftl、html等模版页面。
        在方法上加@ResponseBody注解，也可以返回实体对象。
@RestController类中的所有方法只能返回String、Object、Json等实体对象，不能跳转到模版页面*/
//Rest模式
@RestController

//@GetMapping是一个组合注解，是@RequestMapping(method = RequestMethod.GET)的缩写
@RequestMapping(value = "/books")

public class BookController {

    @GetMapping
    public String getById(){
        System.out.println("springboot is running...");
        return "springboot is running...";
    }


}
