package com.bookstore.detail_billservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DetailBillServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DetailBillServiceApplication.class, args);
    }

}
