package com.zzl.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzl.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}
