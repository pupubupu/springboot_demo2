package com.pyj.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
import com.pyj.domain.Book;
import com.pyj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/books")
public class BookController2 {

    @Autowired
    private BookService bookService;


    /**
     * 获取全部书籍
     * @return
     */
    @GetMapping
    public List<Book> get(){
        return bookService.list();
    }

    /**
     * 查询特定书籍
     */
    @GetMapping("/{id}")
    public Book getById(@PathVariable("id") Long id){
        return bookService.getById(id);
    }

    /**
     * 添加书籍
     * @param book
     * @return
     */
    @PostMapping
    public Boolean save(@RequestBody Book book){
        return bookService.save(book);
    }

    /**
     * 修改书籍信息
     * @param book
     * @return
     */
    @PutMapping
    public Boolean update(@RequestBody Book book){
        return bookService.updateById(book);
    }

    /**
     * 删除书籍
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Boolean delete(@PathVariable("id") Long id){
        return bookService.removeById(id);
    }

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/{currentPage}/{pageSize}")
    public IPage<Book> getByPage(@PathVariable("currentPage") int currentPage, @PathVariable("pageSize") int pageSize){
        return bookService.getPage(currentPage,pageSize);
    }

    /**
     * 使用pageHelper分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/pageHelper/{currentPage}/{pageSize}")
    public PageInfo<Book> getByPageHelp(@PathVariable("currentPage") int currentPage, @PathVariable("pageSize") int pageSize){
        System.out.println(currentPage);
        System.out.println(pageSize);
        return bookService.selectByPageHelper(currentPage,pageSize);
    }
}
