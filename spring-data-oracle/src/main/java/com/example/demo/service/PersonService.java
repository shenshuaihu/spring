/**
 * 文件名: PersonService.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.example.demo.service;

import com.example.demo.domain.Person;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-08-22 23:35
 */

@Repository
public interface PersonService {

    List<Person> findByAddress(String address);

    Person save(Person person);

}
