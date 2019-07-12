/**
 * 文件名: WsController.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch7.controller;

import com.ch7.domain.ElijahMessage;
import com.ch7.domain.ElijahResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @description: WebSocket 控制器
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-07-12 17:15
 */
@Controller
public class WsController {

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
}
