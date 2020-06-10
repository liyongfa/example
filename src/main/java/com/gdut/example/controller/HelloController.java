package com.gdut.example.controller;

import com.gdut.example.dto.req.HelloReqDto;
import com.gdut.example.dto.resp.HelloRespDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiYongFa
 * @version 1.0
 * @date 2020/6/10
 */
@Api(tags = {"打招呼接口"})
@RestController
public class HelloController {

    @ApiOperation("打招呼")
    @GetMapping("/hello")
    public HelloRespDto hello(HelloReqDto req) {
        HelloRespDto resp = new HelloRespDto();
        resp.setResult("{name=" + req.getName() + ",age=" + req.getAge() + "}");
        return resp;
    }
}
