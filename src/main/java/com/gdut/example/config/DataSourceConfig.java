package com.gdut.example.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author LiYongFa
 * @version 1.0
 * @date 2020/6/10
 */
public class DataSourceConfig {

    @Value("${spring.dataSource.driver}")
    private String driver;

    @Value("${spring.dataSource.url}")
    private String url;

    @Value("${username2:defaultROOT}")
    private String username;

    @Value("${password}")
    private String password;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
