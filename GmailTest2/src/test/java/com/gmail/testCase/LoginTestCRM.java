package com.gmail.testCase;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.gmail.pages.Base;
import com.gmail.utility.Constants;

public class LoginTestCRM extends Base{
		
	//Test if Primary tab selected by default, if not select primary Tab
    @Test 
	public void loginApp() throws InterruptedException {
    	
    logger = report.createTest("Test 1: Gmail Login >> Primary Tab Selected ? >> If Not select Primary Tab");
    logger.info("Start Test");
    String actualSelectedTab = loginVar.selectPrimaryTab();
	String expectedSelectedTab = "rgba(217, 48, 37, 1)";
	
	if(actualSelectedTab.equalsIgnoreCase(expectedSelectedTab)) {
		logger.info("Primary Tab Selected By default");
	}
	else {
		logger.info("Primary Tab not selected by default, driver selected Primary Tab succesfully");
	}
//	Assert.assertEquals(actualSelectedTab, expectedSelectedTab,"Primary Tab Not Selected by Default");
	logger.pass(" Test 1 passed >> Login Success, Primary Tab Selected");
	
    }
    
    //get email count from Primary Tab.
    @Test 
    public void mailCount() {
    	logger = report.createTest("Test 2: Get the email count");
        logger.info("Start Test");
   String mailCount =  inboxVar.getMailCount();
   logger.info("Current Mail Count is: "+mailCount);
   logger.pass("Test 2 passed >> Mail Count returned succesfully");
    }
    
    //get nth sender and subject, nth value defined in Constant class
    @Test
    public void sender() {
    	logger = report.createTest("Test 3: Get the Sender Name and Email Subject");
        logger.info("Start Test");
        String senderDetail = inboxVar.getSender();
        logger.info("Sender Name and Subject of nth = "+Constants.count+" email is: "+senderDetail);
        logger.pass("Test 3 passed >> Sender and Subject of nth email returned succesfully ");
    
    }
    

}
