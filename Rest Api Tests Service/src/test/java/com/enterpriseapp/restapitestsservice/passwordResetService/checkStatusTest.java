package com.enterpriseapp.restapitestsservice.passwordResetService;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@DisplayName("Should test Password-Reset-Service - on authorisation, and expected responses")
public class checkStatusTest {

    private final String context_path = "password-reset-service";
    private String authorizationHeader = "Authorization";
    private String token = "Bearer " + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI1N2M2NTViNS02ZjA2LTQxNmUtYjhiYi02OTkzYTJkNDMzOGQiLCJleHAiOjE2MTEwMTc1NDF9.1bDiHHKTR1t7LRiOeuzcQfzrF1o6iZ6QPnh7jIOT2KWY4B4Qoq_MI75BuIqgOpxfo4otaLEgtOYPwLqhFxO7rA";

    @BeforeEach
    void setup() throws Exception{
        RestAssured.baseURI = "http://192.168.192.47";
        RestAssured.port = 8011;
    }

    @Test //GET
    @DisplayName("Should test Authorised request, with token, [to /status] - to respond with 200")
    final void testStatusResponse(){
        given()
                .contentType("application/json")
                .accept("application/json")
                .header(authorizationHeader, token)
                .when()
                .get(context_path + "/status")
                .then()
                .statusCode(200)
                .contentType("application/json")
        ;
    }

    @Test //GET
    @DisplayName("Should test unAuthorised request [to /status] - to respond with 403")
    final void testunAuthorisedStatusResponse(){
        given()
                .contentType("application/json")
                .accept("application/json")
                .when()
                .get(context_path + "/status")
                .then()
                .statusCode(403)
                .contentType("application/json")
        ;
    }
}
