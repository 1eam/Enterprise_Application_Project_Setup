package com.enterpriseapp.password_reset_service.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PasswordResetController {

    @GetMapping("/status")
    String checkStatus(){
        return "working...";
    }
}