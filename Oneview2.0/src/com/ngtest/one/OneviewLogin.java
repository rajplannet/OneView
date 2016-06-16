package com.ngtest.one;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.app.test.Business;

public class OneviewLogin {
	
	static WebDriver driver;
	static File scr;
	static String f_name="";
	
/*	@Test(priority=1)
	public void mainFrame() throws IOException{
		System.out.println("Explore Homepage is opened");
		
		System.out.println("Test cases is passed");
		try {
			doLogoin();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
	
	
	@Test(priority=1)
	public static void doLogoin() throws InterruptedException, IOException{
		
		driver = new FirefoxDriver();
		
		
		
		driver.get("http://172.16.22.31:8195/Options.aspx");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// Enter the username
				driver.findElement(By.id("txtusername")).sendKeys("superadmin");

				// Enter the the password
				driver.findElement(By.id("txtPassword")).sendKeys("oneview");
				Thread.sleep(1000);

				// Mouse hover for sign In button and click on button
			 driver.findElement(By.id("ASPxButton1")).click();
			 Thread.sleep(1000);
	    //  Utility.captureScreenshot(driver, "Explore HomePage Oneview");	
			 scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			 f_name=scr.getName();			
	}
	
	@Test(priority=2)
	public static void ExploreHomePage() throws InterruptedException, IOException{
		
	doLogoin();
	driver.findElement(By.id("TDOperation")).click();
		
	//driver.findElement(By.id("DivCommercial Sample")).click();
	//wait(20);
	 scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 f_name=scr.getName();
	 }
	
	@Test(priority=3)
	public static void ShiftDetails() throws InterruptedException, IOException{
		
		ExploreHomePage();
		
		
		//Click on ManageData option
		Actions action = new Actions(driver);
		WebElement hover=driver.findElement(By.id("ASPxRibbon1_TC_T2T"));
		action.moveToElement(hover).build().perform();
		
		driver.findElement(By.id("ASPxRibbon1_TC_T2T")).click();
		Thread.sleep(10000);
		
		//Click on shiftDetails Page
		//driver.findElement(By.id("ASPxRibbon1_T2G0I0")).click();
		driver.findElement(By.id("ASPxRibbon1_T2"));
		System.out.println("Ribbon bar is displayed");
		
		Actions action1 = new Actions(driver);
		WebElement hover1=driver.findElement(By.xpath(".//*[@id='ASPxRibbon1_T2G0I0_LI']"));
		action1.moveToElement(hover1).build().perform();
		
		driver.findElement(By.xpath(".//*[@id='ASPxRibbon1_T2G0I0_LI']")).click();
		
		Thread.sleep(50000);
		
		
	}
	
	@AfterMethod
	
	public void teardown(ITestResult result) throws IOException{
		System.out.println("88888888888888888888"+result.getInstanceName()+"----"+result.getMethod()+"---"+result.getStatus()+"scrrrrr");
		

	
		if(ITestResult.FAILURE==result.getStatus()){
			System.out.println("Failed TestCase"+scr);
			File dest = new File(Utility.destination+"/"+scr.getName());
			Utility.copyFileUsingStream(scr, dest);
		
		}else if(ITestResult.SUCCESS==result.getStatus()){
			
			
		}else{
			System.out.println("elssssssss");
		}
		driver.quit();
	}
	
	
	

}
