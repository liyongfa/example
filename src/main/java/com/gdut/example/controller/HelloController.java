package com.gdut.example.controller;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.spring.annotation.ApolloConfig;
import com.gdut.example.config.Student;
import com.gdut.example.dto.req.HelloReqDto;
import com.gdut.example.dto.resp.HelloRespDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private Student student;

    /**
     * 通过注解的方式获取到Apollo的Config对象，然后从对象中来获取属性值
     * 可以指定获取到哪个Apollo的C配置文件的Config对象
     * 当获取的配置信息的扩展名是properties的时候，是可以对扩展名进行省略的
     * 如果扩展名不是properties的话，那么就需要带上扩展名
     */
    @ApolloConfig("application.properties")
    private Config config;

    @ApiOperation("打招呼")
    @GetMapping("/hello")
    public HelloRespDto hello(HelloReqDto req) {
        HelloRespDto resp = new HelloRespDto();
        resp.setResult("{name=" + req.getName() + ",age=" + req.getAge() + "}");
        System.out.println(student.getName() + ":" + student.getAge());
        System.out.println(student.toString());
        System.out.println(student.hashCode());
        System.out.println("从Apollo提供的Config对象中来获取到属性值：username=" + config.getProperty("username", "找不到username这个属性的值！"));
        Config defaultApplicationConfig = ConfigService.getConfig("application.properties");
        // 如果配置文件的扩展名不是以properties结尾的话
        //那么需要使用ConfigFileFormat枚举类来进行扩展名的指定，否则识别不了？
        System.out.println("通过ConfigService.getConfig的方法来获取到Config对象：username=" + defaultApplicationConfig.getProperty("username", "defaultApplicationConfig找不到属性"));
        return resp;
    }
}
