package com.mst.sutomation.allied.regressiontestcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mst.automation.allied.browserfactory.BrowserFactory;

import HighlightElement.HighlightElement;

public class CampaignCreation {
	
	public WebDriver driver;
	
	@BeforeTest
	@Parameters({"browser"}) 
	public void setUp(String browser) throws Exception {
		
		HighlightElement HE = new HighlightElement();
		BrowserFactory bf = new BrowserFactory();
		driver = bf.getDriver(browser);
		driver.get("https://test.salesforce.com/");
		
		Thread.sleep(5000);
		WebElement username = driver.findElement(By.xpath(".//input[@id='username']"));
		HE.highLightElement(driver, username);
		username.sendKeys("siva@adflegal.org");
		
		
		WebElement password = driver.findElement(By.xpath(".//input[@id='password']"));
		HE.highLightElement(driver, password);
		password.sendKeys("ADFqa@123");
		


		driver.findElement(By.xpath(".//input[@id='Login']")).click();
		
       
	}

	@Test
	@Parameters({"browser"}) 
	public void campaigncreation(String browser) throws IOException, InterruptedException{
		
		HighlightElement HE = new HighlightElement();
		
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		
		//Thread.sleep(10000);
		driver.findElement(By.xpath(".//a[@title='Campaigns Tab']")).click();
//		HE.highLightElement(driver, campaign);
//		campaign.
		
		//Thread.sleep(10000);
		driver.findElement(By.xpath(".//input[@title='New']")).click();
		
		//Thread.sleep(5000);
		driver.findElement(By.xpath(".//select[@id='p3']")).click();
		
		//Thread.sleep(5000);
		driver.findElement(By.xpath(".//option[contains(.,'Allied Attorney Application Campaign')]")).click();
		
		//Thread.sleep(5000);
		driver.findElement(By.xpath(".//input[@title='Continue']")).click();
		
		//Thread.sleep(5000);
		WebElement CampaignName = driver.findElement(By.xpath(".//input[@id='cpn1']"));
		HE.highLightElement(driver, CampaignName);
		CampaignName.sendKeys("Automation AA Campaingn");
		
		//Thread.sleep(5000);
		WebElement StartDate = driver.findElement(By.xpath(".//input[@id='cpn5']"));
		HE.highLightElement(driver, StartDate);
		StartDate.click();
				
		//Thread.sleep(5000);
		driver.findElement(By.xpath(".//a[@class='calToday']")).click();
		
		//Thread.sleep(5000);
		driver.findElement(By.xpath(".//label[contains(.,'End Date')]")).click();
		
		//Thread.sleep(5000);
		WebElement EndDate = driver.findElement(By.xpath(".//input[@id='cpn6']"));
		HE.highLightElement(driver, EndDate);
		EndDate.click();		
		
		//Thread.sleep(5000);
		driver.findElement(By.xpath(".//a[@class='calToday']")).click();
		
		//Thread.sleep(5000);
		Select type = new Select(driver.findElement(By.xpath(".//select[@id='cpn2']")));
		type.selectByIndex(1);
		
		
		//Thread.sleep(5000);
		driver.findElement(By.xpath(".//input[@id='cpn16']")).click();
				
		//Thread.sleep(5000);
		WebElement DecisionDate = driver.findElement(By.xpath(".//input[@id='00N3F000007DvWk']"));
		HE.highLightElement(driver, DecisionDate);
		DecisionDate.click();		
		
		//Thread.sleep(5000);
		driver.findElement(By.xpath(".//a[@class='calToday']")).click();		
		
		//Thread.sleep(5000);
		WebElement BannerName = driver.findElement(By.xpath(".//input[@id='00N3F000009dh6l']"));
		HE.highLightElement(driver, BannerName);
		BannerName.sendKeys("Auto Banner Name");
		
		driver.findElement(By.xpath(".//input[@title='Save']")).click();
		
	}
}
