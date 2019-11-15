/**
 * 文件名: Msg.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch9.mq;

import org.springframework.jms.core.MessageCreator;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

/**
 * @description: ActiveMQ消息定义
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-11-15 10:44
 */
public class Msg implements MessageCreator {
    @Override
    public Message createMessage(Session session) throws JMSException {
        return session.createTextMessage("ActiveMQ测试消息！");
    }
}
