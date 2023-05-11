package com.bookstore.shipping_promotionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShippingPromotionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShippingPromotionServiceApplication.class, args);
    }

}
