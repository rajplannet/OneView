package com.ngtest.one;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Loginoneview {
   WebDriver driver;
	@BeforeMethod
	public void Startup(){
	 driver = new FirefoxDriver();
		driver.get("http://172.16.22.31:8195/LoginPage.aspx");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	}
	@Test
	public void dologin() throws IOException, InterruptedException{

		driver.findElement(By.id("txtusername")).sendKeys("superadmin");
		driver.findElement(By.id("txtPassword")).sendKeys("oneview");
		
		driver.findElement(By.id("ASPxButton1")).click();
		System.out.println("Login successfully done");
		
		wait(100);
		takeScreenshot();
	}
	
	@Test
	public void takeScreenshot() throws IOException{
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D://Rajendra_backup//JAGAN 13-02//Selenium//Selenium Mars//TakeScreenshot//login.png"));
	}
	
	@AfterMethod
	public void shutup(){
		//driver.quit();
		
	}
	
}
