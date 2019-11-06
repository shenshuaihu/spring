/**
 * 文件名: Test.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch8.util;

import com.ch7.domain.Person;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
    public static void main(String[] args) {
        //System.out.println(isNumber(new BigDecimal(1.00)));
        //System.out.println(isNumber(new BigDecimal(0.00)));
        //System.out.println(isNumber(new BigDecimal(0.10)));
        //System.out.println(isNumber(new BigDecimal(2.82)));
        BigDecimal decimal = new BigDecimal("3.933");
        System.out.println(decimal.scale());
        BigDecimal decimal2 = new BigDecimal(3.00);
        BigDecimal decimal3 = new BigDecimal("3.0900");
        System.out.println(decimal2.scale());
        System.out.println(decimal3.scale());
        BigDecimal decimal4 =  decimal3.setScale(2);
        System.out.println(decimal3.compareTo(decimal4) > 0);
        System.out.println(decimal4.scale());

    }



}
