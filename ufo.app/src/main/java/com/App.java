package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Created by frinder6 on 2016/9/26.
 */
@SpringBootApplication
@EnableAsync
@MapperScan({"com.ufo.mapper", "com.ufo.mapper.impl", "com.ufo.dao"})
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }


}
