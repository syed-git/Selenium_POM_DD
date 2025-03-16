//package com.tests;
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.time.Duration;
//
//import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import com.common_utitlities.AppGlobalVariable;
//import com.common_utitlities.BasePage;
//import com.common_utitlities.ExcelLibrary;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class Demo {
//
//	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//
//
//		ExcelLibrary.readData("Valid_Login_TC001", "Status");
//		AppGlobalVariable.getExcelData("Valid_Login_TC001");
//		ExcelLibrary.writeData("Valid_Login_TC001", "Valid_Login_TC001", "Status", "Pass");
//	}
//
//}
