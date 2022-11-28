package com.pyj.dao;

import com.pyj.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class BookDaoTest {

    @Autowired
    BookDao bookDao;

    @Test
    public void findAllTest(){
        List<Book> books = bookDao.findAll();
        System.out.println(books);
    }

}
