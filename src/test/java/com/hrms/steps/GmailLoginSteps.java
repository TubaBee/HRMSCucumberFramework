package com.hrms.steps;

import org.junit.Assert;

import com.hrms.pages.GmailLoginPageElement;
import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;
import com.hrms.utils.Constants;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GmailLoginSteps extends CommonMethods {
	 GmailLoginPageElement gmail;
	
	@Given("I open the gmail page")
	public void i_open_the_gmail_page() {
	 	BaseClass.setUp();
	 	driver.get(Constants.GMAIL);
	 	
	}

	@When("I enter username")
	public void i_enter_username() {
	    gmail=new GmailLoginPageElement();
	   sendText(gmail.gusername, "tuba.onslbee@gmail.com");
	}

	@When("I click next button")
	public void i_click_next_button() {
	   click(gmail.clickBtnUsername);
	}

	@Then("I enter password")
	public void i_enter_password() {
	  sendText(gmail.gpassword, "Bbtseva8822");
	}

	@Then("I click next button again")
	public void i_click_next_button_again() {
	  click(gmail.clickBtnUsername);
	}

	@Then("I checck my login acception")
	public void i_checck_my_login_acception() {
		click(gmail.mypictureBtn);
	    Boolean gmailAcception=gmail.MyUsernameText.isDisplayed();
	    Assert.assertEquals("Do not show your username", gmailAcception, true);
	}

	@Then("I close the page")
	public void i_close_the_page() {
	   tearDown();
	}


}
