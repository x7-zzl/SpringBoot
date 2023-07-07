package com.zzl.controller;


import com.zzl.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/zzl")
public class BookController {

    @GetMapping
    public String msg(){
        System.out.println("springboot is running");
        return "springboot";
    }


}
