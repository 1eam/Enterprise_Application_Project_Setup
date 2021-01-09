package com.enterpriseapp.email_verification_service.controllers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailVerificationControllerTest {

    EmailVerificationController emailVerificationController = new EmailVerificationController();

    @Test
    void test_checkStatusMethod() {

        String expected = "Email Verification Controller working...";
        String actual = emailVerificationController.checkStatus();
        assertEquals(expected, actual);
    }
}