package com.pyj.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Book {
    private Long id;
    private String name;
    private String author;
    private String des;
}
