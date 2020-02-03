package com.hrms.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.testbase.BaseClass;
import com.hrms.utils.CommonMethods;

public class PIMPageElement extends CommonMethods {
	
	@FindBy(id="menu_pim_viewPimModule")
	public WebElement PIMLbl;
	
	@FindBy(id="menu_pim_addEmployee")
	public WebElement addEmployeelbl;
	
	@FindBy(name="firstName")
	public WebElement fname;
	
	@FindBy(name="middleName")
	public WebElement mname;
	
	@FindBy(name="lastName")
	public WebElement lname;
	
	@FindBy(id="btnSave")
	public WebElement SaveBtn;
	
	@FindBy(xpath ="//div[@id='profile-pic']/h1")
	public WebElement findMe;
	
	public PIMPageElement() {
		PageFactory.initElements(BaseClass.driver,this);
	}
	

}
