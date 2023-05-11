package com.bookstore.manage_warehouseservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ManageWarehouseServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ManageWarehouseServiceApplication.class, args);
    }

}
