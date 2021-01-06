Feature: Checking status

  Scenario: The Authorized API-user makes a getrequest (or browses) to the /status endpoint
    Given An Authorized user is logged in
    When The user makes a getrequest (or browses) to /status
    And The service is up
    Then Server responds with "Email Verification Controller working..."

  Scenario: The Authorized API-user tries to send another request-method [POST, PUT, DELETE, PATCH .etc] to the /status endpoint
    Given An Authorised user is logged in
    When Another request method is sent to /status [like: POST, PUT, DELETE, PATCH .etc]
    Then The server will will respond with 500 BAD request