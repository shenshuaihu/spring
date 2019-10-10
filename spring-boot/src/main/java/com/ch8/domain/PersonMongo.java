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

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * @description: 与MongoDB使用测试
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-10-10 15:05
 */
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonMongo {

    /**
     * 文档ID
     */
    @Id
    private String id;
    private String name;
    private Integer age;

    /**
     * 文档中命名为locs，locations属性以数组形式存在当前数据中，即同另外一种名字来命名数据
     */
    //@Field("locs")
    //private List<Location> locations = new LinkedList<>();

    @Field("locs")
    private Collection<Location> locations =  new LinkedHashSet<Location>();

}