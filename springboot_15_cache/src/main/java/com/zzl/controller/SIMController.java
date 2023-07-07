package com.zzl.controller;

import com.zzl.domain.SIM;
import com.zzl.service.SIMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sim")

public class SIMController {
    @Autowired
    private SIMService service;

    @GetMapping()
    public String getCode(String tel){
        return service.sendCodeToSIM(tel);
    }

    @PostMapping
    public boolean check(SIM sim){
        return service.checkCode(sim);
    }

}
