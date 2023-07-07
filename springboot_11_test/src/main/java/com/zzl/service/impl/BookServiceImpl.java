package com.zzl.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zzl.dao.BookDao;
import com.zzl.domain.Book;
import com.zzl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements BookService {


}
