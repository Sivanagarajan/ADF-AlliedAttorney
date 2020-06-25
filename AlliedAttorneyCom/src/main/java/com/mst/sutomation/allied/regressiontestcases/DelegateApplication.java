package com.mst.sutomation.allied.regressiontestcases;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mst.automation.allied.browserfactory.BrowserFactory;
import com.mst.automation.allied.utils.DataUtils;

import HighlightElement.HighlightElement;
import uploadfile.UploadFile;

public class DelegateApplication extends DataUtils {
	
	
public WebDriver driver;
	
	public static Logger log= LogManager.getLogger(DelegateApplication.class.getName());
	
	
	
	
	@BeforeTest
	@Parameters({"browser"}) 
	public void setUp(String browser) throws Exception {

		HighlightElement HE = new HighlightElement();
		BasicConfigurator.configure();

		BrowserFactory bf = new BrowserFactory();
		
		driver = bf.getDriver(browser);
		//driver.get("https://shieldqa-adflegalrv2.cs92.force.com/ApplicationBlackstoneCommunity/s/login/");
		log.info("Url passed");
		
//		System.setProperty("webdriver.firefox.driver","D:/blacstone/Shield-BlackstoneCommunity/geckodriver.exe");
//		driver = new FirefoxDriver();
		
//		System.setProperty("webdriver.chrome.driver", "D:/blacstone/Shield-BlackstoneCommunity/Drivers/chromedriver.exe");
//		driver = new ChromeDriver();
		
		//driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		
		//driver.get("https://shielddemo-adflegalrv2.cs64.force.com/BlackstoneCommunity/s/");
		
		Thread.sleep(5000);
		WebElement username = driver.findElement(By.xpath(".//span[contains(.,'Sign In')]/following::input[1]"));
		HE.highLightElement(driver, username);
		username.sendKeys("aaautomation2");
		log.info("Username entered");


		Thread.sleep(5000);
		WebElement password = driver.findElement(By.xpath(".//span[contains(.,'Sign In')]/following::input[2]"));
		HE.highLightElement(driver, password);
		password.sendKeys("Admin@123");
		log.info("password entered");
		
		
		driver.findElement(By.xpath(".//button[@type='submit']")).click();
		
 		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
 		
 		Thread.sleep(5000);
 		WebElement element = driver.findElement(By.xpath(".//strong[contains(.,'Status')]/following::button[@name='7013F000000d2qJQAQ']"));
 		HE.highLightElement(driver, element);
 		String title = element.getAttribute("title");
 		System.out.println(title);
 		
 		if(title.equalsIgnoreCase("Apply Now"))
 		{
 		Thread.sleep(10000);
 		driver.findElement(By.xpath(".//strong[contains(.,'Status')]/following::button[@name='7013F000000d2qJQAQ']")).click();
 		log.info("Clicked Apply now");
 
 		 // GDPR page
 		 
 		 Select consent1 = new
 		 Select(driver.findElement(By.xpath(".//u[contains(.,'General Data Protection Regulation (GDPR)')]/following::select")));
 		 consent1.selectByIndex(1);
 		log.info("Gdp1 selected");
 		 
 		 driver.findElement(By.xpath(".//button[@title='Neutral action']")).click();
 		log.info("Clicked next");
 
 		 Thread.sleep(10000);
 		 Select consent2 = new
 		 Select(driver.findElement(By.xpath(".//u[contains(.,'General Data Protection Regulation (GDPR)')]/following::select[2]")));
 		 consent2.selectByIndex(1);
 		log.info("GDPR2 selected");
 		
 		Thread.sleep(10000);
		 Select consent3 = new
		 Select(driver.findElement(By.xpath(".//u[contains(.,'General Data Protection Regulation (GDPR)')]/following::select[3]")));
		 consent3.selectByIndex(1);
		log.info("GDPR2 selected");
 		 
		
		Thread.sleep(10000);
		 Select consent4 = new
		 Select(driver.findElement(By.xpath(".//u[contains(.,'General Data Protection Regulation (GDPR)')]/following::select[4]")));
		 consent4.selectByIndex(1);
		log.info("GDPR3 selected");
		
		Thread.sleep(10000);
		 Select consent5 = new
		 Select(driver.findElement(By.xpath(".//u[contains(.,'General Data Protection Regulation (GDPR)')]/following::select[5]")));
		 consent5.selectByIndex(1);
		log.info("GDPR4 selected");

 		 Thread.sleep(10000);
 		 driver.findElement(By.xpath(".//button[@title='Continue & Save']")).click();
 		log.info("Completed GDPR");
 		
 		
 		Thread.sleep(10000);
		 driver.findElement(By.xpath(".//span[contains(.,'Check here to agree that you have read and agree with the above commitments.')]")).click();
		log.info("Clicked checkbox");
		
		Thread.sleep(10000);
		driver.findElement(By.xpath(".//button[@title='Begin Application']")).click();
		log.info("Clicked BeginApplication");
		
 		}
 		
 		else
 		{
 			driver.findElement(By.xpath(".//strong[contains(.,'Status')]/following::button[@name='7013F000000d2qJQAQ']")).click();
 			log.info("Skipper GDPR");
 		}

		
	}



