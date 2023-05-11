package com.bookstore.user_favouriteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UserFavouriteServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserFavouriteServiceApplication.class, args);
    }

}
