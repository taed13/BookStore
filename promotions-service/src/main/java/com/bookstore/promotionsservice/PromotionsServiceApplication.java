package com.bookstore.promotionsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PromotionsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PromotionsServiceApplication.class, args);
    }

}
