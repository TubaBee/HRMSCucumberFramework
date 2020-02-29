package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class getOneEmployee {
	
	private static RequestSpecification request;
	private Response response;
	
	@Given("user calls get one Employee API")
	public void user_calls_get_one_Employee_API() {
		request = given().header("Content-Type","application/json").header("Authorization",SyntaxAPIAuthorizationSteps.Token);
  
	}

	@When("user one retrieve response")
	public void user_one_retrieve_response() {
		response=request.get("http://54.167.125.15/syntaxapi/api/getOneEmployee.php/?employee_id=05577A");
		
	}

	@Then("one Employee class status code is {int}")
	public void one_Employee_class_status_code_is(Integer int1) {

		int code=response.statusCode();
		System.out.println(code+" --> benim yazdigim -->>> "+int1);
	}

	@Then("user validates employee is one")
	public void user_validates_employee_is_one() {
		System.out.println("   ----->>>>>>   "+response.prettyPrint());
		Assert.assertTrue(response.getBody().asString().contains("employee"));
	}

}
