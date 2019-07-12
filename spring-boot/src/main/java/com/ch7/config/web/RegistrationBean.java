/**
 * 文件名: RegistrationBean.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch7.config.web;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @description:  注册Servlet、Filter、Listener
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-07-11 18:00
 */
public class RegistrationBean {

    @Bean
    public XxServlet xxServlet() {
        return new XxServlet();
    }

    @Bean
    public YyFilter yyFilter() {
        return new YyFilter();
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        return new ServletRegistrationBean(new XxServlet(), "/xx/**");
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new YyFilter());
        registrationBean.setOrder(2);
        return registrationBean;
    }

}
