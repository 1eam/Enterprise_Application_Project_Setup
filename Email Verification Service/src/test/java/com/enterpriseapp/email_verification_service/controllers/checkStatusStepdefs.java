package com.enterpriseapp.email_verification_service.controllers;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class checkStatusStepdefs {
    EmailVerificationController emailVerificationController = new EmailVerificationController();
    String serviveStatusCheckResponse;


    @When("A getrequest to \\/status is triggered by the server")
    public void aGetrequestToStatusIsTriggeredByTheServer() {
        serviveStatusCheckResponse = emailVerificationController.checkStatus();
    }

    @Then("Server responds with {string}")
    public void serverRespondsWith(String featureString) {
        Assertions.assertEquals(featureString, serviveStatusCheckResponse);
    }

    @When("Another request is sent to \\/status [like: POST, PUT, DELETE, PATCH .etc]")
    public void anotherRequestIsSentToStatusLikePOSTPUTDELETEPATCHEtc() {

    }

    @Then("It wont trigger the method that returns \\/status method at all")
    public void itWontTriggerTheMethodThatReturnsStatusMethodAtAll() {
    }
}
