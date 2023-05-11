package com.bookstore.publisherservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PublisherServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PublisherServiceApplication.class, args);
    }

}
