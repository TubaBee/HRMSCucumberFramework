package com.hrms.API.steps.practice;

import static io.restassured.RestAssured.given;

import com.hrms.utils.CommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class updateEmployeeAPI {
	
	private static RequestSpecification request;
	private Response response;
	
	@Given("user calls update Employee API")
	public void user_calls_update_Employee_API() {
		request = given().header("Content-Type","application/json").header("Authorization",SyntaxAPIAuthorizationSteps.Token);
		request.body(CommonMethods.readJson("C:\\Users\\Tuba\\eclipse-workspace\\HrmsCucumberFramework\\src\\test\\resources\\JSONFiles\\updateEmployee.json"));
	}

	@When("update user retrieve response")
	public void update_user_retrieve_response() {
		response=request.put("http://54.167.125.15/syntaxapi/api/updateEmployee.php");
		  
	}

	@Then("update class status code is {int}")
	public void update_class_status_code_is(Integer int1) {
		response.then().assertThat().statusCode(int1);
	}

	@Then("user validates employee is updated")
	public void user_validates_employee_is_updated() {
		System.out.println(response.prettyPrint());
	}


}
