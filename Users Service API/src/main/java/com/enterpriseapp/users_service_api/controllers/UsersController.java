package com.enterpriseapp.users_service_api.controllers;

import com.enterpriseapp.users_service_api.serviceLayer.UsersDto;
import com.enterpriseapp.users_service_api.serviceLayer.UsersService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UsersController {

    @Autowired
    private Environment environment;
    @Autowired
    UsersService usersService;

    @GetMapping("/status")
    public String checkStatus(){
        return "User Controller Working on port " + environment.getProperty("local.server.port");
    }

    @PostMapping("/users")
    public ResponseEntity createUser(@Valid @RequestBody UsersRegistrationModel userInput){
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        UsersDto usersDto = modelMapper.map(userInput, UsersDto.class);

        usersService.createUser(usersDto);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}