Feature: Provide app status to user

  Scenario: An unauthorised user makes a request to /status
    Given User is not authorised
    When The user makes a call to /status
    Then Server should respond with statuscode 403 - Unauthorised

  Scenario: An Authorised user makes a request to /status
    Given The user is registered
    And The user has logged-in
    When A call to /status is made
    Then Server should respond with: working, + serverport