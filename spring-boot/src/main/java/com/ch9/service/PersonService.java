/**
 * 文件名: PersonService.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch9.service;

import com.ch9.domain.Person;
import com.ch9.dao.PersonRepository;
import com.ch9.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-11-15 17:37
 */
@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class PersonService {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private DemoService demoService;

    public Person savePerson(Person person) {
        Person perso = new Person();
        BeanUtils.copyProperties(person, perso);
        try {
            demoService.save(person);
            person.setNation(person.getName());
            log.info("插入成功");
        } catch (RuntimeException e) {
            log.error("运行时异常", e);
            perso.setNation(StringUtil.stringByU8Byte("运行时异常" + e.getMessage(), 4000));
        } catch (Exception e) {
            log.error("异常", e);
            perso.setNation(StringUtil.stringByU8Byte("异常" + e, 4000));
        }
        Person p = repository.save(perso);
        return p;
    }
}
