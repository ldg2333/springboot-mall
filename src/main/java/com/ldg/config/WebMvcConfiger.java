package com.ldg.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sun.rmi.runtime.Log;

/**
 * 配置图片服务器
 */
@Configuration
public class WebMvcConfiger implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/avatar/**").addResourceLocations("file:E:/Java/毕设/优购商城/img/avatar/");
        registry.addResourceHandler("/banner/**").addResourceLocations("file:E:/Java/毕设/优购商城/img/banner/");
        registry.addResourceHandler("/product/**").addResourceLocations("file:E:/Java/毕设/优购商城/img/product/");
        registry.addResourceHandler("/type/**").addResourceLocations("file:E:/Java/毕设/优购商城/img/type/");
    }

}
