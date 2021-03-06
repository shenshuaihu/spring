/**
 * 文件名: CacheController.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch8.controller;

import com.ch8.dao.PersonRedisDao;
import com.ch8.domain.Location;
import com.ch8.domain.Person;
import com.ch8.domain.PersonMongo;
import com.ch8.domain.PersonRedis;
import com.ch8.repository.PersonMongoRepository;
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
    private PersonMongoRepository personMongoRepository;

    /**
     * redis的DAO层
     */
    @Autowired
    private PersonRedisDao personRedisDao;

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
    public PersonMongo save() {
        PersonMongo personMongo = new PersonMongo();
        personMongo.setName("沈帅虎");
        personMongo.setAge(18);

        Collection<Location> locations =  new LinkedHashSet<Location>();
        Location location1 = new Location("郑州", "2018");
        Location location2 = new Location("上海", "2018");
        Location location3 = new Location("北京", "2019");
        locations.add(location1);
        locations.add(location2);
        locations.add(location3);
        personMongo.setLocations(locations);

        return personMongoRepository.save(personMongo);
    }

    @RequestMapping("/findByName/personDoc")
    public PersonMongo findByName(String name) {
        return personMongoRepository.findByName(name);
    }

    @RequestMapping("/withQueryFindByAge/personDoc")
    public List<PersonMongo> withQueryFindByAge(Integer age) {
        return personMongoRepository.withQueryFindByAge(age);
    }


    /**
     * 以下是对Redis的数据测试
     */

    @RequestMapping("/redis/set/person")
    public PersonRedis redisSet(String id) {
        PersonRedis personRedis = new PersonRedis();
        personRedis.setId(id);
        personRedis.setName("elijah");
        personRedis.setAge(18);
        personRedisDao.save(personRedis);
        return personRedis;
    }



    @RequestMapping("/redis/set")
    public String redisGet(String key, String value) {
        personRedisDao.setStringRedisTemplateDemo(key,value);
        return key + " : " + value;
    }

    @RequestMapping("/redis/get")
    public String redisGet(String name) {
        return personRedisDao.getString(name);
    }

    @RequestMapping("/redis/get/person")
    public PersonRedis redisGetPerson(String id) {
        return personRedisDao.getPersonRedis(id);
    }

}
