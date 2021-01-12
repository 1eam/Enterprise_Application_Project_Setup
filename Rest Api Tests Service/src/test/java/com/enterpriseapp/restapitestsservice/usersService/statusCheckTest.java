package com.enterpriseapp.restapitestsservice.usersService;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class statusCheckTest {
    private final String CONTEXT_PATH = "users-service-api";
    @BeforeEach
    void setup() throws Exception{
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 54963;
    }
}
