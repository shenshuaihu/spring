/**
 * 文件名: Consume.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.example.demo.domain;

import java.math.BigDecimal;
import java.util.List;

/**
 * @description:
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-09-06 23:43
 */
public class Consume {
    /**
     *          "amount":350,
     *         "studentName":"梁梦瑶",
     *         "dataStrList":Array[23],
     *         "dailyTotalList":Array[23],
     *         "dailySupermarketList":Array[23],
     *         "dailyClinicList":Array[23],
     *         "dailyBreakfastList":Array[23],
     *         "dailyLunchList":Array[23],
     *         "dailyDinnerList":Array[23],
     *         "totalCanteen":247,
     *         "totalSupermarket":0,
     *         "totalClinic":0,
     *         "totalBreakfast":71,
     *         "totalLunch":106,
     *         "totalDinner":70,
     *         "frequencyDay":23,
     *         "frequencySupermarket":0,
     *         "frequencyClinic":0,
     *         "frequencyBreakfast":2,
     *         "frequencyLunch":8,
     *         "frequencyDinner":7
     */
    private Long id;
    /**
     * 余额
     */
    private BigDecimal amount;
    private String studentName;
    /**
     * 消费日期
     */
    private List<String> dataStrList;

    /**
     * 总额
     */
    private List<BigDecimal> dailyTotalList;


    /**
     * 超市
     */
    private List<BigDecimal> dailySupermarketList;

    /**
     * 医务室
     */
    private List<BigDecimal> dailyClinicList;

    /**
     * 早餐
     */
    private List<BigDecimal> dailyBreakfastList;

    /**
     * 午餐
     */
    private List<BigDecimal> dailyLunchList;

    /**
     * 晚餐
     */
    private List<BigDecimal> dailyDinnerList;

    private Long totalCanteen;
    private Long totalSupermarket;
    private Long totalClinic;
    private Long totalBreakfast;
    private Long totalLunch;

    private Long frequencyDay;
    private Long frequencySupermarket;
    private Long frequencyClinic;
    private Long frequencyBreakfast;
    private Long frequencyLunch;

    /**
     *
     */
    private Long frequencyDinner;

}
