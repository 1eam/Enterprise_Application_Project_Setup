package com.enterpriseapp.email_verification_service.controllers;

import com.enterpriseapp.email_verification_service.controllers.EmailVerificationController;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class checkStatusTest {
    EmailVerificationController emailVerificationController = new EmailVerificationController();
    private String actual;

    @When("User browses to \\/status = checkStatus\\() method gets called")
    public void user_browses_to_status_check_status_method_gets_called() {
        // Write code here that turns the phrase above into concrete actions
        actual = emailVerificationController.checkStatus();
        throw new io.cucumber.java.PendingException();
    }


    @Then("Server responds with {string}")
    public void server_responds_with(String string) {
        String expected = "Email Verification Controller working...";
        actual = emailVerificationController.checkStatus();
        assertEquals(expected, actual);
    }

}
