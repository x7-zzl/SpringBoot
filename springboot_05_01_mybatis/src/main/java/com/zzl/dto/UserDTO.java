package com.zzl.dto;

import com.zzl.entity.ACG;
import com.zzl.entity.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
//mybatisplus多表查询
public class UserDTO extends User {

    private List<ACG> list=new ArrayList<>();


}
