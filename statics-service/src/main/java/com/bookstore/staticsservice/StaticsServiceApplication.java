package com.bookstore.staticsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StaticsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StaticsServiceApplication.class, args);
    }

}
