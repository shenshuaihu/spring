/**
 * 文件名: CustomRepositoryImpl.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch8.support;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;


/**
 * @description:
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-08-28 22:56
 */
public class CustomRepositoryImpl <T, ID extends Serializable>
     //   extends SimpleJpaRepository<T, ID>  implements CustomRepository<T,ID>
{

    /*private final EntityManager entityManager;

    public CustomRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        super(domainClass, entityManager);
        this.entityManager = entityManager;
    }*/

 //   @Override
    public Page<T> findByAuto(T example, Pageable pageable) {
       // return findAll(byAuto(entityManager, example),pageable);
        return null;
    }


}