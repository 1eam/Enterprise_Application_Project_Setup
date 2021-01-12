package com.enterpriseapp.restapitestsservice.usersService;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Should test Users-Service - regarding login")
public class userLoginTest {

    private final String context_path = "users-service-api";

    @BeforeEach
    void setup() throws Exception{
        RestAssured.baseURI = "http://192.168.192.47";
        RestAssured.port = 8011;
    }

    @Test //POST
    @DisplayName("Should test, [to /login], if token and userId are present - respond with 200")
    final void testLoginResponse(){

        //What we want to send in the login body
        Map<String, String> loginCredentials = new HashMap<>();
        loginCredentials.put("email", "esther@gmail.com");
        loginCredentials.put("password", "12345678");


        Response response =
                given()
                        .contentType("application/json")
                        .accept("application/json")
                        .body(loginCredentials)
                .when()
                        .post(context_path + "/login")
                .then()
                        .statusCode(200)
                .extract()
                        .response();


        String token = response.header("token");
        String userId = response.header("userId");

        //Assert that token and userId are present in responseheaders
        assertNotNull(token);
        assertNotNull(userId);
    }
}