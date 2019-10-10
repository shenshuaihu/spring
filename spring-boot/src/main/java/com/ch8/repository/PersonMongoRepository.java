/**
 * 文件名: PersonRepository.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch8.repository;

import com.ch8.domain.PersonMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;


/**
 * @description:
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-08-15 16:46
 */
public interface PersonMongoRepository extends MongoRepository<PersonMongo, String> {

    PersonMongo findByName(String name);

    /**
     * 查询参数构造JSON字符串即可
     * @param age
     * @return
     */
    @Query("{'age': ?0}")
    List<PersonMongo> withQueryFindByAge(Integer age);

}
