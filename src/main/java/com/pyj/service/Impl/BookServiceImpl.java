package com.pyj.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pyj.dao.BookDao;
import com.pyj.domain.Book;
import com.pyj.service.BookService;
import com.pyj.service.BookService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements BookService {

    @Autowired
    BookDao bookDao;

    /**
     * 分页查询（MP自带）
     * @param currentPage
     * @param pageSize
     * @return
     */
    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage,pageSize);
        return bookDao.selectPage(page,null);
    }

    /**
     * 使用pageHelper分页查询
     */
    @Override
    public PageInfo<Book> selectByPageHelper(int currentPage, int pageSize) {
        PageHelper.startPage(currentPage,pageSize);
        List<Book> books = bookDao.selectList(null);
        PageInfo<Book> pageInfo= new PageInfo<>(books);
        return pageInfo;
    }
}
