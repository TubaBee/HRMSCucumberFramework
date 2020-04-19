package com.hrms.API.step.practice1;

import static com.hrms.utils.CommonMethods.readJson;
import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.firefox.FirefoxDriver.SystemProperty;

import com.hrms.utils.APIConstants;
import com.hrms.utils.ReadWriteFile;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;;

public class GTokenEllionStep {
	private RequestSpecification request;
	private Response response;
	static String URI = "http://54.167.125.15/syntaxapi/api/generateToken.php";

	@When("I provide the header for Generating Token")
	public void i_provide_the_header_for_Generating_Token() {
		request = given().header("Content-Type", "application/json");

	}

	@When("I provide the bpdy for Genarating Token")
	public void i_provide_the_bpdy_for_Genarating_Token() {
		// 1st way
//	   String bodyText ="{\"email\":\"sytaxAPI@gmail.com\",\"password\":\"sampleapi123\"}";
//	   request.body(bodyText);
		// 2nd way
		// request.body(CommonMethods.readJson(APIConstants.GENERATE_TOKEN_JSON));
		// importa Common Mettinkine static yazar ve .readJson eklersem Common Method
		// yazisini yamama gerek kalamz

		// 2nd way changing import
		request.body(readJson(APIConstants.GENERATE_TOKEN_JSON));
	}

	@When("I make Generate Token call")
	public void i_make_Generate_Token_call() {
		
		response = request.when().post(URI);
	}

	@Then("I validate the Genarate Token status code")
	public void i_validate_the_Genarate_Token_status_code() {
		// 1st way , RestAssured assurtion
		response.then().assertThat().statusCode(200);

		// 2nd way , JUnit Assertion
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
		System.out.println(statusCode);
	}

	@Then("I get the token from the response")
	public void i_validate_Generate_Token_response_has_contains_token() {
		System.out.println();
		System.out.println("!st way " + response.asString());
		System.out.println("2nd way " + response.body().asString());
		System.out.println("3rd way " + response.getBody().asString());

		// 1st way by using JsonPath
		JsonPath jsonPath = response.jsonPath();
//		jsonPath.prettyPrint();
		
		String jsonPathToken=jsonPath.getString("token");
		System.out.println("jsonPathToken " + jsonPathToken);
		
		//2nd way, using JsonObject
		JSONObject json=new JSONObject(response.asString());
		String jsonObjectToken=json.getString("token");
		System.out.println("jsonObjectToken "+ jsonObjectToken);
		
		ReadWriteFile.writeTextIntoFile(SystemProperty("user.dir")+"/srctset/resources/JSONFiles/token.txt", jsonObjectToken);
		
		
	}

	private String SystemProperty(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
