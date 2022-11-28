package com.anno.annodemo.config;

import lombok.Data;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


//@ConfigurationPropertiesScan(basePackages = "com.anno.annodemo.config")
//@EnableConfigurationProperties(MyJdbcByConfiguration.class)
//@EnableAutoConfiguration
//@Component
@ConfigurationProperties(prefix = "jdbc")
@Data
public class MyJdbcByConfiguration {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
}
