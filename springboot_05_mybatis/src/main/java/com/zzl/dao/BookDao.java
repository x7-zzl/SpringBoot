package com.zzl.dao;


import com.zzl.entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper

public interface BookDao {
    @Select("select * from user where id= #{id}")
    public Book getById(Integer id);


    @Select("select * from user")
    public List<Book> getAll();
}
