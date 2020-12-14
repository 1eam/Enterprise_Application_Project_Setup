package com.enterpriseapp.password_reset_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PasswordResetServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PasswordResetServiceApplication.class, args);
    }

}
