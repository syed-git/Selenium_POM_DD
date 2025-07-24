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
import com.web.pages.products;

public class Add_To_Cart_TC001 extends BasePage {
	
	@Test
	public void testAdd_To_Cart_TC001() throws InterruptedException, IOException {
		
		// create necessary objects required
		HomePage hp = new HomePage();
		LoginPage lp = new LoginPage();
		Account acc = new Account();
		products product = new products();
		
		String testName = "Add_To_Cart_TC001";
		String testDescription = "Verify user is able to add/remove from cart successfully";
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
		
		
		hp.hoverOnDesktopDropDown();
		hp.clickOnMac1();
		hp.clickOnAddToCart();
		PageValidations.seeElementContains(hp.addedToCartSuccessMessage, "Success: You have added", false);
		hp.clickOnShoopingCartLink();
		
		PageValidations.seeElementEnabled(hp.checkoutButton, true);
		hp.clickOnRemoveProduct();
		PageValidations.seeElementContains(hp.soppingCartEmptyText, "Your shopping cart is empty!", true);
		
		hp.clickOnUserDropDown();
		hp.clickonLogoutButton();
		PageValidations.seeElementContains(hp.accLogoutText, "Account Logout", true);
		
		
		 // Test ends here
	}

}
