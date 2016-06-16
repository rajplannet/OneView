package com.app.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Business {
public static final String destination="D:/Rajendra_backup/JAGAN 13-02/Selenium/Selenium Mars/TakeScreenshot";

public static void copyFileUsingStream(File source, File dest) throws IOException {
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

	
	public void doOperation(WebDriver driver) throws InterruptedException{
		
		driver.findElement(By.id("DivOperation")).click();
	Thread.sleep(1000);
	
	
		//driver.navigate().back();
		//driver.findElement(By.id(""))
		
	}
	
	public static void shiftDetails(WebDriver driver) throws InterruptedException, IOException{
		driver.findElement(By.id("ASPxRibbon1_TC_T2")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='ASPxRibbon1_T2G0I0_LI']")).click();
		
		Thread.sleep(5000);
		
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println(scr.getName());
		File dest = new File(destination+"/"+scr.getName());
		copyFileUsingStream(scr, dest);
		//FileUtils.copyDirectory(scr, new File("D:/Rajendra_backup/JAGAN 13-02/Selenium/Selenium Mars/TakeScreenshot"));
		
	}
	public  void doLogin(WebDriver driver) throws InterruptedException {

		// open Url of the application
		driver.get("http://172.16.22.31:8195/LoginPage.aspx");

		// Maximize the window
		driver.manage().window().maximize();

		// Added the implicitly time after every test cases
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Enter the username
		driver.findElement(By.id("txtusername")).sendKeys("superadmin");

		// Enter the the password
		driver.findElement(By.id("txtPassword")).sendKeys("oneview");
		Thread.sleep(1000);

		// Mouse hover for sign In button and click on button
		WebElement ele1 = driver.findElement(By.id("ASPxButton1"));
		Actions action1 = new Actions(driver);
		action1.moveToElement(ele1).build().perform();
		Thread.sleep(1000);
		driver.findElement(By.id("ASPxButton1")).click();
		Thread.sleep(1000);
	

		// Mouse hover effect Logout
		WebElement ele = driver.findElement(By.id("Label1"));
		Actions action = new Actions(driver);
		action.moveToElement(ele).build().perform();
		Thread.sleep(1000);
		
		
		// Click on Logout option
		//driver.findElement(By.id("Label1")).click();


	}
	
	
	public void TakeScreenshot(WebDriver driver) throws IOException{
		
		File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println();
		FileUtils.copyDirectory(scr, new File("D:/Rajendra_backup/JAGAN 13-02/Selenium/Selenium Mars/TakeScreenshot/test1.png"));
		
		
		
	}

}
