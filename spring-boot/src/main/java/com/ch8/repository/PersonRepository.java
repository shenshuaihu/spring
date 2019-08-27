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
     *  通过名字相等查询
     *
     * @param name  名字
     * @return list集合
     */
    List<Person> findByName(String name);

    /**
     * 模糊查询
     * @param name 名字
     * @return
     */
    List<Person> findByNameLike(String name);

    /**
     * 通过名字和地址查询
     *
     * @param name 名字
     * @param address 地址
     * @return
     */
    List<Person> findByNameAndAddress(String name, String address);

    /**
     * 查询符合添加的前10条
     * @param name
     * @return
     */
    List<Person> findFirst10ByName(String name);

    /**
     * 查询前30条数据
     *
     * @param name
     * @return
     */
    List<Person> findTop10ByName(String name);

    /**
     * 在语句中用名称来匹配查询
     *
     * @param address
     * @return
     */
    @Query("select p from Person p where p.address= :address")
    List<Person> findByAddress(@Param("address") String address);

    /**
     * 更新查询
     * @param name
     * @return  更新语句影响行数
     */
    @Modifying
    @Transactional
    @Query("update Person p set p.name=?1")
    int setName(String name);

    /**
     * 查询并排序
     * @param name
     * @param sort
     * @return
     */
    List<Person> findByName(String name, Sort sort);

    Page<Person> findByName(String name, Pageable pageable);

    @Query("select p from Person p where p.name= :name and p.address= :address")
    List<Person> nameAndAddressQuery(String name, String address);


}
