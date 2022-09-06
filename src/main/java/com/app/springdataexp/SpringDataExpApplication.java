package com.app.springdataexp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringDataExpApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDataExpApplication.class, args);
    }
}