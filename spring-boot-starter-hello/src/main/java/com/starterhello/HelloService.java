/**
 * 文件名: HelloService.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.starterhello;

import lombok.Data;

/**
 * @description: 判断依据
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-07-10 23:30
 */
@Data
public class HelloService {

    private String msg;

    public String sayHello() {
        return "Hello" + msg;
    }
}
