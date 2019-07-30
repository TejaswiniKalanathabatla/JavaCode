package com.imaginea.amazontask;

import java.sql.Time;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class Profile extends BaseClass {

	@Test(priority = 0)
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


	@Test(priority = 1)
	public void yourAccount() {

		/*
		 * Actions action = new Actions(mychrome); //Wait<WebDriver> wait = new
		 * FluentWait<WebDriver>(mychrome));
		 * 
		 * //WebElement clickseleniumlink = wait.until(new Function<WebDriver,
		 * WebElement>(){
		 * 
		 * public WebElement apply(WebDriver driver ) { return driver.findElement(By.
		 * xpath("//span[@class='nav-line-2'][contains(text(),'Account & Lists')]")); }
		 * });
		 */
		
		
		//WebElement element = mychrome.findElement(By.xpath("//span[@class='nav-line-2'][contains(text(),'Account & Lists')]"));
		
		WebElement login = mychrome.findElement(By.xpath("//h2[contains(text(),'lLogin & security')]"));
		login.click();

		WebElement edit = mychrome.findElement(By.xpath("//input[@id='auth-cnep-edit-name-button']"));
		edit.click();

		WebElement edit_name = mychrome.findElement(By.xpath("//input[@id='ap_customer_name']"));
		edit_name.sendKeys(prop.getProperty("name_edit"));

		WebElement submit = mychrome.findElement(By.xpath("//input[@id='cnep_1C_submit_button']"));
		submit.click();
	

		/*
		 * WebElement passwordw =
		 * mychrome.findElement(By.xpath("//input[@id='auth-cnep-edit-password-button']"
		 * )); passwordw.click();
		 * 
		 * WebElement old_pwd =
		 * mychrome.findElement(By.xpath("//input[@id='ap_password']"));
		 * old_pwd.sendKeys("saisai123");
		 * 
		 * WebElement new_pwd =
		 * mychrome.findElement(By.xpath("//input[@id='ap_password_new']"));
		 * new_pwd.sendKeys("saisai12");
		 * 
		 * WebElement check_pwd =
		 * mychrome.findElement(By.xpath("//input[@id='ap_password_new_check']"));
		 * check_pwd.sendKeys("saisai12");
		 * 
		 * 
		 * WebElement save_changes =
		 * mychrome.findElement(By.xpath("//input[@id='cnep_1D_submit_button']"));
		 * save_changes.click();
		 */		  
		  WebElement done =
		  mychrome.findElement(By.xpath("//a[@id='auth-cnep-done-button']"));
		  done.click();
		 	}

	@Test(priority = 2)
	public void address() {
		/*
		 * Actions action = new Actions(mychrome); WebElement element =
		 * mychrome.findElement(By.xpath("//a[@id='nav-link-yourAccount']")); WebElement
		 * elementToClick =
		 * mychrome.findElement(By.xpath("//span[contains(text(),'Your Account')]"));
		 * action.moveToElement(element).click(elementToClick).build().perform();
		 * action.clickAndHold();
		 */
		WebElement address = mychrome.findElement(By.xpath("//h2[contains(text(),'Your Addresses')]"));
		address.click();
		WebElement edit_address = mychrome.findElement(By.xpath("//a[@id='ya-myab-address-edit-btn-0']"));
		edit_address.click();
		WebElement landmark = mychrome.findElement(By.xpath("//input[@id='address-ui-widgets-landmark']"));
		landmark.sendKeys(prop.getProperty("landmark"));
		WebElement save = mychrome.findElement(By.xpath("//input[@class='a-button-input']"));
		save.click();
	}

	
	@Test(priority = 3)
	public void logout() {
		Actions action = new Actions(mychrome);
		WebElement element = mychrome
				.findElement(By.xpath("//span[@class='nav-line-2'][contains(text(),'Account & Lists')]"));
		WebElement elementToClick = mychrome.findElement(By.xpath("//span[contains(text(),'Sign Out')]"));
		action.moveToElement(element).click(elementToClick).build().perform();
		action.click();

	}
}
