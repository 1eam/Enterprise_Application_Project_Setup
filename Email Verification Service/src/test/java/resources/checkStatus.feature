#Fullfills requirement:"The application should provide its status to a logged-in person"
Feature: Checking status

  Scenario: The Authorized API-user makes a getrequest (or browses) to the /status endpoint
    When User browses to /status = checkStatus() method gets called
    Then Server responds with "Email Verification Controller working..."
#
#  Scenario: an UnAuthorized API-user makes a getrequest (or browses) to the /status endpoint
#    Given The user is not authorised (not logged in)
#    When The user makes a getrequest (or browses) to /status
#    Then Server responds with: 403 Unauthorized
#
#  Scenario: The Authorized API-user tries to send another request-method [POST, PUT, DELETE, PATCH .etc] to the /status endpoint
#    Given An Authorised user is logged in
#    When Another request method is sent to /status [like: POST, PUT, DELETE, PATCH .etc]
#    Then The server will will respond with 500 BAD request