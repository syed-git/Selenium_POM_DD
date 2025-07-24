package com.web.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.MediaEntityBuilder;
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
	
	@FindBy(linkText = "Desktops")
	private WebElement desktopDropDown;
	
	@FindBy(linkText = "Mac (1)")
	private WebElement mac1;
	
	@FindBy(xpath = "//span[text()='Add to Cart']")
	private WebElement addToCart;
	
	@FindBy(xpath = "//div[contains(text(),'Success: You have added')]")
	public WebElement addedToCartSuccessMessage;
	
	@FindBy(linkText = "shopping cart")
	private WebElement shoppingCartLink;
	
	@FindBy(xpath = "//button[@data-original-title='Remove']")
	private WebElement removeProductButton;
	
	@FindBy(xpath = "(//p[text()='Your shopping cart is empty!'])[2]")
	public WebElement soppingCartEmptyText;
	
	@FindBy(linkText = "Checkout")
	public WebElement checkoutButton;
	
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
			
			test.log(Status.PASS, 
	        		  "clicked successfully on user dropdown",
	        		  MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build()
	        		);
						
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			
			test.log(Status.FAIL, "unable to click on user dropdown",
	        		  MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
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
			
			test.log(Status.PASS, "clicked successfully on login button", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
					
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			
			test.log(Status.FAIL, "unable to click login button", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
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
			
			test.log(Status.PASS, "clicked successfully on logout button", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
		
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			
			test.log(Status.FAIL, "unable to click logout button", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
		}
	}
	
	public void hoverOnDesktopDropDown() throws InterruptedException, IOException {
		try {
			Actions actions = new Actions(BasePage.driver);
					
			actions.moveToElement(desktopDropDown).perform();
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
			
			test.log(Status.PASS, "hovered successfully on desktop", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
		
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			
			test.log(Status.FAIL, "unable to hover on desktop", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
		}
	}
	
	public void clickOnMac1() throws InterruptedException, IOException {
		try {
			mac1.click();
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
			
			test.log(Status.PASS, "clicked successfully on mac1 button", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
		
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			
			test.log(Status.FAIL, "unable to click mac1 button", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
		}
	}
	
	public void clickOnAddToCart() throws InterruptedException, IOException {
		try {
			addToCart.click();
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
			
			test.log(Status.PASS, "clicked successfully on add to cart button", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
		
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			
			test.log(Status.FAIL, "unable to click add to cart button", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
		}
	}
	
	public void clickOnShoopingCartLink() throws InterruptedException, IOException {
		try {
			shoppingCartLink.click();
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
			
			test.log(Status.PASS, "clicked successfully on shopping cart link", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
		
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			
			test.log(Status.FAIL, "unable to click shopping cart link", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
		}
	}
	
	public void clickOnRemoveProduct() throws InterruptedException, IOException {
		try {
			removeProductButton.click();
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
			
			test.log(Status.PASS, "clicked successfully on remove product", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
		
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			
			test.log(Status.FAIL, "unable to click remove product", MediaEntityBuilder.createScreenCaptureFromBase64String(AppGlobalVariable.currentScreenshot, "").build());
			
		}
	}
}
