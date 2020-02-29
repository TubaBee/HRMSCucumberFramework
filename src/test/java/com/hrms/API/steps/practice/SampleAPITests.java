package com.hrms.API.steps.practice;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

//import static io.restassured.RestAssured.*; eger digeri calismazsa bunu ekleyebiliriz

public class SampleAPITests {
	//@Test
	public void getAllJobTitles() {
		Response response = RestAssured.given().contentType("application/json").header("Authorization",
				"Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzQ4MjgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU5MDAyOCwidXNlcklkIjoiMzYyIn0.1ThliRpBZo4dUq1XjrRL6P3zqSa8ybQOXthpOQxNyOU")
				.when().get("http://54.167.125.15/syntaxapi/api/jobTitle.php");

		response.prettyPrint();
		int actualResponseCode = response.getStatusCode();
	}
//	@Test
	public void getOneEmployee() {
		Response response =RestAssured.given().param("employee_id", "06215A").contentType("application/json")
		.header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzQ4MjgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU5MDAyOCwidXNlcklkIjoiMzYyIn0.1ThliRpBZo4dUq1XjrRL6P3zqSa8ybQOXthpOQxNyOU")
		.when().get("http://54.167.125.15/syntaxapi/api/getOneEmployee.php");
		
		response.prettyPrint();
	}
	
	/*
	 * Task: getAllEmployeeStatuses
	 * Pretty print
	 * print status code
	 * 
	 */
	//@Test
	public void getAllEmployeeStatus() {
		Response response =RestAssured.given().contentType("application/json")
				.header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzQ4MjgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU5MDAyOCwidXNlcklkIjoiMzYyIn0.1ThliRpBZo4dUq1XjrRL6P3zqSa8ybQOXthpOQxNyOU")
				.when().get("http://54.167.125.15/syntaxapi/api/getAllEmployees.php");
		
		response.prettyPrint();
		int actualResponseCode = response.getStatusCode();
		System.out.println("Response code: "+actualResponseCode);
	}
	
	@Test
	public void createEmployee() {
		Response response =RestAssured.given().contentType("application/json")
				.header("Authorization","Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE1ODI0NzQ4MjgsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTU4MjU5MDAyOCwidXNlcklkIjoiMzYyIn0.1ThliRpBZo4dUq1XjrRL6P3zqSa8ybQOXthpOQxNyOU")
//				.param( "emp_firstname", "newStu")
//				.param("emp_lastname", "StuLast")
//				.param( "emp_middle_name", "nS")
//				.param("emp_gender", "1")
//				.param("emp_birthday", "1990-02-02")
//				.param("emp_status", "Freelance")	
//				.param("emp_job_title", "Controller")
				.body("{\n    \"emp_firstname\": \"newStu\",\n    \"emp_lastname\": \"newLast\",\n    \"emp_middle_name\": \"nS\",\n    \"emp_gender\": \"1\",\n    \"emp_birthday\": \"1990-09-09\",\n    \"emp_status\": \"Worker\",\n    \"emp_job_title\": \"Cloud Consultant\"\n}")
				.when().post("http://54.167.125.15/syntaxapi/api/createEmployee.php");
		
		response.prettyPrint();
		int actualStatusCode=response.getStatusCode();
		
		Assert.assertEquals(200, actualStatusCode);
		
	}
	
	

	

}
