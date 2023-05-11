package com.bookstore.bill_shippingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BillShippingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillShippingServiceApplication.class, args);
    }

}
