/**
 * 文件名: PersonRepository.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch8.repository;

import com.ch8.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @description:
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-08-15 16:46
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

    /**
     * 在语句中用名称来匹配查询
     *
     * @param address
     * @return
     */
    @Query("select p from Person p where p.address= :address")
    List<Person> findByAddress(@Param("address") String address);

 }
