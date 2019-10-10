/**
 * 文件名: CacheController.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch8.controller;

import com.ch8.domain.Location;
import com.ch8.domain.Person;
import com.ch8.domain.PersonDoc;
import com.ch8.repository.PersonDocRepository;
import com.ch8.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private PersonDocRepository personDocRepository;

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


    /**
     * 以下是对MongoDB的数据测试
     */

    @RequestMapping("/save/personDoc")
    public PersonDoc save() {
        PersonDoc personDoc = new PersonDoc();
        personDoc.setName("沈帅虎");
        personDoc.setAge(18);

        Collection<Location> locations =  new LinkedHashSet<Location>();
        Location location1 = new Location("郑州", "2018");
        Location location2 = new Location("上海", "2018");
        Location location3 = new Location("北京", "2019");
        locations.add(location1);
        locations.add(location2);
        locations.add(location3);
        personDoc.setLocations(locations);

        return personDocRepository.save(personDoc);
    }

    @RequestMapping("/findByName/personDoc")
    public PersonDoc findByName(String name) {
        return personDocRepository.findByName(name);
    }

    @RequestMapping("/withQueryFindByAge/personDoc")
    public List<PersonDoc> withQueryFindByAge(Integer age) {
        return personDocRepository.withQueryFindByAge(age);
    }

}
