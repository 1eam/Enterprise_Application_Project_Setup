package com.enterpriseapp.email_verification_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EmailVerificationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailVerificationServiceApplication.class, args);
    }

}
