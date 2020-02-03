package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;

public class GmailLoginPageElement {
	
	@FindBy(id="identifierId")
	public WebElement gusername;
	
	@FindBy(xpath = "//span[@class='RveJvd snByac']")
	public WebElement clickBtnUsername;
	
	@FindBy(name = "password")
	public WebElement gpassword;
	
	@FindBy(className = "gb_Ia gbii")
	public WebElement mypictureBtn;
	
	@FindBy(className = "gb_qb")
	public WebElement MyUsernameText;
	
	public GmailLoginPageElement() {
		
		PageFactory.initElements(BaseClass.driver, this);

	}
	

}
