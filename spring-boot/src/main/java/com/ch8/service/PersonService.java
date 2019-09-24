/**
 * 文件名: PersonService.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch8.service;

import com.ch8.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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
}
