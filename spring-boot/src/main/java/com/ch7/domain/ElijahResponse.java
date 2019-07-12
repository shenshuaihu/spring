/**
 * 文件名: ElijahRespone.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch7.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @description: 用于服务器想向浏览器发生消息
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-07-12 17:10
 */
@AllArgsConstructor
@Getter
public class ElijahResponse {
    private String responseMessage;
}
