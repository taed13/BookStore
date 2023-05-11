package com.bookstore.products_promotionsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductsPromotionsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductsPromotionsServiceApplication.class, args);
    }

}
