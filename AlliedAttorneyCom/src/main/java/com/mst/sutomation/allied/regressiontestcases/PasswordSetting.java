package com.mst.sutomation.allied.regressiontestcases;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mst.automation.allied.browserfactory.BrowserFactory;
import com.mst.automation.allied.utils.DataUtils;
import com.sun.tools.xjc.Driver;

import HighlightElement.HighlightElement;

public class PasswordSetting extends DataUtils {
	
	
	public WebDriver driver;

	@BeforeTest
	@Parameters({"browser"}) 
	public void setUp(String browser) throws Exception {
		
		BrowserFactory bf = new BrowserFactory();
		driver = bf.getDriver(browser);
		driver.get("http://www.yopmail.com/en/");
		
	}
		
		@Test
		@Parameters({"browser"}) 
		public void PasswordSetup(String browser) throws IOException, InterruptedException{
		
		
		HighlightElement HE = new HighlightElement();
		Thread.sleep(5000);
		WebElement emailbox = driver.findElement(By.xpath(".//input[@name='login']"));
		HE.highLightElement(driver, emailbox);
		
		DataUtils du = new DataUtils();
		ArrayList exdata = du.getdata("TC-001");
		
		System.out.println((exdata.get(1)).toString());
		System.out.println(exdata.get(1));
		System.out.println(exdata.get(2));
		System.out.println(exdata.get(3));
		System.out.println(exdata.get(4));
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//input[@name='login']")).sendKeys(exdata.get(4).toString());
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//input[@value='Check Inbox']")).click();
		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//span[contains(.,'Sandbox: Allied Attorney')]")).click();
		System.out.println("clicked email.");
		
		
		Thread.sleep(5000);
		driver.findElement(By.xpath(".//a[contains(.,'Create Password')]")).click();
		
		
		
		}
	}



