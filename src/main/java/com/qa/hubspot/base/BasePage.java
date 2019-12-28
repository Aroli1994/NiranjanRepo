package com.qa.hubspot.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.hubspot.util.TimeUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * 
 * @author 496305
 *
 */
public class BasePage {

	public WebDriver driver;
	public Properties prop;

	/**
	 * This method is used to initialize the web driver and it will return driver
	 * @param prop
	 * @return driver
	 */
	public WebDriver initialize_driver(Properties prop) {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "D:\\SELENIUM\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Browser " + browserName
					+ " is defined in properties file, please provide the correct browser name");
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));
		TimeUtil.mediumWait();
		
		return driver;
	}
	
	/**
	 * This method is used to initialize the properties and it will return properties ref
	 * @return prop
	 */
	public Properties initialize_properties() {
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream("D:\\SELENIUM\\Softwares techM\\Projects\\SeleniumPOMSeries\\src\\main\\java\\com\\qa\\hubspot\\configuration\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
