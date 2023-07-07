package com.zzl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzl.dao.BookDao;
import com.zzl.domain.Book;
import com.zzl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements BookService {
    @Autowired
    private BookDao dao;

    @Override
    @Cacheable(value = "cacheSpace", key = "#id")
    public Book getById(Integer id) {
        return dao.selectById(id);

    }

    /*private HashMap<Integer, Book> cache = new HashMap<>();

    @Override
    public Book getById(Integer id) {

        Book book = cache.get(id);
       //如果当前缓存中没有本次查询的数据，则直接进行查询操作；否则从缓存中获取数据返回
        if (book == null) {
            Book queryBook = dao.selectById(id);
            cache.put(id, queryBook);
            return queryBook;
        }

        return cache.get(id);

    }*/

}
