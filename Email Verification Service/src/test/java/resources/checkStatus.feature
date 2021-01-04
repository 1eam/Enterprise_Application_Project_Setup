Feature: The uptime status is provided on the /status endpoint, and returns a "working..." message in text-format

  Scenario: someone browses (makes a getrequest) to the /status endpoint
    When A getrequest to /status is triggered by the server
    Then Server responds with "Email Verification Controller working..."

  Scenario: someone tries to send another request-type [POST, PUT, DELETE, PATCH .etc] to the /status endpoint
    When Another request is sent to /status [like: POST, PUT, DELETE, PATCH .etc]
    Then It wont trigger the method that returns /status method at all