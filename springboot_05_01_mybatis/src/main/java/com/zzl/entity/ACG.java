package com.zzl.entity;

import lombok.Data;

@Data
public class ACG {
    public String xm;
    public String zy;

    public ACG(String xm, String zy) {
        this.xm = xm;
        this.zy = zy;
    }
}
