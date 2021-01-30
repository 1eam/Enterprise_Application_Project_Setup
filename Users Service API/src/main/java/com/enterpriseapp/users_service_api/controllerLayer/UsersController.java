package com.enterpriseapp.users_service_api.controllerLayer;

import com.enterpriseapp.users_service_api.controllerLayer.endpointModels.userRegistration.UserRegistrationModel_Response;
import com.enterpriseapp.users_service_api.controllerLayer.endpointModels.userRegistration.UsersRegistrationModel_Request;
import com.enterpriseapp.users_service_api.controllerLayer.endpointModels.userData.UserModel_Response;
import com.enterpriseapp.users_service_api.serviceLayer.UsersDto;
import com.enterpriseapp.users_service_api.serviceLayer.UsersService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UsersController {
    @Autowired
    private Environment environment;

    @Autowired
    UsersService usersService;

    @GetMapping("/status")
    public String checkStatus(){
        return "User Controller Working on port " + environment.getProperty("local.server.port") + ", with token: " + environment.getProperty("token.secret");
    }

    @PostMapping(value = "/register", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
                                      produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRegistrationModel_Response> createUser(@Valid @RequestBody UsersRegistrationModel_Request userInput){
        //Maps the request-model to UsersDto type -> for users service processing
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        UsersDto usersDto = modelMapper.map(userInput, UsersDto.class);

        //calls creation method on usersDto-type
        usersService.createUser(usersDto);

        //returns a response-entity with http status & body
        //that contains the User-Registration-Response Model structure.
        UserRegistrationModel_Response returnValue = modelMapper.map(usersDto, UserRegistrationModel_Response.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
    }

    @GetMapping(value="/users/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<UserModel_Response> getUser(@PathVariable("userId") String userId) {

        UsersDto usersDto = usersService.getUserByUserId(userId);
        UserModel_Response returnValue = new ModelMapper().map(usersDto, UserModel_Response.class);

        return ResponseEntity.status(HttpStatus.OK).body(returnValue);
    }
}