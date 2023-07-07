package com.zzl.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzl.entity.Area;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AreaMapper extends BaseMapper<Area> {
    /*
    @Many 的用法与 @One 类似，只不过如果使用 @One 查询到的结果是多行，会抛出 TooManyResultException 异常，这种时候应该使用的是 @Many 注解，实现一对多的查询。
    @Result(column = "id", property = "id") 可以不写，也不会报错。但是会导致我们查询结果（Area 实体）的 id 属性没有值（因为第二个 Result 将 id 值作为查询条件传入子查询）。
    */
    @Results({
            @Result(column = "id", property = "id"),
            @Result(column = "id", property = "users",
                    many = @Many(select = "com.zzl.dao.UserDao.selectByAreaId"))
    })
    @Select("SELECT * FROM area WHERE id = #{id}")
    Area getAreaById(int id);
}
