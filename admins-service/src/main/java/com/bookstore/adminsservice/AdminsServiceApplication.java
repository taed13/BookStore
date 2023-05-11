package com.bookstore.adminsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AdminsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminsServiceApplication.class, args);
    }

}
