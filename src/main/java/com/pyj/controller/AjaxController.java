package com.pyj.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.pyj.controller.utils.R;
import com.pyj.domain.Brand;
import com.pyj.domain.Json;
import com.pyj.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/ajax")
public class AjaxController {

    @Autowired
    BrandService brandService;

    @GetMapping
    public String testAjax(HttpServletResponse response,String username){
//        response.setHeader("Access-Control-Allow-Origin", "*");
        System.out.println("接收到了 " + username);
        return "hello ajax";
    }

    @PostMapping(value = "/research")
    public Boolean testLoginAjax(@RequestBody Json json ){
        //获取前端传递过来的用户名并打印
        System.out.println(json.getUsername());
        // 这里就不使用service和dao去查询对用用户名了，假设没查到，直接返回true
        return true;
    }

    @PostMapping(value = "/addBrand")
    public R testAddBrand(@RequestBody Brand brand,HttpServletResponse response) throws IOException {
//        response.setHeader("Access-Control-Allow-Origin", "*");
        // 测试异常是否会被ProjectExceptionAdvice拦截并处理
//        if(brand.getBrandName().equals("123")) throw new IOException();
        //将数据添加之数据库中
        boolean isSave = brandService.save(brand);
        return new R(isSave);
    }

    @GetMapping(value = "selectAllBrand")
    public R testSelectAllBrand() {
        List<Brand> brands = brandService.list();
//        System.out.println(brands);
        return new R(true,brands);
    }

    /**
     * 分页查询 + 按条件查询
     * @param brand
     * @param avgPage
     * @param currentPage
     * @return
     */
    @GetMapping(value = "selectBrandByXX")
    public R testSelectBrandByXX(Brand brand ,int avgPage, int currentPage, HttpServletResponse response){
//        response.setHeader("Access-Control-Allow-Origin","*");
        System.out.println(brand);
        IPage<Brand> brandIPage = brandService.searchBrand(brand, avgPage, currentPage);
        // 如果当前页码值大于了总页码值，那么重新执行查询操作，使用最大页码值作为当前页码值
        if(currentPage > brandIPage.getPages()){
            brandIPage = brandService.searchBrand(brand, avgPage, (int) brandIPage.getPages());
        }
        return new R(true,brandIPage);
    }

    @DeleteMapping("/{id}")
    public R testBrandDel(@PathVariable("id") Long id, HttpServletResponse response){
//        response.setHeader("Access-Control-Allow-Origin","*");
//        long l = Long.parseLong(id);
//        System.out.println(id + "\n" + l );
        boolean isDelete = brandService.removeById(id);
        return new R(isDelete);
    }

    @PutMapping
    public R testBrandUpd(@RequestBody Brand brand, HttpServletResponse response){
//        response.setHeader("Access-Control-Allow-Origin","*");
        boolean isUpdate = brandService.updateById(brand);
        return new R(isUpdate);
    }

    @DeleteMapping
    public R testBrandDelbyArray(@RequestBody List<Long> ids, HttpServletResponse response){
//        response.setHeader("Access-Control-Allow-Origin","*");
//        System.out.println("ids：" + ids);
        boolean isDeleteAll = brandService.removeByIds(ids);
        return new R(isDeleteAll);
    }

    @GetMapping("/selectByPage")
    public R testSelectByPage(int avgPage, int currentPage){
        IPage<Brand> page = brandService.getPage(currentPage, avgPage);
//        if(currentPage > page.getPages()){
//            IPage<Brand> page1 = brandService.getPage((int) page.getPages(), avgPage);
//            return new R(true,page1);
//        }
        return new R(true,page);
    }


}
