package com.gdut.example.config;

import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import org.springframework.cloud.context.refresh.ContextRefresher;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author LiYongFa
 * @version 1.0
 * @date 2020/6/10
 */
@Component
public class ApolloConfigChangeListener {

    @Resource
    private ContextRefresher refresher;

    @com.ctrip.framework.apollo.spring.annotation.ApolloConfigChangeListener
    public void onChange(ConfigChangeEvent changeEvent) {
        // 进行Environment中属性的更新
        refresher.refresh();
    }
}
