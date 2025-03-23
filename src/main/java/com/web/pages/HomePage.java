package com.web.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.common_utitlities.AppGlobalVariable;
import com.common_utitlities.BasePage;
import com.common_utitlities.ExcelLibrary;
import com.common_utitlities.PageActions;

public class HomePage extends BasePage {

	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement userDropDown;
	
	@FindBy(linkText = "Login")
	private WebElement loginButton;
	
	@FindBy(linkText = "Logout")
	private WebElement logoutButton;
	
	@FindBy(xpath = "//h1[text()='Account Logout']")
	public WebElement accLogoutText;
	
	public HomePage() {
		PageFactory.initElements(BasePage.driver, this);
	}
	
	
	public void clickOnUserDropDown() throws InterruptedException, IOException {
		try {
			userDropDown.click();
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
			test.log(Status.PASS, "clicked successfully on user dropdown: " + test.addScreenCaptureFromPath(captureScreenshot("clickUserDropDown")));
			
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			test.log(Status.FAIL, "unable to click on user dropdown: " + test.addScreenCaptureFromPath(captureScreenshot("clickUserDropDown")));
		}
	}
	
	public void clickonLoginButton() throws InterruptedException, IOException {
		try {
			loginButton.click();
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");

			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
				
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
			test.log(Status.PASS, "clicked successfully on login button: " + test.addScreenCaptureFromPath(captureScreenshot("clickLoginButton")));
		
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			test.log(Status.FAIL, "unable to click login button: " + test.addScreenCaptureFromPath(captureScreenshot("clickLoginButton")));
		}
	}
	
	public void clickonLogoutButton() throws InterruptedException, IOException {
		try {
			logoutButton.click();
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
			test.log(Status.PASS, "clicked successfully on logout button: " + test.addScreenCaptureFromPath(captureScreenshot("clickLogoutButton")));
		
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			test.log(Status.FAIL, "unable to click logout button: " + test.addScreenCaptureFromPath(captureScreenshot("clickLogoutButton")));

		}
	}
}