	@Test
	@Parameters({"browser"}) 
	public void ApplicationFilling(String browser) throws InterruptedException, IOException{

		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		BasicConfigurator.configure();
		
		
		 Thread.sleep(6000);
		 driver.findElement(By.xpath(".//b[contains(.,'Status')]/following::button[1]")).click();
		 log.info("Clicked Step1");
		 
		 DataUtils value = new DataUtils();
		 ArrayList exdata = value.getdata("TC-001");
		 
		// Personal Information
		 Thread.sleep(6000);
		  driver.findElement(By.xpath(".//b[contains(.,'Personal Information')]/following::input[1]")).sendKeys(exdata.get(1).toString());
		 
		 Thread.sleep(6000);
		 Select Sex = new Select(driver.findElement(By.xpath(".//b[contains(.,'Personal Information')]/following::select[1]")));
		 Sex.selectByIndex(1);
		
		 driver.findElement(By.xpath(".//b[contains(.,'Personal Information')]/following::input[3]")).sendKeys(exdata.get(2).toString());
		 
		 driver.findElement(By.xpath(".//b[contains(.,'Personal Information')]/following::input[4]")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath(".//b[contains(.,'Personal Information')]/following::input[4]")).sendKeys("Apr 21, 1990");
		 
//		 String currentdate= driver.findElement(By.className("slds-input__icon slds-input__icon_right")).getText();
//		 System.out.println(currentdate);		 
//		 driver.findElement(By.xpath(".//span[@class='slds-day weekday todayDate selectedDate DESKTOP uiDayInMonthCell--default']")).click();	
//		 driver.findElement(By.xpath(".//b[contains(.,'Personal Information')]/following::input[4]")).sendKeys(exdata.get(3).toString());
	
		 Thread.sleep(6000);
		Select Country = new Select(driver.findElement(By.xpath(".//b[contains(.,'Personal Information')]/following::select[2]")));
		Country.selectByValue("Engaged");
		 
		 Thread.sleep(6000);
		 driver.findElement(By.xpath(".//b[contains(.,'Personal Information')]/following::input[5]")).sendKeys(exdata.get(3).toString());
		 
		 driver.findElement(By.xpath(".//b[contains(.,'Personal Information')]/following::input[6]")).sendKeys(exdata.get(4).toString());
		
		 driver.findElement(By.xpath(".//b[contains(.,'Personal Information')]/following::input[7]")).sendKeys("Aug 24, 2021");
				 
		 Thread.sleep(5000);
		 driver.findElement(By.xpath(".//button[@title='Next']")).click();
		 log.info("Completed personal info page 1");
	 
		 //Business Address
		 
		 Thread.sleep(5000);
		 Select primary = new Select(driver.findElement(By.xpath(".//b[contains(.,'Business Address')]/following::select[1]")));
		 primary.selectByValue("No");
		 
		 driver.findElement(By.xpath(".//b[contains(.,'Business Address')]/following::input[1]")).sendKeys(exdata.get(5).toString());
	
		 driver.findElement(By.xpath(".//b[contains(.,'Business Address')]/following::input[2]")).sendKeys(exdata.get(6).toString());
	
		Thread.sleep(5000);
		Select Country1 = new Select(driver.findElement(By.xpath(".//b[contains(.,'Business Address')]/following::select[3]")));
		Country1.selectByValue("Alabama");
		
		 Thread.sleep(5000);
		 driver.findElement(By.xpath(".//b[contains(.,'Business Address')]/following::input[3]")).sendKeys(exdata.get(7).toString());
		 
		 driver.findElement(By.xpath(".//b[contains(.,'Business Address')]/following::input[4]")).sendKeys(exdata.get(8).toString());
		
		 driver.findElement(By.xpath(".//b[contains(.,'Business Address')]/following::input[5]")).sendKeys(exdata.get(9).toString());

		 Thread.sleep(5000);
		 driver.findElement(By.xpath(".//button[contains(.,'Next')]")).click();
		 log.info("Completed Business info page 2");
		 
		 // Home Address
		 
		 Thread.sleep(5000);		 
		 driver.findElement(By.xpath(".//b[contains(.,'Home Address')]/following::input[1]")).sendKeys(exdata.get(10).toString());
	
		 driver.findElement(By.xpath(".//b[contains(.,'Home Address')]/following::input[2]")).sendKeys(exdata.get(11).toString());
	
		Thread.sleep(5000);
		Select state = new Select(driver.findElement(By.xpath(".//b[contains(.,'Home Address')]/following::select[2]")));
		state.selectByValue("Alabama");
		
		 Thread.sleep(5000);
		 driver.findElement(By.xpath(".//b[contains(.,'Home Address')]/following::input[3]")).sendKeys(exdata.get(12).toString());
		 
		 driver.findElement(By.xpath(".//b[contains(.,'Home Address')]/following::input[4]")).sendKeys(exdata.get(13).toString());
		
		 driver.findElement(By.xpath(".//b[contains(.,'Home Address')]/following::input[5]")).sendKeys(exdata.get(14).toString());
 
		 Thread.sleep(5000);
		 driver.findElement(By.xpath(".//button[contains(.,'Finish')]")).click();
		 log.info("Completed Homes info page 3");
		 
	}
		 
