package com.chen.study;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan
public class SpringbootDemo10Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo10Application.class, args);
    }

}
