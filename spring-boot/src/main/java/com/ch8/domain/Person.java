/**
 * 文件名: Person.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch8.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedQuery;

/**
 * @description: person javabean
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-07-11 11:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@NamedQuery(name = "Person.withName", query = "select p from Person p where p.name = ?1 and p.address=?2")
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer age;
    private String address;
    private String method;
    private String description;
}
