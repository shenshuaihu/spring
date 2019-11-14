/**
 * 文件名: CsvJobListener.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch9.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

/**
 * @description: JOB 监听  目前用于时间的记录
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-11-05 22:12
 */
public class CsvJobListener implements JobExecutionListener {

    long startTime;
    long endTime;

    @Override
    public void beforeJob(JobExecution jobExecution) {
        startTime = System.currentTimeMillis();
        System.out.println("任务开始处理");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {

        endTime = System.currentTimeMillis();
        System.out.println("任务处理结束");
        System.out.println("耗时：" + (endTime - startTime) + "ms");
    }
}
