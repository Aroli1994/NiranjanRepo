package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.TimeUtil;

public class LoginPage extends BasePage {
	
	//1.Define the page factory or page objects
	@FindBy(id="username")
	WebElement emailID;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="loginBtn")
	WebElement loginButton;
	
	@FindBy(linkText="Sign up")
	WebElement signUpLink;
	
	//2.We have the constructor of login page class and initialize the page objects with the help of driver
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		//PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, this);
	}
	
	//3.Page Actions or Page Library
	public String getLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifySignUpLinkDisplayed() {
		return signUpLink.isDisplayed();
	}
	
	public HomePage doLogin(String uname, String pwd) {
		System.out.println("Credentials: "+uname+"/"+pwd);
		emailID.sendKeys(uname);
		password.sendKeys(pwd);
		loginButton.click();
		TimeUtil.longWait();
		return new HomePage(driver);
	}
}
