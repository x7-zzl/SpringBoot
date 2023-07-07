package com.zzl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzl.domain.Book;

import java.util.List;
//业务层接口定义成业务名称，并与dao接口名称进行区分
//业务层接口一定要有测试用例
public interface BookService {

    public boolean save(Book book);
    public boolean deleteById(int id);
    public boolean update(Book book);
    public Book selectById(Integer id);
    public List<Book> selectAll();

    public IPage<Book> getPage(int currentSize, int pageSize);
}
