/**
 * 文件名: Ch8Application.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch8;

import com.ch8.support.CustomRepositoryFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * @description:
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-08-15 10:37
 */
@SpringBootApplication
@EnableCaching
@EnableMongoRepositories
public class Ch8Application {
    public static void main(String[] args) {
        SpringApplication.run(Ch8Application.class, args);
    }

}
