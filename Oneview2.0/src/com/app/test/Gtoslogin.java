package com.app.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Gtoslogin {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
     WebDriver driver =new FirefoxDriver();
     
     driver.manage().window().maximize();
     
     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
     
     Runtime.getRuntime().exec("D:\\Rajendra_backup\\AutoIT\\AutoIt\\HandleAuth1.exe");
     
     driver.get("http://172.16.22.31:8085/Home/LoginHome.aspx");
     
     
	}

}
