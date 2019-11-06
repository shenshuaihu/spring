/**
 * 文件名: test.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch9;

import com.ch9.domain.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description:
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-10-28 17:02
 */
public class test {
    public static void main(String[] args) {
        Long a = Long.valueOf(1);
        Long b = Long.valueOf((long) 1.0);
        System.out.println(a.equals(b));
        System.out.println(a == b);
    }
}
