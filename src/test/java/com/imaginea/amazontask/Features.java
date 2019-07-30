package com.imaginea.amazontask;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Features extends BaseClass {

	@Test(priority=0)
	public void login() {
		WebElement signin = mychrome.findElement(By.partialLinkText("Sign"));
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

	@Test(priority=1)
	public void searchCart() {

		WebElement search = mychrome.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys(prop.getProperty("search"));

		WebElement button = mychrome.findElement(By.xpath("//input[@class='nav-input']"));
		button.click();
		WebElement filter1 = mychrome.findElement(By.xpath("//li[@id='p_89/Mi']//i[@class='a-icon a-icon-checkbox']"));
		filter1.click();
		WebElement filter2 = mychrome.findElement(By.xpath("//ul[6]//li[1]//span[1]//a[1]//div[1]//label[1]//i[1]"));
		filter2.click();
		WebElement filter3 = mychrome.findElement(By.xpath("//ul[8]//li[3]//span[1]//a[1]//div[1]//label[1]//i[1]"));
		filter3.click();
		WebElement result = mychrome.findElement(By.xpath("//span[contains(text(),'(Renewed) Xiaomi Redmi 4 (Black, 32GB)')]"));
		result.click();
	}
	@Test(priority=2)
      public void addToCart() {
		Set<String> tab = mychrome.getWindowHandles();
		Iterator<String> it = tab.iterator();
		String parentId = it.next();
		String childId = it.next();
		mychrome.switchTo().window(childId);

		mychrome.findElement(By.xpath("//input[@id='add-to-wishlist-button-submit']")).click();
		//WebElement cancel = mychrome.findElement(By.xpath("//span[@class='a-button a-button-base']//input[@class='a-button-input a-declarative']"));
		//cancel.click();
		
		
		
		
	
	}
	
	
	@Test(priority = 2)
	public void orders() {
		Actions action = new Actions(mychrome);
		WebElement element = mychrome
				.findElement(By.xpath("//span[@class='nav-line-2'][contains(text(),'Account & Lists')]"));
		WebElement elementToClick = mychrome
				.findElement(By.xpath("//span[@class='nav-text'][contains(text(),'Your Orders')]"));
		action.moveToElement(element).click(elementToClick).build().perform();
		action.clickAndHold();
		WebElement cancelled_orders = mychrome.findElement(By.xpath("//a[contains(text(),'Cancelled Orders')]"));
		cancelled_orders.click();

		WebElement view_all_orders = mychrome.findElement(By.xpath("//a[contains(text(),'View all orders')]"));
		view_all_orders.click();
		WebElement feedback = mychrome.findElement(By.xpath("//a[@id='Leave-delivery-feedback_1']"));
		feedback.click();

	
}
}
