package com.mst.automation.allied.listeners;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.mst.automation.allied.browserfactory.BrowserFactory;


public class listeners implements ITestListener {
	
	BrowserFactory bf = new BrowserFactory();
	
	public void onFinish(ITestContext result) {
		
		try {
			bf.getScreenShot(result.getName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
			
	}	

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		try {
			bf.getScreenShot(result.getName());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
