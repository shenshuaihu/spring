/**
 * 文件名: CacheController.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch8.controller;

import com.ch8.domain.Person;
import com.ch8.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 测试缓存的控制器
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-10-10 11:42
 */
@RestController
public class CacheController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/put")
    public Person put(String name, String address, Integer age) {
        Person person = new Person();
        person.setId(null);
        person.setName(name);
        person.setAge(age);
        person.setAddress(address);
        Person p = personService.saveCache(person);
        return p;
    }

    @RequestMapping("/able")
    public Person able(String name, String address, Integer age) {
        Person person = new Person();
        person.setId(null);
        person.setName(name);
        person.setAge(age);
        person.setAddress(address);
        Person p = personService.findOneCache(person);
        return p;
    }

    @RequestMapping("/evit")
    public String evit(String name) {
        Person person = personService.findByName(name).get(0);
        personService.removeCache(person);
        return "删除" + person.getName() + "成功";
    }
}
