/**
 * 文件名: AuthorSettings.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch6.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @description:
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-07-08 23:14
 */
@Component
@ConfigurationProperties(prefix = "author")
@Data
public class AuthorSettings {

    private String name;
    private Long age;
}
