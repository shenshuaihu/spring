/**
 * 文件名: StatusHealth.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch9.health;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @description: 应用检查 自定义HealthIndicator
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-11-19 16:48
 */
@Component
public class StatusHealth implements HealthIndicator {

    @Override
    public Health health() {
        return null;
    }
}
