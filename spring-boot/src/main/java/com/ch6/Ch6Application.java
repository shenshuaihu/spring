/**
 * 文件名: Ch6Application.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch6;

import com.ch6.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-07-08 22:57
 */
@SpringBootApplication
@RestController
public class Ch6Application {

    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/")
    String index() {
        return "Hello Spring Boot，" +
                " \n authorkName: " + authorSettings.getName() +
                " \n authorAge: " + authorSettings.getAge() ;
    }

    public static void main(String[] args) {
            SpringApplication.run(Ch6Application.class, args);
        }


}
