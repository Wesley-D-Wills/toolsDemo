package com.anno.annodemo;

import com.anno.annodemo.config.MyJdbc;
import com.anno.annodemo.config.MyJdbcByConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnoDemoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(AnnoDemoApplication.class, args);
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                MyJdbc.class, MyJdbcByConfiguration.class);

        MyJdbcByConfiguration jdbc = context.getBean("myJdbcByConfiguration", MyJdbcByConfiguration.class);
        System.out.println(jdbc);
    }

}
