//package com.zzl.controller;
//
//
//import com.zzl.service.MsgService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//
//@RequestMapping("/books")
//public class BookController {
//
//    @Autowired
//    private MsgService msgService;
//
//    @GetMapping("/{tel}")
//    public String get(@PathVariable String tel) {
//        return msgService.get(tel);
//    }
//
//
//    @PostMapping
//    public boolean check(String tele, String code) {
//        return msgService.check(tele, code);
//    }
//
//}
