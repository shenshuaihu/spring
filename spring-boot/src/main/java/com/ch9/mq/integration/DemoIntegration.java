/**
 * 文件名: DemoIntegration.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.ch9.mq.integration;


import com.rometools.rome.feed.synd.SyndEntry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
//import org.springframework.integration.dsl.IntegrationFlow;
//import org.springframework.integration.dsl.IntegrationFlows;
//import org.springframework.integration.dsl.channel.MessageChannels;
//import org.springframework.integration.dsl.core.Pollers;
//import org.springframework.integration.dsl.file.Files;
//import org.springframework.integration.dsl.mail.Mail;
//import org.springframework.integration.feed.inbound.FeedEntryMessageSource;
//import org.springframework.integration.file.support.FileExistsMode;
//import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

import static java.lang.System.getProperty;

/**
 * @description: Spring Integration
 *
 * @author: ShenShuaihu
 * @version: 1.0
 * @data: 2019-11-15 12:05
 */
@Component
public class DemoIntegration {

    /**
     * 自动获取httpxxx资源
     */
    @Value("https://spring.io/blog.atom")
    Resource resource;

    /**
     * 配置默认的轮询方式
     *
     * @return
     */
    //@Bean
    //public PollerMetadata poller() {
    //    return Pollers.fixedRate(500).get();
    //}
    //
    ///**
    // *  构造feed入站通道适配器作为数据输入
    // *
    // * @return
    // * @throws IOException
    // */
    //@Bean
    //public FeedEntryMessageSource feedEntryMessageSource() throws IOException {
    //
    //    FeedEntryMessageSource messageSource = new FeedEntryMessageSource(resource.getURL(), "news");
    //    return messageSource;
    //}
    //
    //@Bean
    //public IntegrationFlow myFlow() throws IOException {
    //    // 流程从from开始
    //    return IntegrationFlows.from(feedEntryMessageSource())
    //            // 通过路由方法route来选择路由，消息体payload的类型为SyndEntry
    //            .<SyndEntry, String> route(
    //                    payload -> payload.getCategories().get(0).getName(),
    //                    // 通过不同分类的值转向不同的消息通道 releases——>releasesChannel 等
    //                    mapping -> mapping
    //                            .channelMapping("releases", "releasesChannel")
    //                            .channelMapping("engineering", "engineeringChannel")
    //                            .channelMapping("news", "newsChannel")
    //            // get 方法获取IntegrationFlows实体
    //            ).get();
    //}
    //
    //@Bean
    //public IntegrationFlow releasesFlow() {
    //    return IntegrationFlows.from(String.valueOf(MessageChannels.queue("releasesChannel", 10))) //1
    //            .<SyndEntry, String> transform(
    //                    payload -> "《" + payload.getTitle() + "》 " + payload.getLink() + getProperty("line.separator")) //2
    //            .handle(Files.outboundAdapter(new File("e:/springblog")) //3
    //                    .fileExistsMode(FileExistsMode.APPEND) //4
    //                    .charset("UTF-8") //5
    //                    .fileNameGenerator(message -> "releases.txt") //6
    //                    .get())
    //            .get();
    //}
    //
    //@Bean
    //public IntegrationFlow engineeringFlow() {
    //    return IntegrationFlows.from(MessageChannels.queue("engineeringChannel", 10))
    //            .<SyndEntry, String>transform(
    //                    payload -> "《" + payload.getTitle() + "》 " + payload.getLink() + getProperty("line.separator")
    //            )
    //            .handle(Files.outboundAdapter(new File("e:/springblog"))
    //                    .fileExistsMode(FileExistsMode.APPEND)
    //                    .charset("UTF-8")
    //                    .fileNameGenerator(message -> "engineering.txt")
    //                    .get())
    //            .get();
    //}
    //
    //@Bean
    //public IntegrationFlow newsFlow() {
    //    return IntegrationFlows.from(MessageChannels.queue("newsChannel", 10))
    //            .<SyndEntry, String> transform(
    //                    payload -> "《" + payload.getTitle() + "》 " + payload.getLink() + getProperty("line.separator"))
    //            .enrichHeaders( //1
    //                    Mail.headers()
    //                            .subject("来自Spring的新闻")
    //                            .to("shenshuaixian@qq.com")
    //                            .from("shen_shuaihu@163.com"))
    //            .handle(Mail.outboundAdapter("smtp.163.com") //2
    //                    .port(25)
    //                    .protocol("smtp")
    //                    .credentials("shen_shuaihu@163.com", "shenshuaihu")
    //                    .javaMailProperties(p -> p.put("mail.debug", "false")), e -> e.id("smtpOut"))
    //            .get();
    //}
}
