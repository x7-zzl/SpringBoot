package com.zzl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzl.domain.Book;
import com.zzl.service.BookService;
import com.zzl.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//@RestController = @Controller + @ResponseBody组成
//@Controller 将当前修饰的类注入SpringBoot IOC容器，使得从该类所在的项目跑起来的过程中，这个类就被实例化。
// 当然也有语义化的作用，即代表该类是充当Controller的作用
//@ResponseBody 它的作用简短截说就是指该类中所有的API接口返回的数据，
// 甭管你对应的方法返回Map或是其他Object，它会以Json字符串的形式返回给客户端，

@RestController

@RequestMapping("/zzl-books")
public class BookController2 {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public R getAll() {
        return new R(true, bookService.list());
    }


    //    请求体参数，传递json数据
    @PostMapping
    public R save(@RequestBody Book book) throws Exception {
        if (book.getName().equals("zzl")) {
            throw new Exception();
        }
        //保存操作结果
        boolean save = bookService.save(book);
//        R r = new R();
//        boolean flag=bookService.save(book);
//        r.setFlag(flag);

        return new R(save, save ? "添加成功(^-^)" : "添加失败(-^-!)");
    }


    @PutMapping
    public R update(@RequestBody Book book) {
        return new R(bookService.updateById(book));
    }

    //路径参数传递,从路径中获取的变量
    @DeleteMapping("/{id}")
    public R delete(@PathVariable Integer id) {
        return new R(bookService.removeById(id));
    }

    @GetMapping("/{id}")
    public R getById(@PathVariable Integer id) {
        return new R(true, bookService.getById(id));
    }

    //直接全部返回true
//    @GetMapping("/{currentPage}/{pageSize}")
//    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize) {
//
//        IPage<Book> page = bookService.getPage(currentPage, pageSize);
//        if (currentPage > page.getPages()) {
//            page = bookService.getPage((int) page.getPages(), pageSize);
//        }
//        return new R(true, page);
//    }


    @GetMapping("/{currentPage}/{pageSize}")
    public R getPage(@PathVariable int currentPage, @PathVariable int pageSize,Book book) {

        System.out.println(book);
        IPage<Book> page = bookService.getPage(currentPage, pageSize,book);
        if(currentPage >page.getPages()){
            page=bookService.getPage((int) page.getPages(),pageSize,book);
        }
        return new R(null!=book,page);
    }
}
