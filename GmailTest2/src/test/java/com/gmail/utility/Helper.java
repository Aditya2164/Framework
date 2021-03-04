
package com.gmail.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	//Screenshots
	
	public static String  CaptureScreenshot(WebDriver driver)
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenShotPath = System.getProperty("user.dir")+"/Screenshots/"+ getCurrentDateTime() +".png";
		try {
			FileHandler.copy(src, new File(screenShotPath));
		} catch (IOException e) {
			System.out.println("Unable to Print SS "+e.getMessage());
		}
		
		return screenShotPath;
	}
	
	
	public static String getCurrentDateTime()
	{
		DateFormat format = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
	return format.format(currentDate);
	}
	
	public static void sendEmail() throws EmailException
	{
		Email email = new SimpleEmail();
		email.setHostName("smtp.googlemail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("username", "password"));
		email.setSSLOnConnect(true);
		email.setFrom("user@gmail.com");
		email.setSubject("TestMail");
		email.setMsg("This is a test mail ... :-)");
		email.addTo("foo@bar.com");
		email.send();
	}
	

}
