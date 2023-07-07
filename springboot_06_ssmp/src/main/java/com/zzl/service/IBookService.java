package com.zzl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzl.domain.Book;
//MP简便开发
public interface IBookService extends IService<Book> {
    boolean saveUser(Book book);

    public IPage<Book> getPage(int currentSize,int pageSize);

    public IPage<Book> getPage(int currentSize,int pageSize,Book book);
}
