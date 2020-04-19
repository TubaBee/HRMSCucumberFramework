package com.hrms.API.step.practice1;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class goRestSteps {
	private RequestSpecification request;
	Response response;
	@Given("i provide th request data")
	public void i_provide_th_request_data() {
	    given().header("Content-Type","application/json").header("Authorization","Bearer 059MHCzH0kLQS_wTwCMeniTFjKrLvtS");
	}

	@When("i make a call to album API")
	public void i_make_a_call_to_album_API() {
		int albumId=4;
	  response=request.when().get("https://gorest.co.in/public-api/albums"+albumId);
	}

	@Then("I validate that {int} is the status code")
	public void qqqq(int expectedStausCode) {
		//1st way 
		response.then().assertThat().statusCode(expectedStausCode);
		
		//2nd way
		int actualCode=response.statusCode();
		Assert.assertEquals(expectedStausCode, actualCode);
		
		
	   String responseBody=response.prettyPrint();
	   System.out.println(responseBody);
	}

	@Then("I validate to response body")
	public void aaaaaa() {
//		//1st way
//		String expectedTitle="yazdi sacma sapan bir mesaj";
//	   response.then().body("_meta",Matchers.equalTo("OK. Everything workde as expected."));
//	
//	   //2nd way
//	   JsonPath jsonPath=response.jsonPath();
//		String result=jsonPath.prettify();
//		System.out.println(result);
//	 String actualTitle= jsonPath.getString("result.title");
//	System.out.println(actualTitle);
//	 Assert.assertEquals(expectedTitle,actualTitle);
//	int code =jsonPath.get("_meta.code");
//	System.out.println(code);
//	
		//3rd way
		JSONObject jsonObject=new JSONObject(response.asString());
		JSONObject meta=jsonObject.getJSONObject("_meta");
		System.out.println(meta);
		
		//This is for list
	//   JsonPath jsonPath=response.jsonPath();
//		List<Object> albums=jsonPath.get("result");
//		Object album=albums.get(0);
//		System.out.println(album);
		
		
	}

}
