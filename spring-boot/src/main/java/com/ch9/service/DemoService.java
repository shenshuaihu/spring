/**
 * 文件名: PersonService.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch9.service;

import com.ch9.dao.PersonRepository;
import com.ch9.domain.Person;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-11-15 17:37
 */
@Service
public class DemoService {

    @Autowired
    private PersonRepository repository;

    @Autowired
    private PersonService personService;

    @Autowired
    private DemoService demoService;


    @Transactional(rollbackFor = {Exception.class}, propagation = Propagation.REQUIRES_NEW)
    public Person savePerson(Person person) {
        String msg = "   nested exception is java.sql.SQLException: ORA-12899: 列 \"RBSCMFUAT\".\"CMF_CLM_CLAIM_PAYMENTS\".\"DEFERRED_EXPENSES_FLAG\" 的值太大 (实际值: 3, 最大值: 1)\n" +
                "  \" ";
        person.setAddress(msg);
        Person p = repository.save(person);
        String name = "elijah";
        if (p.getName().equals(name)) {
            throw new IllegalArgumentException(name + "已经存在，数据不会回滚");
        }
        return p;
    }

    public Person save(Person person) {
       DemoService self = (DemoService) AopContext.currentProxy();
        Person p = self.savePerson(person);
        System.out.println("成功");
        return p;
    }
}
