package com.zzl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzl.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//当MP提供的方法不够用时，可以添加新方法使用
//一般来说，两种并用
//重载的时候不要覆盖原有方法，尽量使用接口提供的方法
//同时也可以使用Mybatis进行开发
@Mapper
public interface BookDao extends BaseMapper<Book> {
    //混用测试
    @Select("select * from tbl_book where id=#{id} and type =#{type}")
    public Book  getBookZzl(Integer id,String type);
}
