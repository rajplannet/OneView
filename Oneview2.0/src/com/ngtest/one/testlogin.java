package com.ngtest.one;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


public class testlogin {
	TestResult res=new TestResult();
	TestResult res2=new TestResult();
	
	
	
	
	
	List<TestResult> list=new ArrayList<TestResult>();
   
	@Test
	public void test() throws Exception{
		
		WebDriver driver= new FirefoxDriver();
		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://172.16.22.31:8195/LoginPage.aspx");
		res.setTestClass("testlogin");
		res.setTestDescription("dessssss");
		res.setTestId("01");
		res.setTestMethod("test");
		res.setTestName("test login");
		res.setTestResult("pass");
		list.add(res);
		Utility.writeCountryListToFile("LoginSheet.xlsx", list);
	}
	
	
}
