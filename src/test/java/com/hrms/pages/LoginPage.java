package com.hrms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.hrms.testbase.BaseClass;

public class LoginPage extends BaseClass {

	public WebElement username=driver.findElement(By.id("txtUsername"));
	public WebElement password=driver.findElement(By.id("txtPassword"));
	public WebElement LoginBtn=driver.findElement(By.id("btnLogin"));
	//public WebElement errMsg=driver.findElement(By.id("SpanMessage")); //bu kodu kullaninca calismiyor
//	public WebElement logo=driver.findElement(By.xpath("//div[@id='divLogo']"));
//	
//	public WebElement errMsg=driver.findElement(By.xpath("//div[@id='divLoginButton']/span"));
}
