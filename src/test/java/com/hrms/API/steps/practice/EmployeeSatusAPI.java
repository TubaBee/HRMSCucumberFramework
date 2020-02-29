package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EmployeeSatusAPI {
	private static RequestSpecification request;
	private Response response;
	
	@Given("user calls get Employee status list")
	public void user_calls_get_Employee_status_list() {
		 request= given().header("Content-Type","application/json").header("Authorization",SyntaxAPIAuthorizationSteps.Token);
	}

	@When("user status retrieve response")
	public void user_status_retrieve_response() {
		 response=request.get("http://54.167.125.15/syntaxapi/api/employeeStatus.php");
	}

	@Then("Employee status list class status code is {int}")
	public void employee_status_list_class_status_code_is(int scode) {
		scode=response.getStatusCode();
		Assert.assertEquals(scode, 200);
	}

	@Then("user validates employee status list")
	public void user_validates_employee_status_list() {
		System.out.println("------>>>>>>>"+response.prettyPrint());
		Assert.assertTrue(response.getBody().asString().contains("Employee Status List"));
	}

}
