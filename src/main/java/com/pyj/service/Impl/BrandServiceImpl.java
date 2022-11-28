package com.pyj.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.pyj.dao.BrandDao;
import com.pyj.domain.Brand;
import com.pyj.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl extends ServiceImpl<BrandDao,Brand> implements BrandService {

    @Autowired
    BrandDao brandDao;

    @Override
    public IPage<Brand> getPage(int currentPage, int pageSize) {
        IPage<Brand> page = new Page(currentPage,pageSize);
        return brandDao.selectPage(page,null);
    }

    @Override
    public IPage<Brand> searchBrand(Brand brand ,int avgPage, int currentPage) {
        QueryWrapper qw = new QueryWrapper();
        qw.eq(brand.getStatu() != -1,"statu",brand.getStatu());
        qw.like(brand.getBrandName() != null && !brand.getBrandName().equals(""),"brandName",brand.getBrandName());
        qw.like(brand.getCompanyName() != null && !brand.getCompanyName().equals(""),"companyName",brand.getCompanyName());
        IPage<Brand> page = new Page(currentPage,avgPage);
        brandDao.selectPage(page,qw);
        return page;
    }


}
