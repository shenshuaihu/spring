/**
 * 文件名: WebMvcConfig.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch9.config.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @description: 接管SpringBoot的Web配置
 *              这里重写addViewControllers方法，不会覆盖WebMvcAutoConfigurationAdapter中的addViewControllers方法
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-07-11 17:48
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("/login");
    }
}
