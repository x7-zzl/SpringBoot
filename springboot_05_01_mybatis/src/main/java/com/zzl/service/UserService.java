package com.zzl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzl.dto.UserDTO;
import com.zzl.entity.User;

public interface UserService extends IService<User> {
    public void saveUserACG(UserDTO userDTO);
}
