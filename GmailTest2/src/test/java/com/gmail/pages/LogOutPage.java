package com.gmail.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutPage {
		
     	@FindBy(xpath="//img[@class = \"gb_Ia gbii\"]")
		private WebElement profile;
     	
    	@FindBy(linkText="Sign out")
    	private WebElement logOutLnk;
    	
    	@FindBy(xpath = "//div[contains(text(),'Use another account')]")
    	private WebElement useAnotherAcct;
		
		
		public void logOut() throws InterruptedException{
			profile.click();
			Thread.sleep(3000);
			logOutLnk.click();
			Thread.sleep(2000);
			useAnotherAcct.click();
			Thread.sleep(2000);
		}

	}





