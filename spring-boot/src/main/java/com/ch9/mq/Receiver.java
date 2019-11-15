/**
 * 文件名: Receiver.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch9.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @description: 消息监听
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-11-15 10:52
 */
@Component
@Slf4j
public class Receiver {

    /**
     * ActiveMQ
     * 监听my-destination
     *
     * @param message 消息内容
     */
    @JmsListener(destination = "my-destination")
    public void receiveActiveMQMessage(String message) {

        log.info("ActiveMQ接收到：<{}>", message);
    }

    /**
     * RabbitMQ
     * 监听my-queue
     *
     * @param message 消息内容
     */
    @RabbitListener(queues = "my-queue")
    public void receiveRabbitMQMessage(String message) {

        log.info("RabbitMQ接收到：<{}>", message);
    }
}
