package com.zzl.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zzl.dao.BookDao;
import com.zzl.domain.Book;
import com.zzl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    //返回值为boolean型
    //插入成功后返回值为1，所以可以判断
    @Override
    public boolean save(Book book) {
        return bookDao.insert(book)>0;
    }


    @Override
    public boolean deleteById(int id) {
        return bookDao.deleteById(id)>0;
    }

    @Override
    public boolean update(Book book) {
        return bookDao.updateById(book)>0;
    }

    @Override
    public Book selectById(Integer id) {
        return bookDao.selectById(id);
    }

    @Override
    public List<Book> selectAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentSize, int pageSize) {
        IPage<Book> page=new Page<>(currentSize,pageSize);
        bookDao.selectPage(page,null);
        return page;
    }
}