		 //Educational information
		 
		 @Test
		 @Parameters({"browser"}) 
		 public void EducationInformation(String browser) throws InterruptedException, IOException{
			 
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
				BasicConfigurator.configure();

			 Thread.sleep(15000);
			 driver.findElement(By.xpath(".//b[contains(.,'Status')]/following::button[2]")).click();
			 
			
			 
			// Law record creation
			 
			 Thread.sleep(10000);
			 Select Type = new Select(
			 driver.findElement(By.xpath(".//b[contains(.,'Education')]/following::select[1]")));
			 Type.selectByIndex(3);
			 
			 Thread.sleep(5000);			 		 
			driver.findElement(By.xpath(".//label[contains(.,'School')]/following::input[@name='School__c']")).sendKeys("Alabama State University"); // need to update column number
			  
			
			HighlightElement HE = new HighlightElement();
			
			 Thread.sleep(10000);
			 Actions actions = new Actions(driver);
		     WebElement menuOption = driver.findElement(By.xpath(".//div[@role='listbox']/following::ul[@role='presentation']/li/div/div[contains(.,'Alabama State University')]"));
		     HE.highLightElement(driver, menuOption);
		     actions.moveToElement(menuOption).perform();
		     menuOption.click();
		     
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//button[@title='Submit']")).click();

			 // Undergraduate record creation
			 
			 Thread.sleep(10000);
			 Select Type1 = new Select(
			 driver.findElement(By.xpath(".//b[contains(.,'Education')]/following::select[1]")));
			 Type1.selectByIndex(1);
			 
			 Thread.sleep(5000); 			 
			 driver.findElement(By.xpath(".//label[contains(.,'Degree - Please')]/following::input[@name='Degree__c']")).sendKeys("BSC");
			 
			 driver.findElement(By.xpath(".//label[contains(.,'School')]/following::input[@name='School__c']")).sendKeys("Saint Xavier University");
			 
			//driver.manage().deleteAllCookies();
			 
			 Thread.sleep(10000);
			 Actions actions1 = new Actions(driver);
		     WebElement menuOption1 = driver.findElement(By.xpath(".//div[@role='listbox']/following::ul[@role='presentation']/li/div/div[contains(.,'Saint Xavier University')]"));
		     HE.highLightElement(driver, menuOption1);
		     actions1.moveToElement(menuOption1).perform();
		     menuOption1.click();
		
		     Thread.sleep(10000);
			 driver.findElement(By.xpath(".//label[contains(.,'Graduation Year')]/following::input[@name='Grad_Year__c']")).sendKeys("2011");

			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//button[@title='Submit']")).click();
			 
			 Thread.sleep(10000);
			 driver.findElement(By.xpath(".//button[contains(.,'Finish')]")).click();
			 log.info("Completed Education info Step 2");

			 
		 }
		 
