package com.ngtest.one;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testoneview {
	static File scr;

	
	/*@BeforeMethod
	public void startUp(){
		
		
	}*/
	
	@Test
	public void testLogin() throws InterruptedException{
	WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://172.16.22.31:8195/LoginPage.aspx");
		driver.findElement(By.id("txtusername")).sendKeys("superadmin");

		// Enter the the password
		driver.findElement(By.id("txtPassword")).sendKeys("oneview");
		Thread.sleep(1000);

		// Mouse hover for sign In button and click on button
	 driver.findElement(By.id("ASPxButton1")).click();
	 Thread.sleep(1000);
	 
	 scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException{
		
		if(ITestResult.FAILURE==result.getStatus()){
			System.out.println("Failed TestCase"+"/"+scr);
			
			File dest = new File(Utility.destination+"/"+scr.getName());
			
			Utility.copyFileUsingStream(scr, dest);
				
		}else if (ITestResult.SUCCESS==result.getStatus()){
			
			System.out.println("Passed Test Case"+"/"+scr);
			
			File dest = new File(Utility.destination+"/"+scr.getName());
			
			Utility.copyFileUsingStream(scr, dest);
		}
		
		
	}

}
