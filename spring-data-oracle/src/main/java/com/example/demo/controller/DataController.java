/**
 * 文件名: DataController.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.example.demo.controller;

import com.example.demo.domain.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-08-22 22:51
 */
@RestController
public class DataController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/save")
    public Person save(Long id,String name, String address, Integer age) {
        Person p = personService.save(new Person(id, name, age, address));
        return p;
    }

    @RequestMapping("/q1")
    public List<Person> q1(String address) {
        List<Person> p = personService.findByAddress(address);
        return p;
    }
}
