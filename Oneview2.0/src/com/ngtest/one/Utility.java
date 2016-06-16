package com.ngtest.one;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utility {

	public static final String destination = "D:/Rajendra_backup/JAGAN 13-02/Selenium/Selenium Mars/TakeScreenshot";

	public static void copyFileUsingStream(File source, File dest) throws IOException {

		System.out.println("cccccccccccccccccc0000000000000000000");
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(dest);
			byte[] buffer = new byte[1024];
			int length;
			while ((length = is.read(buffer)) > 0) {
				os.write(buffer, 0, length);
			}
		} finally {
			is.close();
			os.close();
		}
	}

	public static void captureScreenshot(WebDriver driver, String ScreeshotName) {

		try {

			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(source,
					new File("D://Rajendra_backup//JAGAN 13-02//Selenium//Selenium Mars//TakeScreenshot" + ScreeshotName
							+ ".png"));

			System.out.println("Screenshot Taken");

		} catch (Exception e) {

			System.out.println("Exception while taking screnshot" + e.getMessage());
		}

	}

	public static void captureScreenshot1(WebDriver driver, String ScreeshotName, File dsr) {

		try {

			TakesScreenshot ts = (TakesScreenshot) driver;

			File source = ts.getScreenshotAs(OutputType.FILE);
			System.out.println("fileecop9999999999y" + dsr);
			FileUtils.copyFile(dsr, new File("D://Rajendra_backup//JAGAN 13-02//Selenium//Selenium Mars//TakeScreenshot"
					+ ScreeshotName + ".png"));

			System.out.println("Screenshot Taken");

		} catch (Exception e) {

			System.out.println("Exception while taking screnshot" + e.getMessage());
		}

	}
	
	
	@SuppressWarnings("resource")
	public static void writeCountryListToFile(String fileName, List<TestResult> testList) throws Exception {
		Workbook workbook = null;

		if (fileName.endsWith("xlsx")) {
			workbook = new XSSFWorkbook();
		} else if (fileName.endsWith("xls")) {
			workbook = new HSSFWorkbook();
		} else {
			throw new Exception("invalid file name, should be xls or xlsx");
		}

		Sheet sheet = workbook.createSheet("TestResultSheet");

		Iterator<TestResult> iterator = testList.iterator();
		Row row1 = sheet.createRow(0);
		Cell cell11 = row1.createCell(0);
		cell11.setCellValue("ID ");
		Cell cell12 = row1.createCell(1);
		cell12.setCellValue("CLASS");
		Cell cell23 = row1.createCell(2);
		cell23.setCellValue("NAME OF TEST");
		Cell cell33 = row1.createCell(3);
		cell33.setCellValue("DESCRIPTION OF TEST");
		Cell cell43 = row1.createCell(4);
		cell43.setCellValue("METHOD OF TEST");	
		Cell cell53= row1.createCell(5);
		cell53.setCellValue("RESULT OF TEST");
		int rowIndex = 1;
		while (iterator.hasNext()) {
			TestResult tresult = iterator.next();
			Row row = sheet.createRow(rowIndex++);
			Cell cell0 = row.createCell(0);
			cell0.setCellValue(tresult.getTestId());
			Cell cell1 = row.createCell(1);
			cell1.setCellValue(tresult.getTestClass());
			Cell cell2 = row.createCell(2);
			cell2.setCellValue(tresult.getTestName());
			Cell cell3 = row.createCell(3);
			cell3.setCellValue(tresult.getTestDescription());
			Cell cell4 = row.createCell(4);
			cell4.setCellValue(tresult.getTestMethod());	
			Cell cell5= row.createCell(5);
			cell5.setCellValue(tresult.getTestResult());
		}

		// lets write the excel data to file now
		FileOutputStream fos = new FileOutputStream(fileName);
		workbook.write(fos);
		fos.close();
		System.out.println(fileName + " written successfully");
	}

	
	
}
