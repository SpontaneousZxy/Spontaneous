package com.example.handsomeblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@MapperScan(basePackages = "com.example.handsomeblog.dal")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableWebMvc
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
