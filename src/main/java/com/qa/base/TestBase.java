package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.util.util;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	//TestBase class constructor
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/gcit/eclipse-workspace/POMTest1/src/main/java/com/qa/configratuion/config.properties");
			 prop.load(ip);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void intialization() {
		String browserName = prop.getProperty("browser");
		if( browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\gcit\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if( browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\gcit\\Downloads\\geckodriver-v0.31.0-win64");
			driver=new FirefoxDriver();
		
	}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(util.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(util.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty(("url")));
		
	}		
}
