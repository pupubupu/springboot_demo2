package com.pyj.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.pyj.domain.Book;

import java.util.List;

public interface BookService extends IService<Book> {


//    Boolean save(Book book);
//
//    Boolean update(Book book);
//
//    Boolean delete(Long id);
//
//    Book getById(Long id);
//
//    List<Book> getALL();
//

    /**
     * 分页查询（MP自带配置（使用拦截器））
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage<Book> getPage(int currentPage,int pageSize);

    /**
     * 分页查询，使用pagehelper
     */
    PageInfo<Book> selectByPageHelper(int currentPage, int pageSize);
}
