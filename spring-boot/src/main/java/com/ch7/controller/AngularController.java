/**
 * 文件名: AngularController.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch7.controller;

import com.ch7.domain.Person;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/** 使用angularJS
 * @description:
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-08-14 10:53
 */
@RestController
public class AngularController {

    @RequestMapping(value = "/search", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Person search(String personName) {
        return new Person("elijah",1 , "文化路97号");
    }
}
