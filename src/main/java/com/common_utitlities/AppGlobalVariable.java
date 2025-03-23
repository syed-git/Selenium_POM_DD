package com.common_utitlities;

import java.util.HashMap;

public class AppGlobalVariable {
	
	public static HashMap <String, String> excelData;
	
	public static String currentStep;
	
	public static String currentTest;
	
	public static String currentScreenshotPath;
	
	public static String currentMethodName;
	
	
	public static String getExcelData (String keyName) {
		
		String value = excelData.get(keyName);
		
		if (value != null || value != "" || value!=" " ) {
			return value;
		}
		
		throw new NullPointerException();

	}
	
	public static HashMap <String, String> getExcelMap() {
		return excelData;
	}
	
	public static String getCurrentStep() {
		return currentStep;
	}
	
	public static String getCurrentTest() {
		return currentTest;
	}
}
