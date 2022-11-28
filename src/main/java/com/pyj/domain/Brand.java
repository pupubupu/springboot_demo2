package com.pyj.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Brand {
    @TableId(value = "id")
    private Long brandId;
    private String brandName;
    private String companyName;
    private String ordered;
    private String description;
    private int statu;
}
