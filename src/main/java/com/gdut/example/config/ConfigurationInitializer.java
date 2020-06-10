package com.gdut.example.config;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LiYongFa
 * @version 1.0
 * @date 2020/6/10
 */
@Configuration
public class ConfigurationInitializer {

    @Bean
    DataSourceConfig dataSourceConfig() {
        Config config = ConfigService.getAppConfig();
        return new DataSourceConfig();
    }
}
