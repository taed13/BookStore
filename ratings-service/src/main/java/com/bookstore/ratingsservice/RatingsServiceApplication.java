package com.bookstore.ratingsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RatingsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RatingsServiceApplication.class, args);
    }

}
