package com.bookstore.provinceservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProvinceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProvinceServiceApplication.class, args);
    }

}
