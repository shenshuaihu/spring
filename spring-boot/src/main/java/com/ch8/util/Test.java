/**
 * 文件名: Test.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch8.util;

import com.ch7.domain.Person;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.math.BigDecimal.ROUND_HALF_DOWN;

/**
 * @description:
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-08-23 00:18
 */
public class Test {
    /**
     * @description:
     *
     * @author: Shenshuaihu
     * @version: 1.0
     * @data: 2019-08-07 17:43
     */
    public static class sort {
        public   void main(String[] args) {
            List<Person> people = new ArrayList<>();
            Person person1 = new Person();
            Person person2 = new Person();
            Person person3 = new Person();
            Person person4 = new Person();
            person1.setAge(10);
            person2.setAge(4);
            person3.setAge(9);
            person4.setAge(2);
            people.add(person1);
            people.add(person2);
            people.add(person3);
            people.add(person4);
            people = people.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
            //  people.stream().sorted(Comparator.comparing(Person::getAge));
            //   people.sort(Comparator.comparing(Person::getAge).reversed());

           /* System.out.println(people.get(0).getAge());
            System.out.println(people.get(1).getAge());
            System.out.println(people.get(2).getAge());
            System.out.println(people.get(3).getAge());*/

            BigDecimal a = new BigDecimal(28.62);
            BigDecimal b = new BigDecimal(500);

            BigDecimal ab =  a.add(b);
            BigDecimal ad =  a.subtract(b);
            BigDecimal c =  a.multiply(b);
            BigDecimal currencyRate = a.divide(b,8, ROUND_HALF_DOWN);



            System.out.println(a.compareTo(b));
            System.out.println(b.compareTo(b));
            System.out.println(b.compareTo(a));
           /* System.out.println(c);
            System.out.println(currencyRate);*/


            List<String> codes = new ArrayList<>();
            codes.add("ADT");
            codes.add("ADT");
            codes.add("ADT");
            codes.add("ADT");
            codes.add("ADT");
            System.out.println(codes);
            codes = codes.stream().distinct().collect(Collectors.toList());
            System.out.println(codes);

        }
    }
}
