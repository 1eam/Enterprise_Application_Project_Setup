package com.enterpriseapp.users_service_api.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @GetMapping("/status")
    public String checkStatus(){
        return "User Controller Working...";
    }
}