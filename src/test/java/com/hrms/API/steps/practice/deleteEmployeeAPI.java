package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class deleteEmployeeAPI {
	private static RequestSpecification request;
	private Response response;
	
	@Given("user calls deleteEmployee API")
	public void user_calls_deleteEmployee_API() {
		request = given().header("Content-Type","application/json").header("Authorization",SyntaxAPIAuthorizationSteps.Token);
			

	}

	@When("user delete retrieve response")
	public void user_delete_retrieve_response() {
	   response=request.delete("http://54.167.125.15/syntaxapi/api/deleteEmployee.php/?employee_id=07197A");
		System.out.println("Pretty Print :: "+response.prettyPrint());	 
	}

	@Then("delete class status code is {int}")
	public void delete_class_status_code_is(Integer int1) {
		System.out.println("Status code :: "+response.getStatusCode()+ " --> "+ int1);
	}

	@Then("user validates employee is deleted")
	public void user_validates_employee_is_deleted() {
	String bdy=response.getBody().asString();
	Assert.assertTrue(bdy.contains("Entry deleted"));
	}

}
