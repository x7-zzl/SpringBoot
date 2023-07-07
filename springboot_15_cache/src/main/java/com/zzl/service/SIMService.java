package com.zzl.service;

import com.zzl.domain.SIM;
import lombok.Data;
import org.springframework.stereotype.Service;


public interface SIMService {
    public String sendCodeToSIM(String tel);
    public boolean checkCode(SIM sim);
}
