package com.zzl.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String password;

    private Integer areaId;
    //由于 area_name 不是 User 数据库表里的字段，因此需要添加 @TableField 注解，并将 exist 属性设置为 false。
    @TableField(exist = false)
    private String areaName;
    //假设我们需要查询一个区域及其下面的所有用户，首先对 Area 实体类稍作修改，增加 users 集合属性
    //1对1
    @TableField(exist = false)
    private Area area;
}
