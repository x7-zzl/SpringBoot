package com.zzl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzl.dao.BookDao;
import com.zzl.domain.Book;
import com.zzl.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//MP

@Service
public class IBookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService {

    //也可独立MP出来使用
    @Autowired
    private BookDao bookDao;
    //具体实现
    @Override
    public boolean saveUser(Book book) {
        return bookDao.insert(book)>0;
    }


    @Override
    public IPage<Book> getPage(int currentSize, int pageSize) {
        Page<Book> page = new Page<>(currentSize,pageSize);
        bookDao.selectPage(page,null);
        return page;
    }

    //条件查询加分页查询
    @Override
    public IPage<Book> getPage(int currentSize, int pageSize, Book book) {


        LambdaQueryWrapper<Book> lamb = new LambdaQueryWrapper<>();
        lamb.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lamb.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        lamb.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());

        Page<Book> page = new Page<>(currentSize,pageSize);
        bookDao.selectPage(page,lamb);
        return page;
    }
}
