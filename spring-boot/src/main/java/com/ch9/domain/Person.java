/**
 * 文件名: Person.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch9.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

/**
 * @description: person javabean
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-07-11 11:57
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue
    private Long id;
    @Size(max = 12, min = 2)
    private String name;
    private Integer age;
    private String address;
    private String nation;
}
