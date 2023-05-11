package com.bookstore.carrierservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CarrierServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarrierServiceApplication.class, args);
    }

}
