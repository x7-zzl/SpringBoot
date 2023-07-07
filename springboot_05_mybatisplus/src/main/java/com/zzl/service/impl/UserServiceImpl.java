package com.zzl.service.impl;

import com.zzl.dao.UserDao;
import com.zzl.entity.User;
import com.zzl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectAll() {
        return userDao.selectAll();
    }

    @Override
    public boolean save(Integer id, String username, String password) {
        return userDao.save(id, username, password);
    }

    @Override
    public boolean update(String username, Integer id) {
        return userDao.update(username,id);
    }

    @Override
    public boolean delete(Integer id) {
        return userDao.delete(id);
    }
}
