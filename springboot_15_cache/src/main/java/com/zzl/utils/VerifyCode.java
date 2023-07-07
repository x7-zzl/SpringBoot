package com.zzl.utils;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class VerifyCode {

    private String [] patch = {"000000","00000","0000","000","00","0",""};

    public String generator(String tele){
        int hash = tele.hashCode();
        int encryption = 20206666;
        long result = hash ^ encryption;
        long nowTime = System.currentTimeMillis();
        result = result ^ nowTime;
        long code = result % 1000000;
        code = code < 0 ? -code : code;
        String codeStr = code + "";
        int len = codeStr.length();
        return patch[len] + codeStr;
    }

    @Cacheable(value = "simCode",key="#tel")
    public String get(String tel){
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new VerifyCode().generator("18866668888"));
    }

}
