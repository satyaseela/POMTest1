package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {
	//Page Factory- OR:
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement login;
	
	@FindBy (xpath ="//input[@placeholder='E-mail address']")
	WebElement username;
	
	@FindBy (xpath = "//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath= "//div[@class='ui fluid large blue submit button']")
	WebElement loginbutton;
	
	@FindBy(xpath="//a[normalize-space()='Sign Up']")
	WebElement signup;
	
	//to initialize the elements with help of PageFactory 
	//define constructor
	public LoginPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
		
		return new HomePage();
	}
}