		 @Test
		 @Parameters({"browser"})
		 public void Legalinformation(String browser) throws IOException, InterruptedException{
			 
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 BasicConfigurator.configure();
			 
			Thread.sleep(10000);
			driver.findElement(By.xpath(".//b[contains(.,'Status')]/following::button[3]")).click();
				
				
			 DataUtils value1 = new DataUtils();
			 ArrayList exdata = value1.getdata("TC-001");
			 
			 //Bar Admissions
			 
			 Thread.sleep(10000);
			 Select StateBar = new Select(
			 driver.findElement(By.xpath(".//label[contains(.,'State Bar')]/following::select[1]")));
			 StateBar.selectByIndex(1);
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//label[contains(.,'Attorney Lic # ')]/following::input[1]")).sendKeys(exdata.get(15).toString());
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//label[contains(.,'Year of Admission ')]/following::input[1]")).sendKeys(exdata.get(16).toString());
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//button[@title='Submit']")).click();
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//button[@title='Next']")).click();
			 
			 // Bar Admissions page 2
			 			 
			 Thread.sleep(10000);
			 Select select1 = new Select(driver.findElement(By.xpath(".//b[contains(.,'Bar Admissions')]/following::select[1]")));
			 select1.selectByIndex(1);
			 
			 Select select2 = new Select(driver.findElement(By.xpath(".//b[contains(.,'Bar Admissions')]/following::select[2]")));
			 select2.selectByIndex(1);
			 
			 Select select3 = new Select(driver.findElement(By.xpath(".//b[contains(.,'Bar Admissions')]/following::select[3]")));
			 select3.selectByIndex(1);
						 
			Select select4 = new Select(driver.findElement(By.xpath(".//b[contains(.,'Bar Admissions')]/following::select[4]")));
			select4.selectByIndex(1);
			
			Thread.sleep(5000);
			driver.findElement(By.xpath(".//button[@title='Next']")).click();
			
			
			// Bar Association Membership(s) page 3
			
			Thread.sleep(10000);
			 Select BarAssociation = new Select(driver.findElement(By.xpath(".//b[contains(.,'Bar Association Membership(s)')]/following::select[1]")));
			 BarAssociation.selectByIndex(1);
			 
			 Select SectionsCommittees = new Select(driver.findElement(By.xpath(".//b[contains(.,'Bar Association Membership(s)')]/following::select[2]")));
			 SectionsCommittees.selectByIndex(1);
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//button[@title='Submit']")).click();
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//button[@title='Next']")).click();
			 
			
			 // Clerkship(s)
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//b[contains(.,'Clerkship(s)')]/following::input[2]")).sendKeys(exdata.get(17).toString());
			 
			Thread.sleep(10000);
			Select Court = new Select(driver.findElement(By.xpath(".//b[contains(.,'Clerkship')]/following::select[1]")));
			Court.selectByIndex(1);
			
			Thread.sleep(5000);
			 driver.findElement(By.xpath(".//b[contains(.,'Clerkship')]/following::input[5]")).sendKeys(exdata.get(18).toString());
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//b[contains(.,'Clerkship')]/following::input[7]")).sendKeys(exdata.get(19).toString());
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//b[contains(.,'Clerkship')]/following::input[9]")).sendKeys(exdata.get(20).toString());
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//b[contains(.,'Clerkship')]/following::input[10]")).sendKeys(exdata.get(21).toString());
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//button[@title='Submit']")).click();

			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//button[@title='Next']")).click();
			 
			 
			 // Internship(s)
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//b[contains(.,'Internship(s)')]/following::input[2]")).sendKeys(exdata.get(22).toString());
			
			Thread.sleep(5000);
			 driver.findElement(By.xpath(".//b[contains(.,'Internship(s)')]/following::input[4]")).sendKeys(exdata.get(23).toString());
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//b[contains(.,'Internship(s)')]/following::input[6]")).sendKeys(exdata.get(24).toString());
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//b[contains(.,'Internship(s)')]/following::input[8]")).sendKeys(exdata.get(25).toString());
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//b[contains(.,'Internship(s)')]/following::input[10]")).sendKeys(exdata.get(26).toString());
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//button[@title='Submit']")).click();

			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//button[@title='Next']")).click();
			 
			 
			 // Court Admissions
			 			 
			 Thread.sleep(10000);
			 Select CourtName = new Select(driver.findElement(By.xpath(".//b[contains(.,'Court Admissions')]/following::select[1]")));
			 CourtName.selectByIndex(1);			 
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//b[contains(.,'Court Admissions')]/following::input[3]")).sendKeys(exdata.get(27).toString());
			 
			 Thread.sleep(10000);
			 Select Average = new Select(driver.findElement(By.xpath(".//b[contains(.,'Court Admissions')]/following::select[2]")));
			 Average.selectByIndex(1);
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//button[@title='Submit']")).click();

			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//button[@title='Next']")).click();
			 			 
			 
			 // Area of Practice
			 
			 Thread.sleep(10000);
			 Select Area = new Select(driver.findElement(By.xpath(".//b[contains(.,'Area of Practice')]/following::select[1]")));
			 Area.selectByIndex(1);
			 
			 Thread.sleep(10000);
			 Select CourtName1 = new Select(driver.findElement(By.xpath(".//b[contains(.,'Area of Practice')]/following::select[2]")));
			 CourtName1.selectByIndex(1);
			 
			 Thread.sleep(10000);
			 Select NumberofYears = new Select(driver.findElement(By.xpath(".//b[contains(.,'Area of Practice')]/following::select[3]")));
			 NumberofYears.selectByIndex(1);
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//button[@title='Submit']")).click();
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//b[contains(.,'Area of Practice')]/following::input[10]")).sendKeys(exdata.get(28).toString());
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//button[@title='Next']")).click();
			 
			 // Litigation Experience
			 
			 Thread.sleep(10000);
			 Select Area1 = new Select(driver.findElement(By.xpath(".//b[contains(.,'Litigation Experience')]/following::select[1]")));
			 Area1.selectByIndex(1);
			 
			 Thread.sleep(10000);
			 Select years = new Select(driver.findElement(By.xpath(".//b[contains(.,'Litigation Experience')]/following::select[2]")));
			 years.selectByIndex(1);
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//button[@title='Submit']")).click();
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//button[@title='Next']")).click();
			 
			 
			 // Public Interest Experience
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//b[contains(.,'Public Interest Experience')]/following::input[2]")).sendKeys(exdata.get(29).toString());
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//b[contains(.,'Public Interest Experience')]/following::input[4]")).sendKeys(exdata.get(30).toString());
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//b[contains(.,'Public Interest Experience')]/following::input[6]")).sendKeys(exdata.get(31).toString());
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//b[contains(.,'Public Interest Experience')]/following::input[8]")).sendKeys(exdata.get(32).toString());
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//b[contains(.,'Public Interest Experience')]/following::input[10]")).sendKeys(exdata.get(33).toString());
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//label[contains(.,'Comments')]/following::input[1]")).sendKeys(exdata.get(34).toString());
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//button[@title='Submit']")).click();
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//button[@title='Finish']")).click();		 
			 		 
			 
		 }
		 
		 
		 // Spiritual information Step 4
		 
