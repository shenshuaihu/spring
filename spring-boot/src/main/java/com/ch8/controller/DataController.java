/**
 * 文件名: DataController.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch8.controller;

import com.ch8.domain.Person;
import com.ch8.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public Person save(String name, String address, Integer age) {
        Person p = personService.save(new Person(null, name, age, address));
        return p;
    }

    @RequestMapping("/q1")
    public List<Person> q1(String address) {
        List<Person> p = personService.findByAddress(address);
        return p;
    }

    @RequestMapping("/q2")
    public List<Person> q2(String name, String address) {
        return personService.findByNameAndAddress(name, address);
    }

    @RequestMapping("/q3")
    public List<Person> q3(String name, String address) {
        return personService.findByNameAndAddress(name, address);
    }

    @RequestMapping("/q4")
    public List<Person> q4(String name, String address) {
        return personService.withNameAndAddressQuery(name, address);
    }

    @RequestMapping("/sort")
    public List<Person> sort(String sort) {
        return personService.findAllSort(sort);
    }

    @RequestMapping("/page")
    public Page<Person> page(Integer page, Integer size) {
        return personService.findAll(page, size);
    }

    @RequestMapping("/auto")
    public Page<Person> auto(Person person) {
       // return personService.auto(person, new PageRequest(0, 10));
        return null;
    }


}
