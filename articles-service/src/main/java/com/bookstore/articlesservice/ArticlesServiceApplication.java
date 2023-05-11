package com.bookstore.articlesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ArticlesServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArticlesServiceApplication.class, args);
    }

}
