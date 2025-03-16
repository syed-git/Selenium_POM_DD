package com.common_utitlities;

import java.util.Base64;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import java.nio.file.Files;

public class PageActions extends BasePage {
	
	public static void waitForPageLoad () throws InterruptedException {
		
		String status = "";
		JavascriptExecutor js = (JavascriptExecutor) BasePage.driver;
		
		status = (String) js.executeScript("return document.readyState");
		
		int maxTime = 90;
		int index = 0;
		
		while (!status.equals("complete") && index < maxTime) {
			
			Thread.sleep(1000);
			status = (String) js.executeScript("return document.readyState");
			index++;
			System.out.println(index);
		}
		
		if (!status.equals("complete") && index == maxTime) {
			throw new NoSuchElementException();
		}
	}
	
	public static void captureFullPageScreenshot() throws IOException {
		File directory = new File(Constants.SCREENSHOTS_PATH);
		
		if (!directory.exists()) { 
			directory.mkdir();   
			
			
		}
		
        String randomStr = UUID.randomUUID().toString().replace("-", "").substring(0, 10);

		Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(1000)) // Scroll and capture
                .takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "PNG", new File(Constants.SCREENSHOTS_PATH + "/" + randomStr +".png"));
		
		AppGlobalVariable.currentScreenshotPath = "screenshots/" + randomStr + ".png";
	}
	
	public static void captureScreenshot() throws IOException {
		File directory = new File(Constants.SCREENSHOTS_PATH);
		
		if (!directory.exists()) { 
			directory.mkdir();   
			
			
		}
		
        String randomStr = UUID.randomUUID().toString().replace("-", "").substring(0, 10);
        
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        
        // Save the Screenshot
        File destinationFile = new File(Constants.SCREENSHOTS_PATH + "/" + randomStr +".png");
        Files.copy(screenshot.toPath(), destinationFile.toPath());

        System.out.println("Screenshot saved successfully!");

		AppGlobalVariable.currentScreenshotPath = "screenshots/" + randomStr + ".png";
	}

	public static String decryptPassword (String encodedPpassword) {
		
        // Decode Base64
        byte[] decodedBytes = Base64.getDecoder().decode(encodedPpassword);
        String decryptPassword = new String(decodedBytes);

        System.out.println(decryptPassword);
		return decryptPassword;
		
	}
}
