package com.zzl.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName(value = "tbl_book")
@Data
public class Book {
    private Integer id;
    private String name;
    private String type;
    private String description;
}
