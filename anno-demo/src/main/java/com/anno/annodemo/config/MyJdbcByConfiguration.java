package com.anno.annodemo.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;


//@ConfigurationPropertiesScan(basePackages = "com.anno.annodemo.config")
@EnableConfigurationProperties(MyJdbcByConfiguration.class)
//@EnableAutoConfiguration
@ConfigurationProperties(prefix = "jdbc")
//@Component
@Data
public class MyJdbcByConfiguration {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
}
