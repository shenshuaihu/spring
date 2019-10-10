/**
 * 文件名: PersonService.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch8.service;

import com.ch8.domain.Person;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @description:
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-08-22 23:35
 */

public interface PersonService {

    Person save(Person person);

    List<Person> findByAddress(String address);

    List<Person> findByName(String name);

    List<Person> findByNameAndAddress(String name, String address);

    List<Person> withNameAndAddressQuery(String name, String address);

    /**
     * 分页
     */
    Page<Person> findAll(Integer page, Integer size);

    /**
     * 排序
     * @param sort 需要排序的字段
     * @return
     */
    List<Person> findAllSort(String sort);

    /**
     *
     */
//    Page<Person> auto(Person person, PageRequest pageRequest);

    Person findByNameStartsWith(String name);

    /**
     * 以下是事务的处理，包含异常的处理
     */
    Person savePersonWithRollBack(Person person);
    Person savePersonWithoutRollBack(Person person);

    Person testTransactional(Person person);


    /**
     * 以下缓存的处理
     */
    Person saveCache(Person person);

    void removeCache(Person person);

    Person findOneCache(Person person);

}
