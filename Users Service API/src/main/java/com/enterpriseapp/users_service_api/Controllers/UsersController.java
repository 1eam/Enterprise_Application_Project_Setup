package com.enterpriseapp.users_service_api.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    private Environment environment;

    @GetMapping("/status")
    public String checkStatus(){
        return "User Controller Working on port " + environment.getProperty("local.server.port");
    }

    @PostMapping("/users")
    public String createUser(){
        return "Create user method was called";
    }
}