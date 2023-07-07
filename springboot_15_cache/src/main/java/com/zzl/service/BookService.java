package com.zzl.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zzl.domain.Book;

public interface BookService extends IService<Book> {

    public Book getById(Integer id);

}
