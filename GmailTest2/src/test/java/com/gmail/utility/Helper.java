
package com.gmail.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

}
