package com.web.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.common_utitlities.AppGlobalVariable;
import com.common_utitlities.BasePage;
import com.common_utitlities.ExcelLibrary;
import com.common_utitlities.PageActions;

public class Account extends BasePage {

	@FindBy(linkText = "Edit your account information")
	private WebElement editYourInformation;
	
	@FindBy(xpath = "//h1[text()='My Account Information']")
	public WebElement myAccountInfoText;
	
	@FindBy(id = "input-firstname")
	private WebElement firstName;
	
	@FindBy(id = "input-lastname")
	public WebElement lastName;
	
	@FindBy(xpath = "//div[@class='pull-right']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//div[contains(text(),'been successfully updated')]")
	public WebElement accountUpdatedSuccessMessage;
	
	@FindBy(linkText = "Laptops & Notebooks")
	private WebElement laptopsDropdown;
	
	@FindBy(linkText = "Show All Laptops & Notebooks")
	private WebElement showAllLaptops;
	
	public Account() {
		PageFactory.initElements(BasePage.driver, this);
	}
	
	
	public void clickOnEditYourInformation() throws InterruptedException, IOException {
		try {
			editYourInformation.click();
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
			test.log(Status.PASS, "Clicked successfully on edit your information: " + test.addScreenCaptureFromPath(captureScreenshot("clickEditInfo")));

		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			test.log(Status.FAIL, "unable to click on edit your information: " + test.addScreenCaptureFromPath(captureScreenshot("clickEditInfo")));

		}
	}
	
	public void enterFirstName(String fName) throws InterruptedException, IOException {
		try {
			firstName.clear();
			firstName.sendKeys(fName);
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
			test.log(Status.PASS, "entered first name successfully: " + test.addScreenCaptureFromPath(captureScreenshot("enterFirstName")));

		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			test.log(Status.FAIL, "unable to enter first name: " + test.addScreenCaptureFromPath(captureScreenshot("enterFirstName")));

		}
	}
	
	public void enterLastName(String lName) throws InterruptedException, IOException {
		try {
			lastName.clear();
			lastName.sendKeys(lName);
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
			test.log(Status.PASS, "entered last name successfully: " + test.addScreenCaptureFromPath(captureScreenshot("enterLastName")));

		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			test.log(Status.FAIL, "unable to enter last namen: " + test.addScreenCaptureFromPath(captureScreenshot("enterLastNam")));

		}
	}
	
	public void clickOnContinue() throws InterruptedException, IOException {
		try {
			continueButton.click();
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
			test.log(Status.PASS, "clicked successfully on continue button: " + test.addScreenCaptureFromPath(captureScreenshot("clickContinue")));

		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			test.log(Status.FAIL, "unable to click on continue button: " + test.addScreenCaptureFromPath(captureScreenshot("clickContinue")));

		}
	}
	
	public void hoverOnLaptopsDropdown() throws InterruptedException, IOException {
		try {
			Actions action = new Actions(BasePage.driver);
			action.moveToElement(laptopsDropdown).build().perform();
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
			test.log(Status.PASS, "hovered successfully on Laptops dropdown: " + test.addScreenCaptureFromPath(captureScreenshot("hoverLaptop")));

		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			test.log(Status.FAIL, "unable to hover on laptop dropdown: " + test.addScreenCaptureFromPath(captureScreenshot("hoverLaptop")));

		}
	}
	
	public void clickOnShowOption() throws InterruptedException, IOException {
		try {
			showAllLaptops.click();
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
			test.log(Status.PASS, "clicked successfully on show options: " + test.addScreenCaptureFromPath(captureScreenshot("clickShowOptions")));

		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			test.log(Status.FAIL, "unable to click on Show options: " + test.addScreenCaptureFromPath(captureScreenshot("clickShoeOptions")));

		}
	}
	
}
