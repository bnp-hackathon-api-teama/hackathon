package com.bnpparibas.hackathon.api.tests;

public class StepDefs extends SpringIntegrationTest {
    
    @When("^the client calls /version$")
    public void the_client_issues_GET_version() throws Throwable {
        executeGet("http://localhost:8080/version");
    }
}