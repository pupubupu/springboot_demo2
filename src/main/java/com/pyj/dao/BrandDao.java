package com.pyj.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pyj.domain.Brand;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BrandDao extends BaseMapper<Brand> {
}
