package com.mst.automation.allied.browserfactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class BrowserFactory {

	public static WebDriver driver;
	
	@Test
	@Parameters("browser") 
		public static WebDriver getDriver(String browser) throws Exception{
			//Check if parameter passed from TestNG is 'firefox'
	    	Properties prop =  	new Properties();
			FileInputStream fis = new FileInputStream("D:\\Selenium Projects\\AlliedAttorneyCom\\Login.properties");
			prop.load(fis);
		
			if(browser.equalsIgnoreCase("firefox")){
			//create firefox instance
				System.setProperty("webdriver.firefox.driver", "D:\\Selenium Projects\\AlliedAttorneyCom\\Drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.get(prop.getProperty("url")); 
				//driver.get("https://shieldqa-adflegalrv2.cs92.force.com/AlliedAttorneyCommunity/s/login/SelfRegister");
				driver.manage().window().maximize();
			}
			//Check if parameter passed as 'chrome'
			else if(browser.equalsIgnoreCase("chrome")){
				//set path to chromedriver.exe
				System.setProperty("webdriver.chrome.driver","D:\\Selenium Projects\\AlliedAttorneyCom\\Drivers\\chromedriver.exe");
				//create chrome instance 
				driver = new ChromeDriver();
				//driver.get("https://shieldqa-adflegalrv2.cs92.force.com/AlliedAttorneyCommunity/s/login/SelfRegister");
				driver.get(prop.getProperty("url"));
				driver.manage().window().maximize();
				
				
				//cl = new CommunityLogin(driver);
			}
			//Check if parameter passed as 'Edge'
					else if(browser.equalsIgnoreCase("Edge")){
						//set path to Edge.exe
						System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
						//create Edge instance
						driver = new EdgeDriver();
					}
			else{
				//If no browser passed throw exception
				throw new Exception("Browser is not correct");
			}
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			return driver;
			
	 }

	
	public void getScreenShot(String result) throws IOException{
		
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("D://AAScreenshots//"+result+"screenshot.png"));
	}
	
}
