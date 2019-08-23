/**
 * 文件名: PersonServiceImpl.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.example.demo.service.impl;

import com.example.demo.domain.Person;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description:
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-08-22 23:35
 */
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findByAddress(String address) {
        return personRepository.findByAddress(address);
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }
}
