package com.gdut.example.dto.req;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author LiYongFa
 * @version 1.0
 * @date 2020/6/10
 */

public class HelloReqDto {

    @ApiModelProperty("姓名")
    private String name;

    @ApiModelProperty("年龄")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
