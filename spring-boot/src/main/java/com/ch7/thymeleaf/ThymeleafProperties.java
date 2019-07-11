/**
 * 文件名: ThymeleafProperties.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch7.thymeleaf;

/**
 * @description:  仅用于查询源码 项目中不做使用
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-07-11 11:50
 */

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(
        prefix = "spring.thymeleaf"
)
public class ThymeleafProperties {
    private static final Charset DEFAULT_ENCODING;

    /**
     * 前缀设置，springboot默认是模板防止在classpath:/templates/下
     */
    public static final String DEFAULT_PREFIX = "classpath:/templates/";

    /**
     * 后缀设置
     */
    public static final String DEFAULT_SUFFIX = ".html";
    private boolean checkTemplate = true;
    private boolean checkTemplateLocation = true;
    private String prefix = "classpath:/templates/";
    private String suffix = ".html";
    /**
     * 模板模式设置
     */
    private String mode = "HTML";
    /**
     * 模板的编码设置，默认是UTF_8
     */
    private Charset encoding;
    private boolean cache;
    private Integer templateResolverOrder;
    private String[] viewNames;
    private String[] excludedViewNames;
    private boolean enableSpringElCompiler;
    private boolean renderHiddenMarkersBeforeCheckboxes;
    private boolean enabled;
    static {
        DEFAULT_ENCODING = StandardCharsets.UTF_8;
    }

    //  .......
}

