package com.pyj.Intercepter;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MPIntercepter {

    @Bean
    public MybatisPlusInterceptor addIntercepter(){
        MybatisPlusInterceptor mpIntercepter = new MybatisPlusInterceptor();
        mpIntercepter.addInnerInterceptor(new PaginationInnerInterceptor());
        return mpIntercepter;
    }

}
