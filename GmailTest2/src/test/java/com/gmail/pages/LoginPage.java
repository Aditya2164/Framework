package com.gmail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.aventstack.extentreports.ExtentTest;

public class LoginPage {

	WebDriver  driver;
//	public ExtentTest logger;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	@FindBy(xpath = "//div[@class = 'lCoei YZVTmd SmR8' and @jsname = \"rwl3qc\"]")
//	@CacheLookup
	WebElement useAnother;
	
	@FindBy(xpath = "//input[@type = \"email\"]")
//	@CacheLookup
	WebElement userName;
	
	@FindBy(className = "VfPpkd-RLmnJb")
//  @FindBy(xpath = "//div[@class= \"VfPpkd-RLmnJb\"]")
//	@CacheLookup
	WebElement next;
	
	@FindBy(xpath = "//div[@id= 'password']//*[@name = 'password']")
//	@CacheLookup
	WebElement password;
	
//	@FindBy(how=How.CLASS_NAME,using= "ui fluid large blue submit button")
//	WebElement submit;
	
	@FindBy(xpath = "//button[@class = \"VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc qIypjc TrZEUc\"]")
//	@CacheLookup
	WebElement next2;
	
	@FindBy(xpath = "//img[@class ='gb_va']")
	WebElement gmailLogo;
	
	@FindBy(xpath = "//*[@id=\":23\"]")
	WebElement primaryTab;
	
	public void login(String uname, String pswd) throws InterruptedException {
		userName.sendKeys(uname);
		Thread.sleep(4000);
		next.click();
		Thread.sleep(4000);
		password.sendKeys(pswd);
		Thread.sleep(4000);
		next2.click();
		Thread.sleep(4000);
		boolean img = gmailLogo.isDisplayed();
		if (img) {
			System.out.println("Login SUccesful");
		}
		
		else {
			System.out.println("Login Failed");
		}
	}
		
	public String selectPrimaryTab() {
		String primaryTabSel = primaryTab.getCssValue("color");		
		String expectedSelectedTab = "rgba(217, 48, 37, 1)";
		
		if(primaryTabSel.equalsIgnoreCase(expectedSelectedTab)) {
			System.out.println("Primar TAB selected by Default");
			
		}
		else {
			primaryTab.click();
		}
		return primaryTabSel;

		
	}}
	

