package com.zzl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.zzl.entity.User;
import com.zzl.mapper.UserMapper;
import com.zzl.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
