package com.zzl.service.impl;

import com.zzl.domain.SIM;
import com.zzl.service.SIMService;
import com.zzl.utils.VerifyCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class SIMImpl implements SIMService {
    @Autowired
    private VerifyCode verifyCode;


    @Override
    @CachePut(value = "simCode",key="#tel")
//    @Cacheable(value = "simCode",key = "#tel")
    public String sendCodeToSIM(String tel) {
        String code=verifyCode.generator(tel);
        System.out.println(code);
        return code;
    }


    @Override
    public boolean checkCode(SIM sim) {
//        取出内存中的验证码与传递过来的验证码比对，如果相同，返回true
        String code = sim.getCode();
        String cacheCode = verifyCode.get(sim.getTel());
        return code.equals(cacheCode);
    }
}
