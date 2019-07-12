/**
 * 文件名: Ch7Application.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch7;

import com.ch7.domain.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-07-11 11:43
 */
@Controller
@SpringBootApplication
public class Ch7Application {

    @RequestMapping("/")
    public String index(Model model) {

        Person single = new Person("aa", 11);

        List<Person> people =  new ArrayList<>();

        Person p1 = new Person("xx", 11);
        Person p2 = new Person("yy", 22);
        Person p3 = new Person("zz", 33);
        people.add(p1);
        people.add(p2);
        people.add(p3);

        model.addAttribute("singlePerson", single);
        model.addAttribute("people", people);
        return "index";
    }

    @RequestMapping(value = "/json", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String json(Model model) {
        Person person = new Person("aa", 11);
        model.addAttribute("single", person);
        return "jsonView";
    }

    public static void main(String[] args) {
        SpringApplication.run(Ch7Application.class, args);
    }

}
