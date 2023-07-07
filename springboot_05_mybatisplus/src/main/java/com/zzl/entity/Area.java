package com.zzl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import java.util.List;

@Data
public class Area {
    //指定主键使用数据库ID自增策略
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String areaName;

    //1对多
    @TableField(exist = false)
    private List<User> users;
}
