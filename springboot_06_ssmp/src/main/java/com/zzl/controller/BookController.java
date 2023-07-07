package com.zzl.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zzl.domain.Book;
import com.zzl.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@RestController = @Controller + @ResponseBody组成
//@Controller 将当前修饰的类注入SpringBoot IOC容器，使得从该类所在的项目跑起来的过程中，这个类就被实例化。
// 当然也有语义化的作用，即代表该类是充当Controller的作用
//@ResponseBody 它的作用简短截说就是指该类中所有的API接口返回的数据，
// 甭管你对应的方法返回Map或是其他Object，它会以Json字符串的形式返回给客户端，

@RestController
//解决跨域问题
//@CrossOrigin

@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService bookService;

    @GetMapping
    public List<Book> getAll(){
        return bookService.list();
    }


//    请求体参数，传递json数据
    @PostMapping
    public boolean save(@RequestBody Book book){
        return bookService.save(book);
    }


    @PutMapping
    public boolean update(@RequestBody  Book book){
        return bookService.updateById(book);
    }

    //路径参数传递,从路径中获取的变量
    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id){
        return bookService.removeById(id);
    }

    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id){
        return bookService.getById(id);
    }


    @GetMapping("/{currentSize}/{pageSize}")
    public IPage<Book> getPage(@PathVariable int currentSize,@PathVariable int pageSize){
        return bookService.getPage(currentSize,pageSize);
    }
}
