package com.zzl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzl.dto.UserDTO;
import com.zzl.entity.ACG;
import com.zzl.entity.User;
import com.zzl.mapper.UserMapper;
import com.zzl.service.ACGService;
import com.zzl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private ACGService acgService;
    //操作user,acg两张表
    @Override
    public void saveUserACG(UserDTO userDTO) {
        //存入user
//        userDTO.setId(777);
        userDTO.setName("zzz");
        this.save(userDTO);

        String name = userDTO.getName();
        System.out.println(name);

        List<ACG> list = userDTO.getList();


        for (int i = 0; i < list.size(); i++) {
            list.get(i).setXm(name);
            list.get(i).setZy("t3");
        }
       /* list=list.stream().map((item) -> {
            item.setXm(name);
            item.setZy("t3");
            return item;
        }).collect(Collectors.toList());*/

        boolean f=acgService.saveBatch(list);
        System.out.println(f);
    }
}
