package com.gdut.example;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Set;

/**
 * @author LiYongFa
 * @version 1.0
 * @date 2020/6/10
 */
@EnableSwagger2
@EnableApolloConfig
@Configuration
@SpringBootApplication
public class ExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }

    /**
     * 在容器完成加载之后进行调用
     */
    @Bean
    public ApplicationRunner addApolloConfigChangeListener() {
        return args -> {
            // 对默认的application添加change监听器
            // 可以通过获取变更信息做特殊处理，比如当更新的属性值是
            // 数据库的相关链接属性的时候，这时候就可以充值数据库连接池，虽然数据库连接池在一般情况都不会通过热部署的
            // 方式来进行数据的修改
            Config config = ConfigService.getAppConfig();
            config.addChangeListener(changeEvent -> {
                Set<String> changedKeys = changeEvent.changedKeys();
                System.out.println("----------------------------------------");
                changedKeys.forEach(System.out::println);
                System.out.println("----------------------------------------");
            });
        };
    }
}
