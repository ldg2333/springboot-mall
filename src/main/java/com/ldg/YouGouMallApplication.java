package com.ldg;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@MapperScan("com.ldg.dao")
@EnableScheduling
public class YouGouMallApplication {
    public static void main(String[] args) {
        SpringApplication.run(YouGouMallApplication.class, args);
    }
}
