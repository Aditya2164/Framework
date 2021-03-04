package com.gmail.pages;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.gmail.utility.BrowserFactory;
import com.gmail.utility.Constants;
import com.gmail.utility.Helper;

public class Base {
	
	//Object declaration
public	WebDriver driver;
public	LoginPage loginVar;
public	InboxPage inboxVar;
public	LogOutPage logOut;
public ExtentReports report;
public ExtentTest logger;
   
   @BeforeSuite
   public void setUpSuite(){
	   ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/Gmail Test Report "+Helper.getCurrentDateTime()+".html"));
	   report = new ExtentReports();
	   report.attachReporter(extent);	   	   
   }

	@BeforeClass
	//Load 
	public void configBeforeClass(){
	driver = BrowserFactory.startApplication(driver, Constants.browser, Constants.url);
    loginVar = PageFactory.initElements(driver, LoginPage.class);
    inboxVar = PageFactory.initElements(driver, InboxPage.class);
    logOut = PageFactory.initElements(driver, LogOutPage.class);
	}
	
	@BeforeMethod
	public void configBeforeMtd() throws InterruptedException{
		System.out.println("Alert 0");
		String userNAme = Constants.userName;
		String password = Constants.password;
		loginVar.login(userNAme, password);
		System.out.println("Alert 1 login success");
		}
	
	@AfterMethod 
	public void configAfterMtd(ITestResult result) throws InterruptedException, IOException{
		System.out.println("After method starts");
		
		if(result.getStatus() == ITestResult.FAILURE) {
			//Helper.CaptureScreenshot(driver);            	
			logger.fail("Screen Print", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver)).build());
		}
		else if(result.getStatus() == ITestResult.SUCCESS) {
			logger.pass("Screen Print", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver)).build());
		}
		else if(result.getStatus() == ITestResult.SKIP) {
			logger.skip("Screen Print", MediaEntityBuilder.createScreenCaptureFromPath(Helper.CaptureScreenshot(driver)).build());
		}
		System.out.println("After method continues");
	report.flush();
	System.out.println("After method flush");
	logOut.logOut();
System.out.println("after method end");	
	
	}

	@AfterClass
	public void configAfterClass(){
		System.out.println("Alert 4 quit Browser");
	driver.quit();
}
}
