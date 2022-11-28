package com.pyj.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private int age;
    private String gender;
    private String tel;
    @TableLogic(value = "0",delval = "1")
    private String isdelete;
}
