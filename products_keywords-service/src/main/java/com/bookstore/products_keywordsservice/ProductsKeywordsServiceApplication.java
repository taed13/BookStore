package com.bookstore.products_keywordsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductsKeywordsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductsKeywordsServiceApplication.class, args);
    }

}
