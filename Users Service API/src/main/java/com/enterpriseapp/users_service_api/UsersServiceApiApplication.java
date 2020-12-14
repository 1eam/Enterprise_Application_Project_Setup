package com.enterpriseapp.users_service_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class UsersServiceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersServiceApiApplication.class, args);
    }

}
