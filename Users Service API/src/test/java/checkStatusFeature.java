import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.CoreMatchers.equalTo;

//TODO#2: put ip and portnumber in variable, replacing hardcoded: http://localhost:59203/
//TODO#3: work with user registration and login. Auth.


public class checkStatusFeature {
    private Response response;

    @Given("User is not authorised")
    public void noPrep() {
        given().contentType(ContentType.JSON);
    }

    @When("The user makes a call to /status")
    public void aCallToStatusIsMade() {
        //Todo#2
        response = when().get("http://localhost:59203/users-service-api/status");

    }

    @Then("Server should respond with statuscode 403 - Unauthorised")
    public void respondWith403() throws Throwable{
        response.then().statusCode(403);
    }


//----------------SCENARIO_2------------------//


    @Given("The user is registered")
    public void registerUser() {

    }

    @And("The user has logged-in")
    public void loginUser() {

    }

    //Todo#2
    @When("A call to \\/status is made")
    public void aCallToStatusIsMade2() {
        aCallToStatusIsMade();
    }

    //Todo#3
    @Then("Server should respond with: working, + serverport")
    public void serverShouldRespondWithWorkingServerport() {
        response.then().assertThat().body(equalTo("User Controller Working on port 59203"));
    }

}

