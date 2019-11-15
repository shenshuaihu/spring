/**
 * 文件名: Receiver.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch9.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @description: 消息监听 activeMQ
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-11-15 10:52
 */
@Component
@Slf4j
public class Receiver {

    /**
     * 监听my-destination目的地的消息
     * @param message 消息内容
     */
    @JmsListener(destination = "my-destination")
    public void receiveMessage(String message) {

        log.info("ActiveMQ接收到：<{}>", message);
    }
}
