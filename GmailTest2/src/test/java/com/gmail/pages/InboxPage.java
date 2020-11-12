package com.gmail.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gmail.utility.Constants;

public class InboxPage {

	WebDriver  driver;
	public void LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(xpath = "//*[@class=\"J-J5-Ji amH J-JN-I\"]/span/span[@class = \"ts\"]")
	WebElement countMailPrimaryTab;
	
	@FindBy(xpath = "//span[@class = 'bog']")
	List<WebElement> emailThread;
	
	@FindBy(xpath = "//span[@class = 'bog']//parent:: div//parent::div//parent::div//parent::td//parent::tr/td[@class = 'yX xY ']")
	List<WebElement> senderThread;
	
	public String getMailCount() {
		String count = countMailPrimaryTab.getText();
		System.out.println("Count of Email is: "+ count);
		return count;
	}
	
	public String getSender() {
		
		String senderSub = null ;
		String sender = null;

		int i = Constants.count;
		for(int j = 0; j<emailThread.size(); j++) {
			if(j == i) {
			 senderSub = emailThread.get(j).getText();
			 sender = senderThread.get(j).getText();
			System.out.println("Sender Subject of nth email: "+senderSub);
			System.out.println("Sender Name of nth email: "+sender);
			}
		}
		return "Sender Name = "+sender+"| Sender Subject = "+senderSub ;
		
	}
}

