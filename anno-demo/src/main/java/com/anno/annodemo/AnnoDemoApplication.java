package com.anno.annodemo;

import com.anno.annodemo.config.MyJdbc;
import com.anno.annodemo.config.MyJdbcByConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableConfigurationProperties(MyJdbcByConfiguration.class)
public class AnnoDemoApplication {

    @Autowired
    MyJdbcByConfiguration myJdbcByConfiguration;

    public static void main(String[] args) {
        SpringApplication.run(AnnoDemoApplication.class, args);
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
//                MyJdbc.class, MyJdbcByConfiguration.class);
//
//        MyJdbcByConfiguration jdbc = context.getBean("myJdbcByConfiguration", MyJdbcByConfiguration.class);
//        System.out.println(jdbc);
    }

    @GetMapping("/test")
    public String get() {
        System.out.println(myJdbcByConfiguration);
        return "ok";
    }

}
