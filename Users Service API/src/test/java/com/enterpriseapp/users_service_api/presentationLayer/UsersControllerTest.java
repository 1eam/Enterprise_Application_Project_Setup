package com.enterpriseapp.users_service_api.presentationLayer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.*;

class UsersControllerTest {
    UsersController usersController = new UsersController();
//    mock
    @Autowired
    private Environment environment;

    @Test
    void checkStatus() {
//        This doesnt work yet because system the system isnt running. Therefore a nullpointerException will be caused.
//        Later implementation will be done with RestAssured
        String expected ="User Controller Working on port " + environment.getProperty("local.server.port");
        String actual = usersController.checkStatus();
        assertEquals(expected, actual);
    }

    @Test
    void createUser() {
//        Implement with REST-ASSURED
    }
}