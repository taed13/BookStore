package com.bookstore.eventsservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EventsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventsServiceApplication.class, args);
    }

}
