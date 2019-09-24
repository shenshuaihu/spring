/**
 * 文件名: StudentInfo.java
 * 版权：Copyright 2017-2022 HAND All Rights Reserved.
 * 描述:
 */
package com.example.demo.domain;

import lombok.Data;

/**
 * @description:  学生信息
 *
 * @author: Shenshuaihu
 * @version: 1.0
 * @data: 2019-09-06 23:56
 */
@Data
public class StudentInfo {

    private Long iD;

    /**
     * 学生名字
     */
    private String studentName;

    /**
     * 学校名字 襄城县实验高中
     */
    private String schoolName;

    /**
     * 账户名 登录用户名 手机号
     */
    private Long account;

    /**
     * 学生学号
     */
    private Long studentNO;

    /**
     *
     */
    private Long consumNo;

    /**
     * 入学时间
     */
    private Long gradeID;

    /**
     * 班级
     */
    private Long classID;
    private String imgUrl;

}
