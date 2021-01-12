package com.enterpriseapp.restapitestsservice.usersService;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Should test Users-Service - on authorisation, and expected responses")
public class userRegistrationTest {

    private final String context_path = "users-service-api";

    @BeforeEach
    void setup() throws Exception{
        RestAssured.baseURI = "http://192.168.192.47";
        RestAssured.port = 8011;
    }

    @Test //POST
    @DisplayName("Should test, [to /register] - expected registration-response + respond with 201")
    final void tesrRegistrationResponse(){

        //What we want to send in the body
        Map<String, Object> registrationCredentials = new HashMap<>();
        registrationCredentials.put("firstName", "Esther");
        registrationCredentials.put("lastName", "Tester");
        registrationCredentials.put("email", "esther@gmail.com");
        registrationCredentials.put("password", "12345678");


        Response response =
                given()
                        .contentType("application/json")
                        .accept("application/json")
                        .body(registrationCredentials)
                .when()
                        .post(context_path + "/register")
                .then()
                        .statusCode(201)
                        .contentType("application/json")
                .extract()
                        .response();

        //Also test response object is not empty, and has id size equal to 36
        String userId = response.jsonPath().getString("userId");
        assertNotNull(userId);
        assertEquals(userId.length(), 36);

    }
}