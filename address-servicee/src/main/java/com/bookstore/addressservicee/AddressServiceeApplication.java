package com.bookstore.addressservicee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class AddressServiceeApplication {

    public static void main(String[] args) {
        SpringApplication.run(AddressServiceeApplication.class, args);
    }

}
