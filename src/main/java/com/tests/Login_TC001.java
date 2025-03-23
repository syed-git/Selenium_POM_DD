package com.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.common_utitlities.AppGlobalVariable;
import com.common_utitlities.BasePage;
import com.common_utitlities.ExcelLibrary;
import com.common_utitlities.PageActions;
import com.common_utitlities.PageValidations;
import com.web.pages.HomePage;
import com.web.pages.LoginPage;

public class Login_TC001 extends BasePage {
	
	@Test (priority = 1)
	
	public void testValid_Login_TC001 () throws InterruptedException, IOException {
		
		// create necessary objects required
		HomePage hp = new HomePage();
		LoginPage lp = new LoginPage();

		String testName = "Valid_Login_TC001";
		String testDescription = "Verify user ia able to login successfully";
		String userName = AppGlobalVariable.getExcelData("UserName");
		String password = AppGlobalVariable.getExcelData("Password");
		
		test = extent.createTest(testName, testDescription);
		
		// Test starts here
		
		PageValidations.seeTitleContains("Your Store", true);
		
		hp.clickOnUserDropDown();
		hp.clickonLoginButton();
		PageValidations.seeElementContains(lp.retruningCustomer, "Returning Customer", true);
		lp.enterEmail(userName);
		lp.enterPassword(PageActions.decryptPassword(password));
		lp.clickOnLogin();
		PageValidations.seeTitleContains("My Account", true);
		hp.clickOnUserDropDown();
		hp.clickonLogoutButton();
		PageValidations.seeElementContains(hp.accLogoutText, "Account Logout", true);
		
	}
	
	
	@Test (priority = 2)
	public void testInValid_Login_TC002 () throws InterruptedException, IOException {
		
		// create necessary objects required
		HomePage hp = new HomePage();
		LoginPage lp = new LoginPage();

		// user name and passwords are hard coded as it's an invalid login test
		String testName = "InValid_Login_TC002";
		String testDescription = "Verify user i unable to login with invalid credentials";
		String userName = "abz";
		String password = "avzggz";
		test = extent.createTest(testName, testDescription);
		// Test starts here
		
		PageValidations.seeTitleContains("Your Store", true);
		hp.clickOnUserDropDown();
		hp.clickonLoginButton();
		PageValidations.seeElementContains(lp.retruningCustomer, "Returning Customer", true);
		lp.enterEmail(userName);
		lp.enterPassword(password);
		lp.clickOnLogin();
		PageValidations.seeElementContains(lp.invalidLoginErrorMessage, "Warning: No match for E-Mail Address and/or Password.", false);
		
		// Test ends here
			
	}
}
