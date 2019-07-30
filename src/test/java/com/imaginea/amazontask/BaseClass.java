package com.imaginea.amazontask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;


public class BaseClass {
	WebDriver mychrome;
	String baseUrl;
	Properties prop = new Properties();
	
	
	@Parameters({"Browser"})
	@Test
	public void base(String Browser) throws MalformedURLException {
		System.out.println("name of the driver is " + Browser);
			Assert.assertEquals("chrome", Browser);
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		mychrome = new ChromeDriver();
		/*
		 * String nodeURL = "http://172.16.48.27:5566/wd/hub"; DesiredCapabilities
		 * capability = DesiredCapabilities.chrome();
		 * capability.setBrowserName("chrome"); capability.setPlatform(Platform.LINUX);
		 * mychrome = new RemoteWebDriver(new URL(nodeURL), capability);
		 */baseUrl = "https://www.amazon.in/register/";
		mychrome.get(baseUrl);
		mychrome.manage().window().maximize();
		String expectedTitle = "Amazon Registration";
		String actualTitle = "";
		actualTitle = mychrome.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	

	}

	
	@BeforeMethod
	public void properties() {

		File file = new File("DataFile1.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			prop.load(fileInput);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
