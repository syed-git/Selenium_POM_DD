package com.common_utitlities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PageValidations extends BasePage {
	
	public static void seeTitleContains(String expectedTitle, boolean exactMatch) throws IOException {
		
		try {
			String actualTitle = BasePage.driver.getTitle();
			PageActions.captureScreenshot();
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			if (exactMatch) {
				Assert.assertEquals(actualTitle, expectedTitle);
			} else {
				Assert.assertTrue(actualTitle.contains(expectedTitle),"Actual Title: " + actualTitle + " but Expected Title: " + expectedTitle);
			}
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.currentStep, "Status", "Pass");
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
		}
	}
	
	public static void checkElementState(WebElement element, String condition, Duration time) {
		
		switch(condition) {
		
		case "clickable" : {
			
			
		}
		}
	}
	
	public static void seeElementContains(WebElement element, String expectedText, boolean exactMatch) throws IOException {
			
		try {
			String actualText = element.getText();
			PageActions.captureScreenshot();
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
						
			if (exactMatch) {
				Assert.assertEquals(actualText, expectedText);
			} else {
				Assert.assertTrue(actualText.contains(expectedText),"Actual Title: " + actualText + " but Expected Title: " + expectedText);
			}
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
		}
	}
}
