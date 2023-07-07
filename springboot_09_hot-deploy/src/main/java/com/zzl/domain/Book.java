package com.zzl.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


//实体类中自定义表名
@TableName("tbl_book")
@Data
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
