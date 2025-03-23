package com.web.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.common_utitlities.AppGlobalVariable;
import com.common_utitlities.BasePage;
import com.common_utitlities.ExcelLibrary;
import com.common_utitlities.PageActions;

public class products extends BasePage {

	@FindBy(xpath = "//a[text()='Sony VAIO']//parent::h4//parent::div//following-sibling::div//descendant::span[text()='Add to Cart']")
	public WebElement productsAddToCart;
	
	@FindBy(xpath = "//div[contains(text(),' Success: You have added ')]")
	public WebElement successfullyAddedToCart;
	
	@FindBy(linkText = "shopping cart")
	public WebElement shoppingCartLink;
	
	@FindBy(xpath = "//h2[text()='What would you like to do next?']]")
	public WebElement whatToDoNext;;
	
	@FindBy(css = "input[name*=quantity]")
	private WebElement quantity;
	
	@FindBy(linkText = "Checkout")
	private WebElement checkoutButton;
	
	@FindBy(xpath = "//h4[text()='Step 1: Checkout Options']")
	public WebElement checkoutText;
	
	@FindBy(css = "input[name=firstname]")
	private WebElement firstName;
	
	@FindBy(css = "input[name=lastname]")
	private WebElement lastName;
	
	@FindBy(css = "input[name=address_1]")
	private WebElement address1;
	
	@FindBy(css = "input[name=city]")
	private WebElement city;
	
	@FindBy(css = "input[name=postcode]")
	private WebElement postalCode;
	
	@FindBy(css = "input[name=country_id]")
	private WebElement countryDropdown;
	
	@FindBy(css = "input[name=zone_id]")
	private WebElement region;
	
	@FindBy(css = "input[id=button-payment-address]")
	private WebElement continueButton;
	
	@FindBy(css = "input[id=button-shipping-address]")
	private WebElement continueButton1;
	
	@FindBy(css = "input[id=button-shipping-method]")
	private WebElement continueButtonShipping;
	
	@FindBy(css = "textarea[name=comment]")
	private WebElement comments;
	
	@FindBy(xpath = "//a[@class='agree']//following-sibling::input")
	private WebElement termsAndConditions;
	
	@FindBy(css = "input[id=button-payment-method]")
	private WebElement continueButtonPayment;
	
	@FindBy(css = "input[id=button-confirm]")
	private WebElement confirmOrder;
	
	@FindBy(xpath = "//h1[text()='Your order has been placed!']")
	public WebElement orderPlacedSuccessMessage;	
	
	public products() {
		PageFactory.initElements(BasePage.driver, this);
	}
	
	
	public void clickOnAddToCart() throws InterruptedException, IOException {
		try {
			productsAddToCart.click();
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
		}
	}
	
	public void enterQuantity(String quantities) throws InterruptedException, IOException {
		try {
			quantity.sendKeys(quantities);
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
		}
	}
	
	public void clcikOnShoppingCartLink() throws InterruptedException, IOException {
		try {
			checkoutButton.click();;
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
		}
	}
	
	public void clcikOnCheckout() throws InterruptedException, IOException {
		try {
			checkoutButton.click();;
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
		}
	}
	
	public void enetrFirstName(String firstName1) throws InterruptedException, IOException {
		try {
			firstName.sendKeys(firstName1);
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
		}
	}
	
	public void enetrLastName(String lastName1) throws InterruptedException, IOException {
		try {
			lastName.sendKeys(lastName1);
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
		}
	}
	
	public void enterAddress1(String address) throws InterruptedException, IOException {
		try {
			address1.sendKeys(address);
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
		}
	}
	
	public void enterCity(String cityName) throws InterruptedException, IOException {
		try {
			city.sendKeys(cityName);
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
		}
	}
	
	public void enetrPostalCode(String postal) throws InterruptedException, IOException {
		try {
			postalCode.sendKeys(postal);
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
		}
	}
	
	public void selectCountry(String countryName) throws InterruptedException, IOException {
		try {

			Select country = new Select(countryDropdown);
			country.selectByVisibleText(countryName);
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
		}
	}
	
	public void selectRegion(String regionName) throws InterruptedException, IOException {
		try {

			Select country = new Select(region);
			country.selectByVisibleText(regionName);
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
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
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
		}
	}
	
	public void clickOnContinue1() throws InterruptedException, IOException {
		try {
			continueButton1.click();
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
		}
	}
	
	public void enterCommens(String comment) throws InterruptedException, IOException {
		try {
			comments.sendKeys(comment);
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
		}
	}
	
	public void clickOnContinueShipping() throws InterruptedException, IOException {
		try {
			continueButtonShipping.click();
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
		}
	}
	
	public void checkTermsAndConditions() throws InterruptedException, IOException {
		try {
			termsAndConditions.click();
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
		}
	}
	
	public void clickOnContinuePayment() throws InterruptedException, IOException {
		try {
			continueButtonPayment.click();
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
		}
	}
	
	public void clickOnConfirmOrder() throws InterruptedException, IOException {
		try {
			confirmOrder.click();
			PageActions.waitForPageLoad();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
		}
	}
	
}
