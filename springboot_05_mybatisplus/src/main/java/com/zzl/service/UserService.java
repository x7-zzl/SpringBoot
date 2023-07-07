package com.zzl.service;

import com.zzl.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserService {
    public List<User> selectAll();

    public boolean save(Integer id,String username,String password);

    public boolean update(String username,Integer id);

    public boolean delete(Integer id);
}
