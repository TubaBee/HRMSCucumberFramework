package com.hrms.pages;

import org.junit.Assert;
import com.hrms.pages.LoginPageElements;
import com.hrms.utils.CommonMethods;

public class Task extends CommonMethods {
	/*
	 * Sprint 5 US 16767: As an admin I should be able to add an employee
	 * 
	 * TC: Add Employee Step 1. navigate to the application Step 2: login into the
	 * application Step 3: navigate to add employee page Step 4: add employee by
	 * providing fname. mname, lname Step 5: verify employee has been added
	 * successfully
	 */

	public void OpenPage() throws InterruptedException {

		LoginPageElements login = new LoginPageElements();
		sendText(login.username, "Admin");
		sendText(login.password, "Syntax@123");
		click(login.loginBtn);

		PIMPageElement pim = new PIMPageElement();
		click(pim.PIMLbl);
		click(pim.addEmployeelbl);
		Thread.sleep(2000);
		sendText(pim.fname, "Tuba");
		sendText(pim.mname, "Ayse");
		sendText(pim.lname, "Onsal");
		Thread.sleep(1000);
		click(pim.SaveBtn);
		Thread.sleep(1000);
		String expected = "Tuba Ayse Onsal";
		// boolean expected=true;
		Assert.assertEquals(pim.findMe.getText(), expected, "Did not find save element");

	}

}
