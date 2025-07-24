package com.web.pages;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.common_utitlities.AppGlobalVariable;
import com.common_utitlities.BasePage;
import com.common_utitlities.ExcelLibrary;
import com.common_utitlities.PageActions;

public class AddressBookEntries extends BasePage {

	
	@FindBy(xpath="//h2[text()='Address Book Entries']")
	public WebElement addressBookEntriesText;
	
	@FindBy(linkText = "New Address")
	private WebElement newAdrressButton;
	
	@FindBy(xpath="//h2[text()='Add Address']")
	public WebElement addAddressText;
	
	@FindBy(css = "input[id=input-firstname]")
	private WebElement firstName;
	
	@FindBy(css = "input[id=input-lastname")
	private WebElement lastName;
	
	@FindBy(css = "input[id=input-address-1]")
	private WebElement address1;
	
	@FindBy(css = "input[id=input-city]")
	private WebElement city;
	
	@FindBy(css = "input[id=input-postcode]")
	private WebElement postCode;
	
	@FindBy(css = "select[id=input-country]")
	private WebElement countryDropdown;
	
	@FindBy(css = "select[id=input-zone]")
	private WebElement regionDropDown;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//div[text()=' Your address has been successfully added']")
	public WebElement addressModifySuccessMessage;
	
	@FindBy(xpath = "(//td/a[text()='Delete'])[2]")
	public WebElement deleteAddressButton;
	
	@FindBy(xpath = "//div[text()=' Your address has been successfully deleted']")
	public WebElement addressDeleteSuccessMessage;
	
	
	
	public AddressBookEntries() {
		PageFactory.initElements(BasePage.driver, this);
	}
	
	public void clickOnNewAddressButton() throws InterruptedException, IOException {
		try {
			newAdrressButton.click();
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
			
			test.log(Status.PASS, "Clicked successfully on New Address button", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "Screenshot").build());
			
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			
			test.log(Status.FAIL, "unable to click on New Address button", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "Screenshot").build());
			
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

			test.log(Status.PASS, "entered first name successfully", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
			
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			
			test.log(Status.FAIL, "unable to enter first name", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
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

			test.log(Status.PASS, "entered last name successfully", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
			
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			
			test.log(Status.FAIL, "unable to enter last name", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
		}
	}
	
	public void enterAddress1(String address_1) throws InterruptedException, IOException {
		try {
			address1.clear();
			address1.sendKeys(address_1);
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");

			test.log(Status.PASS, "entered address1 successfully", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
			
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			
			test.log(Status.FAIL, "unable to address1", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
		}
	}
	
	public void enterCity(String cityName) throws InterruptedException, IOException {
		try {
			city.clear();
			city.sendKeys(cityName);
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");

			test.log(Status.PASS, "entered city successfully", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
			
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			
			test.log(Status.FAIL, "unable to city", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
		}
	}
	
	public void enterPostCode(String post_code) throws InterruptedException, IOException {
		try {
			postCode.clear();
			postCode.sendKeys(post_code);
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");

			test.log(Status.PASS, "entered post code successfully", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
			
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			
			test.log(Status.FAIL, "unable to enter post code", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
		}
	}
	
	public void selectCountry(String countryValue) throws InterruptedException, IOException {
		try {
			
			Select country = new Select(countryDropdown);
			country.selectByVisibleText(countryValue);
			
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");

			test.log(Status.PASS, "country selected successfully", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
			
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			
			test.log(Status.FAIL, "unable to select the country", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
		}
	}
	
	public void selectRegion(String regionName) throws InterruptedException, IOException {
		try {
			
			Select region = new Select(regionDropDown);
			region.selectByVisibleText(regionName);
			
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");

			test.log(Status.PASS, "region selected successfully", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
			
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			
			test.log(Status.FAIL, "unable to select the region", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
		}
	}
	
	public void clickOnContinueButton() throws InterruptedException, IOException {
		try {
			
			continueButton.click();
			
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");

			test.log(Status.PASS, "clicked on continue button successfully", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
			
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			
			test.log(Status.FAIL, "unable to click on continue button", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
		}
	}
	
	public void clickOnDeleteAddressButton() throws InterruptedException, IOException {
		try {
			
			deleteAddressButton.click();
			
			PageActions.waitForPageLoad();
			Thread.sleep(3000);
			Alert alert = BasePage.driver.switchTo().alert();
			alert.accept();
			
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");

			test.log(Status.PASS, "clicked on delete button successfully", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
			
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			
			test.log(Status.FAIL, "unable to click on delete button", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
		}
	}
	
	
}
