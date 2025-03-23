package com.common_utitlities;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import java.nio.file.Files;

public class BasePage {
	
	public static WebDriver driver;
	protected static ExtentReports extent;
    protected static ExtentTest test;
    
	@BeforeMethod
	public static WebDriver preSteps(ITestResult result) throws IOException {
		
		// set the global variable step number to start from beginning
		AppGlobalVariable.currentStep = "STEP 1";
		AppGlobalVariable.currentTest = result.getMethod().getMethodName().replace("test", "");
		
		try {
			
			// get the global configuration from Excel
			ExcelLibrary.readData("GlobalConfig", "Values");
			
			switch (AppGlobalVariable.getExcelData("BrowserType")) {
				
			case "Chrome": {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			}
			case "Internet Explorer": {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				break;
			}
			case "Firefox": {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			}
			}
			driver.get(AppGlobalVariable.getExcelData("AppUrl"));
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			captureScreenshot("");
			// this is to get the current POM method in execution to show in the report
			AppGlobalVariable.currentMethodName = StackWalker.getInstance()
	                .walk(frames -> frames.findFirst().map(StackWalker.StackFrame::getMethodName).orElse("Unknown"));
			
			// Update the step status
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Pass");
			
		} catch (Throwable e) {
			ExcelLibrary.writeData(AppGlobalVariable.currentTest, AppGlobalVariable.getCurrentStep(), "Status", "Fail");
		}
				
		return driver;
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		driver.quit();
		
		// generate Excel report
		createExcelReport();
		
		// create HTML report
		createHTMLReport(result);
	}
	
	@AfterSuite
	public static void postSteps() throws IOException {
		File directory = new File(Constants.TEMP_DIRECTORY + "/testData.xlsx");
		// File path = new File(Constants.TEST_RESULTS);
		File tempPath = new File(Constants.TEMP_DIRECTORY);
		
		File originalFile = new File(Constants.TEMP_PATH);
		File optFilePath = new File(Constants.TEST_RESULTS + "/excel-reports");
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

		//copy the original testData sheet to temp folder to make sure original file is not getting corrupted
		File tempFile = new File(optFilePath, originalFile.getName() + timeStamp + ".xlsx");
		FileUtils.copyFile(originalFile, tempFile);
		
		if (directory.exists()) {
			directory.delete();
			tempPath.delete();
			
		}
		extent.flush();
	}
	
	@BeforeSuite
    public void setupReport() {
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        ExtentSparkReporter spark = new ExtentSparkReporter("test-results/html-reports/test-report_" + timeStamp + ".html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }
	
	public static String captureScreenshot(String screenshotName) throws IOException {
		String randomStr = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
		
        Path screenshotsDir = Paths.get(Constants.SCREENSHOTS_PATH);
        if (!Files.exists(screenshotsDir)) {
            Files.createDirectories(screenshotsDir);
        }
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destPath = new File(Constants.SCREENSHOTS_PATH + "/" + screenshotName + "_" + randomStr +".png");
        
        Files.copy(srcFile.toPath(), destPath.toPath());
        AppGlobalVariable.currentScreenshotPath = Constants.SCREENSHOTS_PATH + "/" + screenshotName + "_" + randomStr + ".png";
        return destPath.toString();
    }
	
	
	// This method will create a excel summary report
	public void createExcelReport() throws IOException {
		
		ExcelLibrary.readData(AppGlobalVariable.currentTest, "Status");
		
		int totalSteps = AppGlobalVariable.getExcelMap().size() - 1;
		int passCount = 0;
		int failureCount = 0;
		int skipCount = 0;
		String overallStatus = "Pass";
		
		for (Entry<String, String> entry : AppGlobalVariable.getExcelMap().entrySet()) {
            
            if (entry.getValue().equals("Pass")) {
            	passCount++;
            	
            } else if (entry.getValue().equals("Fail")) {
            	failureCount++;
            } else if (entry.getValue().equals("")) {
            	skipCount++;
            }
        }
		
		if (failureCount > 0) {
			overallStatus = "Fail";
		}
		
		// calculate the percentage
		double passPercentage = ((double) passCount / totalSteps) * 100;
		double failurePercentage = ((double) failureCount / totalSteps) * 100;
		double skipPercentage = ((double) skipCount / totalSteps) * 100;
		
		// round up to 2 decimals
		BigDecimal passPer = new BigDecimal(passPercentage).setScale(2, RoundingMode.UP);
		BigDecimal failPer = new BigDecimal(failurePercentage).setScale(2, RoundingMode.UP);
		BigDecimal skipPer = new BigDecimal(skipPercentage).setScale(2, RoundingMode.UP); 
		
		// update the test summary
		ExcelLibrary.writeData("TEST SUMMARY", AppGlobalVariable.currentTest, "Status", overallStatus);
		ExcelLibrary.writeData("TEST SUMMARY", AppGlobalVariable.currentTest, "Pass Percentage", passPer + "%");
		ExcelLibrary.writeData("TEST SUMMARY", AppGlobalVariable.currentTest, "Fail Percentage", failPer + "%");
		ExcelLibrary.writeData("TEST SUMMARY", AppGlobalVariable.currentTest, "Skip Percentage", skipPer + "%");
		
	}
	
	public void createHTMLReport(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
            // Capture screenshot on failure
            String screenshotPath = captureScreenshot(result.getName());
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED", ExtentColor.RED));
            test.fail("Screenshot: " + test.addScreenCaptureFromPath(screenshotPath));
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED", ExtentColor.GREEN));
        }
	}
}
