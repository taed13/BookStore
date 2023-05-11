package com.bookstore.shipping_methodservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ShippingMethodServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShippingMethodServiceApplication.class, args);
    }

}
