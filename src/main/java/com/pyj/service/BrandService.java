package com.pyj.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.pyj.domain.Brand;

import java.util.List;


public interface BrandService extends IService<Brand> {

    /**
     * 分页查询（MP自带配置（使用拦截器））
     * @param currentPage
     * @param pageSize
     * @return
     */
    IPage<Brand> getPage(int currentPage, int pageSize);

    IPage<Brand> searchBrand(Brand brand ,int avgPage, int currentPage);
}
