package com.app.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class test {
	
	@Test
	public void loginsrt(){
   WebDriver driver = new FirefoxDriver();
   driver.get("http://172.16.22.31:8041/LoginPage.aspx");
   
	}
   
}
