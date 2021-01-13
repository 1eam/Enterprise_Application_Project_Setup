package com.enterpriseapp.enterpriseAppConfigServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EnterpriseAppConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnterpriseAppConfigServerApplication.class, args);
    }

}
