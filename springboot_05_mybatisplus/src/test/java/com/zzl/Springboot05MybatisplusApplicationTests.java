package com.zzl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzl.dao.UserDao;
import com.zzl.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Springboot05MybatisplusApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void testGetById() {
        User user = userDao.selectById(1);
        System.out.println(user);
    }

    @Test
    void testGetAll() {
        List<User> users = userDao.selectList(null);
        System.out.println(users);
    }

    @Test
    void testSave(){
        User user = new User();
        user.setUsername("杨晓南");
        user.setPassword("678");
        int insert = userDao.insert(user);
        System.out.println("插入成功:"+insert);
    }

    @Test
    void testPage(){

        //显示当前页和每页的数据大小
        IPage<User> page=new Page<User>(1,5);
        userDao.selectPage(page,null);
        System.out.println("当前页码值:"+page.getCurrent());
        System.out.println("每页显示数:"+page.getSize());
        //添加MP配置拦截器类，才能查询出正确结果
        System.out.println("一共多少页:"+page.getPages());
        System.out.println("一共有多少条数据:"+page.getTotal());

        System.out.println("具体数据:"+page.getRecords());
    }

}
