/**
 * 文件名: CustomServletContainer.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch7.tomcat;

//import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
//import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
//import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @description:  Tomcat通用配置  spring-boot 2 以上被淘汰了   现在不用了
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-07-12 10:55
 */
//@Component
public class CustomServletContainer {
/*implements EmbeddedServletContainerCustomizer {

    *//**
     * 配置端口、错误页面 和 servlet容器用户会话（session）过期时间
     * @param configurableEmbeddedServletContainer
     *//*
    @Override
    public void customize(ConfigurableEmbeddedServletContainer configurableEmbeddedServletContainer) {
        configurableEmbeddedServletContainer.setPort(18888);
        configurableEmbeddedServletContainer.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
        configurableEmbeddedServletContainer.setSessionTimeout(10, TimeUnit.MINUTES);
    }*/
}
