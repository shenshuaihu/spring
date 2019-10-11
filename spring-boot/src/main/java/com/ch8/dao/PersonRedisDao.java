/**
 * 文件名: PersonRedisDao.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch8.dao;

import com.ch8.domain.PersonRedis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @description:
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-10-10 17:17
 */
@Repository
public class PersonRedisDao {

    /**
     * 直接注入stringRedisTemplate
     */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 基于字符串的简单属性操作方法
     */
    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valOpsStr;

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valOps;

    /**
     *  存字符串
     *
     * @param key
     * @param value
     */
    public void setStringRedisTemplateDemo(String key, String value) {
        valOpsStr.set(key, value);
    }

    /**
     *  存对象
     *
     * @param personRedis
     */
    public void save(PersonRedis personRedis) {
        valOps.set(personRedis.getId(), personRedis);
    }

    /**
     *  获取字符串
     *
     * @param key 字符串的key
     * @return
     */
    public String getString(String key) {
        return valOpsStr.get(key);
    }

    /**
     *  获取对象
     *
     * @param id 对象ID
     * @return
     */
    public PersonRedis getPersonRedis(String id) {
        return (PersonRedis) valOps.get(id);
    }

}
