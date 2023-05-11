package com.bookstore.slidesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SlidesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SlidesServiceApplication.class, args);
    }

}
