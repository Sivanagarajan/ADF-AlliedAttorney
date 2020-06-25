package com.mst.sutomation.allied.regressiontestcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.mst.automation.allied.browserfactory.BrowserFactory;
import com.mst.automation.allied.utils.DataUtils;


public class Registration extends DataUtils {

	public WebDriver driver;

	@BeforeTest
	@Parameters({"browser"}) 
	public void setUp(String browser) throws Exception {
		
		BrowserFactory bf = new BrowserFactory();
		driver = bf.getDriver(browser);
		
       
	}

	@Test
	@Parameters({"browser"}) 
	public void NewRegistration(String browser) throws IOException, InterruptedException {

		DataUtils du = new DataUtils();
		ArrayList exdata = du.getdata("TC-001");

		System.out.println((exdata.get(1)).toString());
		System.out.println(exdata.get(1));
		System.out.println(exdata.get(2));
		System.out.println(exdata.get(3));
		System.out.println(exdata.get(4));

		driver.findElement(By.xpath(".//input[@name='firstname']")).sendKeys(exdata.get(1).toString());

		driver.findElement(By.xpath(".//input[@name='lastname']")).sendKeys(exdata.get(2).toString());

		driver.findElement(By.xpath(".//input[@name='email']")).sendKeys(exdata.get(3).toString());

		driver.findElement(By.xpath(".//input[@name='username']")).sendKeys(exdata.get(4).toString());

		driver.findElement(By.xpath(".//button[contains(.,'Register')]")).click();
	}
	



}
