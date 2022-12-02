package com.hello.springbootmultisource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication/*(exclude = {
        DataSourceAutoConfiguration.class
})*/
public class SpringbootMultiSourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMultiSourceApplication.class, args);
    }

}
