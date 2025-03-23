package com.common_utitlities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

public class PageValidations extends BasePage {
	
	
	public static void seeTitleContains(String expectedTitle, boolean exactMatch) throws IOException {
		
		try {
			String actualTitle = BasePage.driver.getTitle();
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			if (exactMatch) {
				Assert.assertEquals(actualTitle, expectedTitle);
			} else {
				Assert.assertTrue(actualTitle.contains(expectedTitle),"Actual Title: " + actualTitle + " but Expected Title: " + expectedTitle);
			}
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.currentStep, "Status", "Pass");
	        test.log(Status.PASS, "Web Page title is as expected: " + test.addScreenCaptureFromPath(captureScreenshot("titleMatch")));
	        
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			test.log(Status.FAIL, "Web Page title is not as expected: " + test.addScreenCaptureFromPath(captureScreenshot("titleMatch")));
	        
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
			BasePage.captureScreenshot("");
			
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
						
			if (exactMatch) {
				Assert.assertEquals(actualText, expectedText);
			} else {
				Assert.assertTrue(actualText.contains(expectedText),"Actual Title: " + actualText + " but Expected Title: " + expectedText);
			}
			
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
			test.log(Status.PASS, "Element contains the expected condition " + test.addScreenCaptureFromPath(captureScreenshot("elementContains")));
	        
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Failure Reason", e.getMessage());
			test.log(Status.FAIL, "Element does not contains expected consition: " + test.addScreenCaptureFromPath(captureScreenshot("elementContains")));
	        
		}
	}
}
