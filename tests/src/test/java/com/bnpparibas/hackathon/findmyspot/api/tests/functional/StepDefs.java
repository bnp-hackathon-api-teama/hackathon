package com.bnpparibas.hackathon.findmyspot.api.tests.functional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.springframework.http.HttpStatus;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefs extends SpringIntegrationTest {

    @When("^the client calls employee echo$")
    public void the_client_calls_employee_echo() throws Throwable {
        executeGet("http://localhost:8080/employee/echo");
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        final HttpStatus currentStatusCode = latestResponse.getTheResponse().getStatusCode();
        assertThat("status code is incorrect : " + latestResponse.getBody(), currentStatusCode.value(), is(statusCode));
    }

    @And("^the client receives server version (.+)$")
    public void the_client_receives_server_version_body(String version) throws Throwable {
        assertThat(latestResponse.getBody(), is(version));
    }
    
	@When("^the user with id (\\d+) asks for an assignment to the building (.+)$")
	public void the_user_with_id_asks_for_an_assignment_to_the_building(int userId, String building) throws Throwable {
		executeGet("http://localhost:8080/employee/echo");
	}

	@Then("^the parking lot result is (.+)$")
	public void the_parking_lot_result_is(String parkingLotAlias) throws Throwable {
		executeGet("http://localhost:8080/employee/echo");
	}
	
	
}