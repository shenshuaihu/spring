/**
 * 文件名: HomeController.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch9.controller;

import com.ch9.domain.Person;
import com.ch9.service.DemoService;
import com.ch9.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-10-12 10:45
 */
@RestController
public class PersonController {

    @Autowired
    private PersonService service;

    @Autowired
    private DemoService demoService;

    @RequestMapping("/save")
    public Person rollback(String name) {
        Person person = new Person();
        person.setId(null);
        person.setName(name);
        person.setAge(15);
        person.setAddress("鹿镇");
        Person p = service.savePerson(person);
        return p;
    }



}