		 @Test
		 @Parameters({"browser"})		 
		 public void SpiritualInformation(String browser) throws InterruptedException, IOException{
			 
			 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			 BasicConfigurator.configure();
			 
			Thread.sleep(10000);
			driver.findElement(By.xpath(".//b[contains(.,'Status')]/following::button[4]")).click();
				
				
			 DataUtils value2 = new DataUtils();
			 ArrayList exdata = value2.getdata("TC-001");
			 
			 // Spiritual Information﻿
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//b[contains(.,'Spiritual Information')]/following::input[1]")).sendKeys(exdata.get(35).toString());
			 
			 Thread.sleep(10000);
			 Select Denomination = new Select(driver.findElement(By.xpath(".//b[contains(.,'Spiritual Information')]/following::select[1]")));
			 Denomination.selectByIndex(2);
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//b[contains(.,'Spiritual Information')]/following::input[2]")).sendKeys(exdata.get(36).toString());
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//b[contains(.,'Spiritual Information')]/following::input[3]")).sendKeys(exdata.get(37).toString());
			 
			 Thread.sleep(10000);
			 Select  believeinJesus = new Select(driver.findElement(By.xpath(".//b[contains(.,'Spiritual Information')]/following::select[2]")));
			 believeinJesus.selectByIndex(1);
			 
			 Thread.sleep(10000);
			 Select historicsummary = new Select(driver.findElement(By.xpath(".//b[contains(.,'Spiritual Information')]/following::select[3]")));
			 historicsummary.selectByIndex(1);
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//div[contains(.,'Spiritual Information')]/following::textarea[1]")).sendKeys(exdata.get(38).toString());
			 
			 Thread.sleep(5000);
			 driver.findElement(By.xpath(".//button[@title='Finish']")).click();
		 }
		 
		 
		 
