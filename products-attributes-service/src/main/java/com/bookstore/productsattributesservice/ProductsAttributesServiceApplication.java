package com.bookstore.productsattributesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductsAttributesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductsAttributesServiceApplication.class, args);
    }

}
