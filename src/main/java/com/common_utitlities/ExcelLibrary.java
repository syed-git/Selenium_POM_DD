package com.common_utitlities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFFont;

public class ExcelLibrary {

	public static void readData(String sheetName, String column) throws IOException {
		
		File originalFile = new File(Constants.ORIGINAL_PATH);
		File directory = new File(Constants.TEMP_DIRECTORY);
		File tempFile = null;
		tempFile = new File(directory, originalFile.getName());
				
		// create the directory if does not exist
		if (!directory.exists()) { 
            boolean created = directory.mkdir();
            
            // copy the original testData sheet to temp folder to make sure original file is not getting corrupted          
    		FileUtils.copyFile(originalFile, tempFile);
    		
            if (created) {
                System.out.println("Directory created successfully!");
            } else {
                System.out.println("Failed to create directory.");
            }
        } else {
            System.out.println("Directory already exists.");

        }

		FileInputStream fis = new FileInputStream(tempFile); 
		Workbook workbook = WorkbookFactory.create(fis); 
	    Sheet sheet = workbook.getSheet(sheetName); 
	    String value = "";
	    
	    HashMap<String, String> map = new HashMap<String, String> (); 
	    int desiredColumnNumber = 0;
        
	    
        for (int r = 0; r <= sheet.getLastRowNum(); r++) {
        	
            String key = sheet.getRow(r).getCell(0).getStringCellValue();
            
            int lastCellNum = sheet.getRow(0).getLastCellNum();
            
            for (int cell = 0; cell < lastCellNum; cell++) {
            	if (column.equals(sheet.getRow(0).getCell(cell).getStringCellValue())) {
            		desiredColumnNumber = cell;
            	}
            }
            try {
            	value = sheet.getRow(r).getCell(desiredColumnNumber).getStringCellValue();
            } catch (NullPointerException e) {
            	value = "";
            }
            map.put(key, value);
        } 

		AppGlobalVariable.excelData = map;
	}
	
	public static void writeData(String sheetName, String key, String column, String value) throws IOException {
		
		File file = new File(Constants.TEMP_PATH);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		
		int desiredRowNum = 0;
		int desiredCellNum = 0;
		
		for (int r = 0; r <= sheet.getLastRowNum(); r++) {

			String rowValue = sheet.getRow(r).getCell(0).getStringCellValue();
			
			if (rowValue.equals(key)) {
				desiredRowNum = r;
			}
		}

		int lastCellNum = sheet.getRow(0).getLastCellNum();

		for (int cell = 0; cell < lastCellNum; cell++) {
			if (column.equals(sheet.getRow(0).getCell(cell).getStringCellValue())) {
				desiredCellNum = cell;
			}
		}
		
		Cell cell = sheet.getRow(desiredRowNum).createCell(desiredCellNum);
		cell.setCellValue(value);
		XSSFFont font = (XSSFFont) workbook.createFont();
        font.setBold(true);
        
		// coloring the cell based on status
		CellStyle style = workbook.createCellStyle();
		style.setFont(font);

		if (value.equals("Fail")) {
	        // Set the background color
	        style.setFillForegroundColor(IndexedColors.RED.getIndex());
	        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        
		} else if (value.equals("Pass")) {
			style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
	        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		}

        // Apply the style to the cell
        cell.setCellStyle(style);
        
		try (FileOutputStream fileOut = new FileOutputStream(file)) {
            workbook.write(fileOut);
            System.out.println("Data written to the existing sheet successfully!");
        }
		
		if (!sheetName.equals("TEST SUMMARY")) {
			attachScreenshotToExcel(sheetName, key, "Screenshots", AppGlobalVariable.currentMethodName);
		}
		
        workbook.close();
        
        if (!value.equals("Fail")) {
	        String step = AppGlobalVariable.currentStep.split(" ")[1];
	        int nextStepNum = Integer.parseInt(step) + 1;
	        AppGlobalVariable.currentStep = "STEP " + nextStepNum;
        }
	}
	
	public static void attachScreenshotToExcel(String sheetName, String key, String column, String methodName) throws IOException {
		
		File file = new File(Constants.TEMP_PATH);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		
		int desiredRowNum = 0;
		int desiredCellNum = 0;
		
		for (int r = 0; r <= sheet.getLastRowNum(); r++) {

			String rowValue = sheet.getRow(r).getCell(0).getStringCellValue();
			
			if (rowValue.equals(key)) {
				desiredRowNum = r;
			}
		}

		int lastCellNum = sheet.getRow(0).getLastCellNum();

		for (int cell = 0; cell < lastCellNum; cell++) {
			if (column.equals(sheet.getRow(0).getCell(cell).getStringCellValue())) {
				desiredCellNum = cell;
			}
		}
		
		Row row = sheet.getRow(desiredRowNum);
		Cell cell = row.createCell(desiredCellNum);
		
		try {
			
			cell.setCellValue(methodName + " --> Click to open the screenshot");
			
			CreationHelper creationHelper = workbook.getCreationHelper();
	        Hyperlink hyperlink = creationHelper.createHyperlink(HyperlinkType.FILE);
	       
	        // Set the file path (use absolute path)
	        String filePath = AppGlobalVariable.currentScreenshotPath;
	        hyperlink.setAddress(filePath); 
	
	        // Assign hyperlink to the cell
	        cell.setHyperlink(hyperlink);
	
	        // Apply hyperlink style (blue underline)
	        CellStyle hyperlinkStyle = workbook.createCellStyle();
	        Font hyperlinkFont = workbook.createFont();
	        hyperlinkFont.setUnderline(Font.U_SINGLE);
	        hyperlinkFont.setColor(IndexedColors.BLUE.getIndex());
	        hyperlinkStyle.setFont(hyperlinkFont);
	        cell.setCellStyle(hyperlinkStyle);
	
	        // Save the workbook
	        FileOutputStream fileOut = new FileOutputStream(file);
	        workbook.write(fileOut);
	        fileOut.close();
	        workbook.close();
	        
		} catch (Throwable e) {
			cell.setCellValue("Error Capturing the screenhot");
		}
	}
}
