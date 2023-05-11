package com.bookstore.user_promotionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserPromotionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserPromotionServiceApplication.class, args);
    }

}
