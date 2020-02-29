package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class getAllEmployeeAPI {
	
	private static RequestSpecification request;
	private Response response;

	@Given("user calls All Employee in API")
	public void user_calls_All_Employee_in_API() {
		request = given().header("Content-Type","application/json").header("Authorization",SyntaxAPIAuthorizationSteps.Token);
	}

	@When("All user retrieve response")
	public void all_user_retrieve_response() {
		response=request.get("http://54.167.125.15/syntaxapi/api/getAllEmployees.php");
	}

	@Then("All employees status code is {int}")
	public void all_employees_status_code_is(Integer int1) {
		response.then().assertThat().statusCode(int1);
	}

	@Then("All user validates employee is created")
	public void all_user_validates_employee_is_created() {
		System.out.println(response.prettyPrint());
	}

}
