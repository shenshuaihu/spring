/**
 * 文件名: test.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch5;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @description:
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-11-12 17:47
 */
public class test {
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal("2.000");
        System.out.println(a.scale());
        System.out.println(a.setScale(2, RoundingMode.DOWN));
        System.out.println(a.setScale(2));
    }
}
