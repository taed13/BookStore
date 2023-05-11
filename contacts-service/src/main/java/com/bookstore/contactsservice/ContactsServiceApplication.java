package com.bookstore.contactsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ContactsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ContactsServiceApplication.class, args);
    }

}
