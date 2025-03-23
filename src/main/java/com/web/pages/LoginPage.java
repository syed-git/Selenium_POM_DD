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

public class LoginPage extends BasePage {

	@FindBy(id = "input-email")
	private WebElement email;
	
	@FindBy(id = "input-password")
	private WebElement password;
	
	@FindBy(xpath = "//input[@class='btn btn-primary']")
	private WebElement login;
	
	@FindBy (xpath = "//h2[text()='Returning Customer']")
	public WebElement retruningCustomer;
	
	@FindBy (xpath = "//div[contains(text(),'No match for E-Mail')]")
	public WebElement invalidLoginErrorMessage;
	
	public LoginPage() {
		PageFactory.initElements(BasePage.driver, this);
	}
	
	public void enterEmail(String emailId) throws InterruptedException, IOException {
		try {
			email.sendKeys(emailId);
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
			test.log(Status.PASS, "enter the email address successfully: " + test.addScreenCaptureFromPath(captureScreenshot("enterEmail")));

		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			test.log(Status.FAIL, "could not enter the email address: " + test.addScreenCaptureFromPath(captureScreenshot("enterEmail")));

		}
	}
	
	public void enterPassword(String password1) throws InterruptedException, IOException {
		try {
			password.sendKeys(password1);
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
			test.log(Status.PASS, "password entered successfully: " + test.addScreenCaptureFromPath(captureScreenshot("enterPassword")));

		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			test.log(Status.FAIL, "could not enter the password: " + test.addScreenCaptureFromPath(captureScreenshot("enterPassword")));

		}
	}
	
	public void clickOnLogin() throws InterruptedException, IOException {
		try {
			login.click();
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
						
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
			test.log(Status.PASS, "clicked on login successfully: " + test.addScreenCaptureFromPath(captureScreenshot("clickLogin")));

		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			test.log(Status.FAIL, "unable to click login button: " + test.addScreenCaptureFromPath(captureScreenshot("clickLogin")));

		}
	}

}
