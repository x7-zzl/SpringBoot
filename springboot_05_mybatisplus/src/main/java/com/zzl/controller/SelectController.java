package com.zzl.controller;


import com.zzl.dao.AreaMapper;
import com.zzl.dao.UserDao;
import com.zzl.dao.UserMapperOne;
import com.zzl.entity.Area;
import com.zzl.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SelectController {
    @Autowired
    UserDao userDao;
    @Autowired
    UserMapperOne userMapperOne;
    @Autowired
    AreaMapper areaMapper;

    @RequestMapping("/selectUser")
    public User test() {
        User user = userDao.getUserById(1);
        return user;
    }

    @RequestMapping("/selectUserOne")
    public User testOne() {
        User user = userMapperOne.getUserById(1);
        return user;
    }

    @RequestMapping("/selectUserMany")
    public Area testMany() {
        Area area = areaMapper.getAreaById(1);
        return area;
    }
}
