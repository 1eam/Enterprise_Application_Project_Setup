package com.enterpriseapp.users_service_api;

import com.enterpriseapp.users_service_api.service2serviceCommunicationLayer.FeignExceptionsCenter;
import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class UsersServiceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersServiceApiApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }

    @Bean
    public FeignExceptionsCenter getFeignExceptionsCenter(){
        return new FeignExceptionsCenter();
    }
}
