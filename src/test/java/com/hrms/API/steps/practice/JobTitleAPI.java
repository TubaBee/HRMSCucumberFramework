package com.hrms.API.steps.practice;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import org.junit.Assert;

public class JobTitleAPI {
	
	private static RequestSpecification request;
	private Response response;
	
	@Given("user calls get Job Title list")
	public void user_calls_get_Job_Title_list() {
	   request= given().header("Content-Type","application/json").header("Authorization",SyntaxAPIAuthorizationSteps.Token);
	}

	@When("user jobTitle retrieve response")
	public void user_jobTitle_retrieve_response() {
	    response=request.get("http://54.167.125.15/syntaxapi/api/jobTitle.php");
	}
	
	@Then("one jobTitle list class status code is {int}")
	public void one_jobTitle_list_class_status_code_is(Integer int1) {
		response.then().assertThat().statusCode(int1);
	}

	@Then("user validates Job Title list")
	public void user_validates_Job_Title_list() {
		System.out.println(response.prettyPrint());
		Assert.assertTrue(response.getBody().asString().contains("Job Title List"));
	  
	}


}
