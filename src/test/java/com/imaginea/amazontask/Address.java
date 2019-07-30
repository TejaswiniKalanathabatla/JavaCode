package com.imaginea.amazontask;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Address extends BaseClass {

	// WebDriver mychrome;
	// String baseUrl;
	// Properties prop = new Properties();

	@Test(priority = 0)
	public void login() {
		// System.out.println("name of the driver is " + Browser);
		// Assert.assertEquals("chrome", Browser);
		/*
		 * System.setProperty("webdriver.chrome.driver", "chromedriver"); mychrome = new
		 * ChromeDriver(); baseUrl = "https://www.amazon.in/register/";
		 * mychrome.get(baseUrl); mychrome.manage().window().maximize(); String
		 * expectedTitle = "Amazon Registration"; String actualTitle = ""; actualTitle =
		 * mychrome.getTitle(); System.out.println("from addres class "+actualTitle);
		 * Assert.assertEquals(actualTitle, expectedTitle);
		 */
		WebElement signin = mychrome.findElement(By.xpath("//div[8]//a"));
		signin.click();
		WebElement email = mychrome.findElement(By.xpath("//input[@id='ap_email']"));
		email.sendKeys(prop.getProperty("email"));
		WebElement continue_button = mychrome.findElement(By.xpath("//input[@id='continue']"));
		continue_button.click();
		WebElement password = mychrome.findElement(By.xpath("//input[@id='ap_password']"));
		password.sendKeys(prop.getProperty("password"));
		WebElement login_button = mychrome.findElement(By.xpath("//input[@id='signInSubmit']"));
		login_button.click();

	}

	@Test(priority = 1)
	public void address() {
		Actions action = new Actions(mychrome);
		WebElement element = mychrome
				.findElement(By.xpath("//span[@class='nav-line-2'][contains(text(),'Your Orders')]"));
		WebElement elementToClick = mychrome.findElement(By.xpath("//span[contains(text(),'Your Account')]"));
		action.moveToElement(element).click(elementToClick).build().perform();
		action.clickAndHold();

		WebElement address = mychrome.findElement(By.xpath("//h2[contains(text(),'Your Addresses')]"));
		address.click();
		WebElement add_address = mychrome.findElement(By.xpath("//h2[@class='a-color-tertiary']"));
		add_address.click();

	}

}
