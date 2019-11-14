/**
 * 文件名: HomeController.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch9.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-10-12 10:45
 */
@RestController
public class CsvBatchController {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job importJob;
    public JobParameters jobParameters;


    /**
     * 手动执行批量导入
     *
     * @param fileName
     * @return
     * @throws Exception
     */
    @RequestMapping("/imp")
    public String imp(String fileName) throws Exception{
        String path = "http://127.0.0.1:8888/imp?fileName=D:\\MyFile\\Develop\\IDEA\\demo\\spring\\spring-boot\\src\\main\\resources\\csv\\" + fileName + ".csv";
        jobParameters = new JobParametersBuilder()
                .addLong("time", System.currentTimeMillis())
                .addString("input.file.name", path)
                .toJobParameters();
        jobLauncher.run(importJob, jobParameters);

        return "OK";
    }


}
