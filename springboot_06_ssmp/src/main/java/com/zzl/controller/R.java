package com.zzl.controller;

import lombok.Data;

//表现层一致性处理
//设计表现层返回结果的模型类，用于后端与前端进行数据格式统一，也称为前后端数据协议
@Data
public class R {
    private Boolean flag;
    private Object data;
    private String message;

    public R() {
    }

    public R(Boolean flag) {
        this.flag = flag;
    }

    public R(Boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public R(Boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public R(String message) {
        this.message = message;
    }
}
