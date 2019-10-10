/**
 * 文件名: PersonServiceImpl.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch8.service.impl;

import com.ch8.dao.PersonAutoRepository;
import com.ch8.domain.Person;
import com.ch8.repository.PersonRepository;
import com.ch8.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-08-22 23:35
 */
@Service
@Slf4j
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    //@Autowired
    //private PersonAutoRepository autoRepository;

    @Override
    public List<Person> findByAddress(String address) {
        return personRepository.findByAddress(address);
    }

    @Override
    public List<Person> findByName(String name) {
        return personRepository.findByName(name);
    }
    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> findByNameAndAddress(String name, String address) {
        return personRepository.findByNameAndAddress(name, address);
    }

    @Override
    public List<Person> withNameAndAddressQuery(String name, String address) {
        return personRepository.nameAndAddressQuery(name, address);
    }

    @Override
    public Page<Person> findAll(Integer page, Integer size) {
        return personRepository.findAll(new PageRequest(page, size));
    }

    @Override
    public List<Person> findAllSort(String sort) {
        return personRepository.findAll(new Sort(Sort.Direction.ASC, sort));
    }

   /* @Override
    public Page<Person> auto(Person person, PageRequest pageRequest) {
       // return autoRepository.findByAuto(person, pageRequest);
        return null;
    }*/

    @Override
    public Person findByNameStartsWith(String name) {
        return personRepository.findByNameStartsWith(name);
    }

    /**
     *  特定异常数据回滚
     * @param person 保存数据
     * @return
     */
    @Override
    @Transactional(rollbackFor = {IllegalArgumentException.class})
    public Person savePersonWithRollBack(Person person) {
        Person p = personRepository.save(person);
        String name = "elijah";
        if (p.getName().equals(name)) {
            // 手动触发异常
            throw new IllegalArgumentException(name + "已经存在，数据将回滚");
        }
        return p;
    }

    /**
     * noRollbackFor 特定异常 数据不会滚
     * IllegalArgumentException不合法的参数异常
     * @param person
     * @return
     */
    @Override
    @Transactional(noRollbackFor = IllegalArgumentException.class)
    public Person savePersonWithoutRollBack(Person person) {
        Person p = personRepository.save(person);
        String name = "elijah";
        if (p.getName().equals(name)) {
            throw new IllegalArgumentException(name + "已经存在，数据不会回滚");
        }
        return p;
    }


    @Transactional(rollbackFor = RuntimeException.class, timeout = 3000)
    public Person testTransactional(Person person) {
        person.setMethod("testTransactional()");
        person.setDescription("noRollbackFor = RuntimeException.class,特定异常不回滚");
        Person p = personRepository.save(person);
        try {
            this.transactional1(person);
        } catch (RuntimeException e) {
            throw new RuntimeException(person.getName() + "更新异常，数据不会回滚");
        }
        return p;
    }

    /**
     *  REQUIRED 也是默认是方式
     *  如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。
     */


    @Transactional(propagation = Propagation.NEVER, rollbackFor = RuntimeException.class)
    public Person transactional1(Person person) {
        Person per = new Person();
        per.setId(null);
        per.setName(person.getName());
        per.setAge(person.getAge());
        per.setAddress(person.getAddress());
        per.setMethod("transactional1()");
        per.setDescription("REQUIRED，如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。");
        Person p = personRepository.save(per);
        String name = "elijah";
        if (p.getName().equals(name)) {
            throw new RuntimeException(name + "已经存在，数据回滚");
        }
        return person;
    }


    /**
     *  使用@CachePut 来更新或者新增数据到缓存中
     *
     * @param person
     * @return
     */
    @Override
    @CachePut(value = "people", key = "#person.id")
    public Person saveCache(Person person) {
        Person p = personRepository.save(person);
        log.info("新增缓存 value: people, key: {}", p.getId());
        return p;
    }

    /**
     * CacheEvict 删除key为id的数据
     *
     * @param person
     */
    @Override
    @CacheEvict(value = "people")
    public void removeCache(Person person) {
        personRepository.delete(person);
        log.info("清空缓存 value: people, key: {} ", person.getName());
    }

    /**
     *  使用@Cacheable 来更新或者新增数据到缓存中
     *
     * @param person
     * @return
     */
    @Override
    @Cacheable(value = "people", key = "#person.name")
    public Person findOneCache(Person person) {
        Person p = personRepository.findByName(person.getName()).get(0);
        log.info("新增缓存 value: people, key: {}", p.getName());
        return p;
    }


}