		// Attachments Step 5
		 
				 @Test
				 @Parameters({"browser"})		 
				 public void Attachments(String browser) throws InterruptedException, IOException{
					 
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					 BasicConfigurator.configure();
					 
					Thread.sleep(10000);
					driver.findElement(By.xpath(".//b[contains(.,'Status')]/following::button[5]")).click();
							 
					UploadFile uf = new UploadFile();
					
					 Thread.sleep(15000);
					 driver.findElement(By.xpath(".//b[contains(.,'Attachments')]/following::span[11]")).click();
					 
					 Thread.sleep(5000);
					 uf.uploadFileWithRobot("Receipt.pdf");
					
					 Thread.sleep(15000);
					 driver.findElement(By.xpath(".//b[contains(.,'Attachments')]/following::button[1]")).click();
					 
					 
					 Thread.sleep(15000);
					 driver.findElement(By.xpath(".//b[contains(.,'Attachments')]/following::span[18]")).click();
					 
					 Thread.sleep(5000);
					 uf.uploadFileWithRobot("Headshot.jpg");
					
					 Thread.sleep(10000);
					 driver.findElement(By.xpath(".//b[contains(.,'Attachments')]/following::button[2]")).click();
					 
					
					 Thread.sleep(10000);
					 driver.findElement(By.xpath(".//button[@title='Finish']")).click();
					 
				 }
		 
		 // Summary page step 6
				 
				 @Test
				 @Parameters({"browser"})		 
				 public void Sumarry(String browser) throws InterruptedException, IOException{
					 
					 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
					 BasicConfigurator.configure();
					 
					 Thread.sleep(10000);
					 driver.findElement(By.xpath(".//b[contains(.,'Status')]/following::button[6]")).click();
																		
					 Thread.sleep(10000);
					 driver.findElement(By.xpath(".//button[contains(.,'Next')]")).click();
					 
					 Thread.sleep(15000);
					 driver.findElement(By.xpath(".//input[@name='DisclaimerCheckBox']/following::label/span[1]")).click();
					 
					 Thread.sleep(5000);
					 driver.findElement(By.xpath(".//button[contains(.,'Submit')]")).click();
					 
				 }
		 
		 
}