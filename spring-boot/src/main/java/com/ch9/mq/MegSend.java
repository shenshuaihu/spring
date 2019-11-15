/**
 * 文件名: MegSend.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch9.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


/**
 * @description: 消息发送及目前地定义
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-11-15 10:47
 */
@Component
public class MegSend implements CommandLineRunner {

    /**
     * 发送消息的模板
     */
    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Override
    public void run(String... args) throws Exception {

        // my-destination 为目的地
        jmsTemplate.send("my-destination", new Msg());


        // rabbitMQ 向队发送消息
        rabbitTemplate.convertAndSend("my-queue", "来自RabbitMQ的问候");
    }

    /**
     * 定义队列 name = my-queue
     *
     * @return
     */
    @Bean
    public Queue elijahQueue() {
        return new Queue("my-queue");
    }


}
