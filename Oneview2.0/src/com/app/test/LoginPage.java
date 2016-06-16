package com.app.test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginPage {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver=new FirefoxDriver();
		//System.setProperty("WebDriver.chrome.driver","D:\\Rajendra_backup\\chromedriver.exe" );
		//WebDriver driver =new ChromeDriver();
		
		Business business=new Business();
		
	business.doLogin(driver);
		
		business.doOperation(driver);
		
		Business.shiftDetails(driver);
		
		business.TakeScreenshot(driver);
   
	}

}
