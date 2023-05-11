package com.bookstore.bill_promotionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BillPromotionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillPromotionServiceApplication.class, args);
    }

}
