package com.enterpriseapp.restapitestsservice.usersService;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class statusCheckTest {

    private final String context_path = "users-service-api";

    @BeforeEach
    void setup() throws Exception{
        RestAssured.baseURI = "http://192.168.192.47";
        RestAssured.port = 8011;
    }

    @Test
    @DisplayName("Should test Authorised request, with token, [to /status] to respond with 200")
    final void testStatusResponse(){
        Response response = given()
                .contentType("application/json")
                .accept("application/json")
                .header("Authorization", "Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiI1N2M2NTViNS02ZjA2LTQxNmUtYjhiYi02OTkzYTJkNDMzOGQiLCJleHAiOjE2MTEwMTc1NDF9.1bDiHHKTR1t7LRiOeuzcQfzrF1o6iZ6QPnh7jIOT2KWY4B4Qoq_MI75BuIqgOpxfo4otaLEgtOYPwLqhFxO7rA")
        .when()
                .get(context_path + "/status")
        .then()
                .statusCode(200)
                .contentType("application/json")
        .extract()
                .response();

    }
    @Test
    @DisplayName("Should test unAuthorised request [to /status] to respond with 403")
    final void testunAuthorisedStatusResponse(){
        Response response =
        given()
                .contentType("application/json")
                .accept("application/json")
        .when()
                .get(context_path + "/status")
        .then()
                .statusCode(403)
                .contentType("application/json")
        .extract()
                .response();
    }
}
