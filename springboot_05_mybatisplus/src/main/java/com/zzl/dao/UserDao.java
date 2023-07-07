package com.zzl.dao;


import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzl.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
//对应表名
@TableName(value = "user")
public interface UserDao extends BaseMapper<User> {

    //mybatis操作

    @Select("select * from user")
    public List<User> selectAll();

    //不要用关键字
    @Insert("insert into user (id,username,password) values (#{id},#{username},#{password})")
    public boolean save(Integer id,String username,String password);

    @Update("update USER set username = #{username} where id=#{id};")
    public boolean update(String username,Integer id);

    @Delete("delete  from user where id= #{id}")
    public boolean delete(Integer id);

    @Select("select user.* ,area.area_name from user,area "+
            " where user.area_id = area.id and user.id = #{id}"
    )


    User getUserById(int id);

//    一对1查询
    @Select("SELECT * FROM user WHERE area_id = #{areaId}")
    User selectByAreaId(int areaId);


}
