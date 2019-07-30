package com.imaginea.amazontask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.reporters.Files;
import org.apache.commons.io.FileUtils;

public class Registration extends BaseClass {
	
	
	@Test
	public void userRegistration() {

		/*
		 * WebElement yourname = driver.findElement(By.name("customerName"));
		 * yourname.sendKeys("teju");
		 */
		mychrome.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 WebElement myname=mychrome.findElement(By.xpath("//input[@id='ap_customer_name']"));
		 myname.sendKeys(prop.getProperty("name"));
		
		 
		WebElement dropdown_button = mychrome.findElement(By.xpath("//span[@class='a-dropdown-prompt']"));
		dropdown_button.getAttribute("value");

		WebElement mobile_number = mychrome.findElement(By.xpath("//input[@id='ap_phone_number']"));
		mobile_number.sendKeys(prop.getProperty("mobile"));
		
		WebElement email = mychrome.findElement(By.xpath("//input[@id='ap_email']"));
		email.sendKeys(prop.getProperty("email"));
		
		WebElement password = mychrome.findElement(By.xpath("//input[@id='ap_password']"));
		password.sendKeys(prop.getProperty("password"));
		
		WebElement continue_button = mychrome.findElement(By.xpath("//input[@id='continue']"));
		continue_button.click();

	}
	@AfterMethod
	public void tearDown(ITestResult result  )
	{
		if(ITestResult.FAILURE==result.getStatus()) {
			try {
				TakesScreenshot ts=(TakesScreenshot)mychrome;
				File Source =ts.getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(Source, new File("./ScreenShots/"+result.getName()+".png"));
				System.out.println(" screenshot taken");
			}
			catch(Exception e) {
				System.out.println(" failed due to"+ e.getMessage());
			}
		
		}
		
		
	}
	/*
	 * @Test public void screenshot() { File screenshotFile =
	 * ((TakesScreenshot)mychrome).getScreenshotAs(OutputType.FILE);
	 * FileUtils.copyFile(screenshotFile, new File("./Amazon/ScreenShots"));
	 * System.out.println(" screenshot taken"); }
	 */

}
