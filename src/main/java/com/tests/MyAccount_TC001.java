package com.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.common_utitlities.AppGlobalVariable;
import com.common_utitlities.BasePage;
import com.common_utitlities.ExcelLibrary;
import com.common_utitlities.PageActions;
import com.common_utitlities.PageValidations;
import com.web.pages.Account;
import com.web.pages.HomePage;
import com.web.pages.LoginPage;

public class MyAccount_TC001 extends BasePage {
	
	@Test
	public void testMyAccount_TC001() throws InterruptedException, IOException {
		
		// create necessary objects required
		HomePage hp = new HomePage();
		LoginPage lp = new LoginPage();
		Account acc = new Account();

		// get the user name and password from GlobalConfig
		String userName = AppGlobalVariable.getExcelData("UserName");
		String password = AppGlobalVariable.getExcelData("Password");
		
		// Test starts here
		
		PageValidations.seeTitleContains("Your Store", true);
		hp.clickOnUserDropDown();
		hp.clickonLoginButton();
		PageValidations.seeElementContains(lp.retruningCustomer, "Returning Customer", true);
		lp.enterEmail(userName);
		lp.enterPassword(PageActions.decryptPassword(password));
		lp.clickOnLogin();
		PageValidations.seeTitleContains("My Account", true);
		acc.clickOnEditYourInformation();
		PageValidations.seeElementContains(acc.myAccountInfoText, "My Account Information", true);
		acc.enterFirstName("Test1");
		acc.enterLastName("Zubair");
		acc.clickOnContinue();
		PageValidations.seeElementContains(acc.accountUpdatedSuccessMessage, "Success: Your account has been successfully updated.", true);
		hp.clickOnUserDropDown();
		hp.clickonLogoutButton();
		PageValidations.seeElementContains(hp.accLogoutText, "Account Logout", true);
		
		// Test ends here
	}

}
