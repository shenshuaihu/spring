/**
 * 文件名: Message.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch9.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description: 测试不同角色用户数据展示
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-10-12 10:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {

    private String title;
    private String content;
    private String etraInfo;
}
