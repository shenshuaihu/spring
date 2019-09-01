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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
}
