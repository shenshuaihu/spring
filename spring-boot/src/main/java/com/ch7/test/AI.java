/**
 * 文件名: AI.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch7.test;

import java.util.Scanner;

/**
 * @description:
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-09-24 20:33
 */
public class AI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        while (true) {
            str = sc.next();
            str = str.replace("吗", "");
            str = str.replace("?", "!");
            str = str.replace("？", "!");
            System.out.println(str);
        }
    }
}
