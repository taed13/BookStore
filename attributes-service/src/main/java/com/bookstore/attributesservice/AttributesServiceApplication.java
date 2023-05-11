package com.bookstore.attributesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AttributesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AttributesServiceApplication.class, args);
    }

}
