package com.pyj;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pyj.dao.BookDao;
import com.pyj.dao.UserDao;
import com.pyj.domain.Book;
import com.pyj.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class SSMPApplicationTests {

    @Autowired
    UserDao userDao;
    @Test
    void contextLoads() {

    }

    @Test
    void test1(){
        IPage page = new Page(2,2);
        userDao.selectPage(page, null);
        System.out.println(page.getRecords());
    }

    @Test
    void test2(){
        QueryWrapper<User> qw = new QueryWrapper();
//        qw.select("count(*) as count");
        List<Map<String, Object>> maps = userDao.selectMaps(null);
        System.out.println(maps);
    }

//    @Autowired
//    BookDao bookDao;
//    @Test
//    void test3(){
//        List<Book> books = bookDao.selectList(null);
//        System.out.println(books);
//    }
    @Test
    void test3(){
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();
        qw.select(User::getUsername,User::getGender);
        List<User> users = userDao.selectList(qw);
        System.out.println(users);
    }



}
