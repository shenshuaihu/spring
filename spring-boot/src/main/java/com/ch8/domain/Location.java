/**
 * 文件名: Location.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch8.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @description:
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-10-10 15:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Location {
    private String place;
    private String year;
}
