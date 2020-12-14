package com.enterpriseapp.email_verification_service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailVerificationController {

    @GetMapping("/status")
    public String checkStatus(){
        return "working...";
    }
}