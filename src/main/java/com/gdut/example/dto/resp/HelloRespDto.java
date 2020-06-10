package com.gdut.example.dto.resp;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author LiYongFa
 * @version 1.0
 * @date 2020/6/10
 */
public class HelloRespDto {

    @ApiModelProperty("返回结果")
    private String result;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
