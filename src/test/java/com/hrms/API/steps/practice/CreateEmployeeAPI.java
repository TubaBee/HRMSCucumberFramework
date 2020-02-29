package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;

import com.hrms.utils.CommonMethods;

import static io.restassured.RestAssured.given;

import com.hrms.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateEmployeeAPI {
	
	private static RequestSpecification request;
	private Response response;
	
	@Given("user calls create Employee API")
	public void user_calls_create_Employee_API() {
		request = given().header("Content-Type","application/json").header("Authorization",SyntaxAPIAuthorizationSteps.Token);
		request.body(CommonMethods.readJson("C:\\Users\\Tuba\\eclipse-workspace\\HrmsCucumberFramework\\src\\test\\resources\\JSONFiles\\createEmployee.json"));
	}

	@When("user retrieve response")
	public void user_retrieve_response() {
	response=request.post("http://54.167.125.15/syntaxapi/api/createEmployee.php");
	  
	}

	@Then("status code is {int}")
	public void status_code_is(Integer int1) {
		response.then().assertThat().statusCode(int1);
	   
	}

	@Then("user validates employee is created")
	public void user_validates_employee_is_created() {
		System.out.println(response.prettyPrint());
	}

}