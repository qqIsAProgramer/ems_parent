package com.qyl.entity;

import lombok.Data;

/**
 * @Author: qyl
 * @Date: 2021/2/15 22:52
 * @Description:
 */
@Data
public class Emp {

    private Integer id;

    private String name;

    /**
     * 头像存放路径
     */
    private String avatar;

    private Double salary;

    private Integer age;
}
