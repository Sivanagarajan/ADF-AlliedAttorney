package HighlightElement;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;




public class HighlightElement {
	
		public static void highLightElement(WebDriver driver,WebElement element) throws InterruptedException{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.background='yellow'", element);
		TimeUnit.MILLISECONDS.sleep(500);
		js.executeScript("arguments[0].style.background=''", element);
	}
}
 

//static WebDriver driver = DriverFactory.getWebDriver()

//	@Keyword
//	public static void run(TestObject objectto) {
//		try {
//			WebElement element = WebUiCommonHelper.findWebElement(objectto, 20);
//			for (int i = 0; i < 5; i++) {
//				JavascriptExecutor js = (JavascriptExecutor) driver;
//				js.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');",
//						element);
//			}
//		} catch (Exception e) {
//			Assert.fail(e.getMessage());
//		}
//	}
//
//
//}
