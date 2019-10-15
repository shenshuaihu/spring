/**
 * 文件名: SysRole.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch9.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @description:
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-10-11 18:10
 */

@Entity
@Data
public class SysRole {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
}
