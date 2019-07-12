/**
 * 文件名: WebSocketConfig.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch7.config.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @description: 配置WebSocket
 *          注释@EnableWebSocketMessageBroker开始使用STOMP协议来传输基于代理（message broker）的消息
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-07-12 16:39
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    /**
     *  注册STOMP协议的节点（endpoint），并映射的指导的URL。
     *  注册一个STOMP的endpoint，并指定使用SickJS协议
     * @param registry
     */
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/endpointSSH").withSockJS();
    }

    /**
     *  配置消息代理（Message Broker）
     *  广播式应配置一个/topic 消息代理
     * @param registry
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic");
    }

}
