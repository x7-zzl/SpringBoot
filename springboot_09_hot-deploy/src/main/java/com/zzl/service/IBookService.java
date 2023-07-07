package com.zzl.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zzl.domain.Book;
import org.springframework.transaction.annotation.Transactional;

@Transactional
//MP简便开发
public interface IBookService extends IService<Book> {
    boolean saveUser(Book book);

    public IPage<Book> getPage(int currentSize,int pageSize);

    public IPage<Book> getPage(int currentSize,int pageSize,Book book);
}
