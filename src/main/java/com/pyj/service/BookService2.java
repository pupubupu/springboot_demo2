package com.pyj.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pyj.domain.Book;

import java.util.List;

public interface BookService2 {
    Boolean save(Book book);

    Boolean update(Book book);

    Boolean delete(Long id);

    Book getById(Long id);

    List<Book> getALL();

    IPage<Book> getPage(int currentPage, int pageSize);
}
