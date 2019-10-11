/**
 * 文件名: PersonDoc.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch8.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashSet;


/**
 * @description: 与redis使用测试
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-10-10 15:05
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonRedis implements Serializable {

    /**
     * 必须使用时间序列号接口，Jackson做序列化需要一个空构造
     */
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private Integer age;

}