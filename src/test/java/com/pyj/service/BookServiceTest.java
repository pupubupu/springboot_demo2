package com.pyj.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pyj.domain.Book;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.logging.Logger;

@SpringBootTest
public class BookServiceTest {

    @Autowired
    BookService bookService;
    @Test
    public void testSave(){
        Book book = new Book();
        book.setName("书名");
        book.setAuthor("作者");
        book.setDes("描述");
        bookService.save(book);
    }

    @Test
    public void testUpdate(){
        Book book = new Book();
        book.setId(1548991245020491778L);
        book.setName("活着");
        book.setAuthor("余华");
        book.setDes("为了活着本身而活着（修改）");
//        bookService.update(book);
        bookService.updateById(book);

    }

    @Test
    public void testGetById(){
        Book book = bookService.getById(1548977880512483331L);
        Assert.assertEquals("书名",book.getName());
    }

    @Test
    public void testDeleteById(){
//        Boolean delete = bookService.delete(1548974397965094913L);
        boolean b = bookService.removeById(1548991245020491778L);
        Assert.assertEquals(true,b);
    }


    @Test
    public void testGetAll(){
//        List<Book> all = bookService.getALL();
        List<Book> books = bookService.list();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void testByPage(){
//        IPage<Book> page = bookService.getPage(2, 3);
        IPage<Book> page = new Page<>(2,3);
        bookService.page(page);
        System.out.println(page.getPages());
    }





}
