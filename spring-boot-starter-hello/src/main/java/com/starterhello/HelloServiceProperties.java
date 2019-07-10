/**
 * 文件名: HelloServiceProperties.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.starterhello;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @description: spring-boot 自动配置作为依赖
 *               类型安全的属性获取。
 *               在yml文件中 通过 hello.msg = 来设置，如果不设置默认 hello.meg = word
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-07-10 23:26
 */
@ConfigurationProperties(prefix = "hello")
@Data
public class HelloServiceProperties {

    private static final String MSG = "word";

    private String msg = MSG;
}
