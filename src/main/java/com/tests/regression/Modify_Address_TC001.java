package com.tests.regression;

import java.io.IOException;

import org.testng.annotations.Test;

import com.common_utitlities.AppGlobalVariable;
import com.common_utitlities.BasePage;
import com.common_utitlities.PageActions;
import com.common_utitlities.PageValidations;
import com.web.pages.Account;
import com.web.pages.AddressBookEntries;
import com.web.pages.HomePage;
import com.web.pages.LoginPage;

public class Modify_Address_TC001 extends BasePage {

	
	@Test (priority = 4)
	public void testModify_Address_TC001() throws InterruptedException, IOException {
		
		// create necessary objects required
		HomePage hp = new HomePage();
		LoginPage lp = new LoginPage();
		Account acc = new Account();
		AddressBookEntries abe = new AddressBookEntries();

		// get the user name and password from GlobalConfig
		String testName = "Modify_Address_TC001";
		String testDescription = "Verify user is add /delete the address";
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
		
		acc.clickOnModifyAddressBookEntries();
		PageValidations.seeElementContains(abe.addressBookEntriesText, "Address Book Entries", true);
		
		abe.clickOnNewAddressButton();
		PageValidations.seeElementContains(abe.addAddressText, "Add Address", true);
		
		abe.enterFirstName("Testing");
		abe.enterLastName("User");
		abe.enterAddress1("Janachaitanya Phase 2");
		abe.enterCity("Hyderabad");
		abe.enterPostCode("500048");
		abe.selectCountry("India");
		abe.selectRegion("Telangana");
		
		abe.clickOnContinueButton();
		
		PageValidations.seeElementContains(abe.addressModifySuccessMessage, "Your address has been successfully added", true);
		
		abe.clickOnDeleteAddressButton();
		PageValidations.seeElementContains(abe.addressDeleteSuccessMessage, "Your address has been successfully deleted", true);
				
		
		// Test ends here
	}

}
