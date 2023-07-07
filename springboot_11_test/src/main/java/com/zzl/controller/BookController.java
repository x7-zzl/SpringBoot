package com.zzl.controller;


import com.zzl.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/zzl")
public class BookController {

//    @GetMapping
//    public String msg(){
//        System.out.println("springboot is running");
//        return "springboot";
//    }


    @GetMapping
    public Book msg(){
        System.out.println("springboot is running");
        Book book = new Book();
        book.setId(1);
        book.setName("zzl");
        book.setType("奢靡");
        book.setDescription("sssssssssssss");

        return book;
    }
}
