/**
 * 文件名: HomeController.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch9.controller;

import com.ch9.domain.Message;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description:
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-10-12 10:45
 */
@Controller
public class HomeController {


    @RequestMapping("/")
    public String index(Model model) {
        Message message = new Message("测试标题", "测试内容", "额外信息，只对管理员显示");
        model.addAttribute(message);
        return "home";
    }



}
