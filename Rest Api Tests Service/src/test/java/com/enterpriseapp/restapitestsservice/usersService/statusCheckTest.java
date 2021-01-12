package com.enterpriseapp.restapitestsservice.usersService;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class statusCheckTest {

    private final String context_path = "users-service-api";

    @BeforeEach
    void setup() throws Exception{
        RestAssured.baseURI = "http://192.168.192.47";
        RestAssured.port = 55266;
    }

    @Test
    final void testApplicationStatusResponse(){
        Response response = given()
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
