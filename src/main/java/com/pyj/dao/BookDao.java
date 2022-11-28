package com.pyj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pyj.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookDao extends BaseMapper<Book> {

    @Select("select * from book")
    public List<Book> findAll();
}
