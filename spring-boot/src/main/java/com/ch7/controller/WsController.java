/**
 * 文件名: WsController.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch7.controller;

import com.ch7.domain.ElijahMessage;
import com.ch7.domain.ElijahResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.broker.SimpleBrokerMessageHandler;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @description: WebSocket 控制器
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-07-12 17:15
 */
@Controller
@Slf4j
public class WsController {

    /**
     * 通过SimpMessagingTemplate 向浏览器发生消息
     */
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    /**
     *  当浏览器向服务端发生请求时，通过@MessageMapping映射/welcome这个地址
     *  注解@MessageMapping使用方法与@RequestMapping相似
     * @param message
     * @return
     * @throws Exception
     */
    @MessageMapping("welcome")
    @SendTo("/topic/getResponse")
    public ElijahResponse say(ElijahMessage message) throws Exception {
        Thread.sleep(3000);
        return new ElijahResponse("Welcome, " + message.getName() + "!");
    }

    /**
     *  点对点聊天
     *
     * @param principal 包含当前用户的信息
     * @param msg
     */
    @MessageMapping("/chat")
    public void handleChar(Principal principal, String msg) {

        // 判断发生给谁
        if (principal.getName().equals("ssh")) {
            // 发生消息给用户  接收消息的用户、浏览器订阅地址和消息内容
            messagingTemplate.convertAndSendToUser("elijah",
                    "/queue/notifications",
                    principal.getName() + "-send: " + msg);
        } else {
            messagingTemplate.convertAndSendToUser("ssh",
                    "/queue/notifications",
                    principal.getName() + "-send: " + msg);
        }
    }


}
