package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.util.TimeUtil;

public class HomePage extends BasePage{
	
	//1.page factory -- page objects
	@FindBy(xpath="//h1[@class='private-page__title']")
	WebElement homePageHeader; 
	
	@FindBy(xpath="//span[@class='account-name ']")
	WebElement accountName;
	
	@FindBy(partialLinkText = "Reports")
	WebElement reports;
	
	@FindBy(partialLinkText = "Dashboards")
	WebElement dashBoard;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void takeToCorrectReportURL() {
		reports.click();
		dashBoard.click();
		TimeUtil.longWait();
//		driver.navigate().to("https://app.hubspot.com/reports-dashboard/6406220/sales");
//		TimeUtil.shortWait();
	}
	
	//2.Page actions or page libraries
	public String getHomePageTitle() {
		return driver.getTitle();
	}
	
	public String getHomePageHeaderText() {
		return homePageHeader.getText();
	}
	
	public boolean verifyHomepageHeader() {
		return homePageHeader.isDisplayed();
	}
	
	public String getAccountName() {
		return accountName.getText();
	}
	
	public boolean verifyAccountName() {
		return accountName.isDisplayed();
	}
	
	
	
}
