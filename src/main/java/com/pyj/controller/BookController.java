package com.pyj.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.pyj.controller.utils.R;
import com.pyj.domain.Book;
import com.pyj.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;


    /**
     * 获取全部书籍
     * @return
     */
    @GetMapping
    public R get(){
        return new R(true,bookService.list());
    }

    /**
     * 查询特定书籍
     */
    @GetMapping("/{id}")
    public R getById(@PathVariable("id") Long id){
        return new R(true,bookService.getById(id));
    }

    /**
     * 添加书籍
     * @param book
     * @return
     */
    @PostMapping
    public R save(@RequestBody Book book){
        return new R(bookService.save(book));
    }

    /**
     * 修改书籍信息
     * @param book
     * @return
     */
    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.updateById(book));
    }

    /**
     * 删除书籍
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public R delete(@PathVariable("id") Long id){
        return new R(bookService.removeById(id));
    }

    /**
     * 分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/{currentPage}/{pageSize}")
    public R getByPage(@PathVariable("currentPage") int currentPage, @PathVariable("pageSize") int pageSize){
        return new R(true,bookService.getPage(currentPage,pageSize));
    }

    /**
     * 使用pageHelper分页查询
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping("/pageHelper/{currentPage}/{pageSize}")
    public R getByPageHelp(@PathVariable("currentPage") int currentPage, @PathVariable("pageSize") int pageSize){
        return new R(true,bookService.selectByPageHelper(currentPage,pageSize));
    }
}
