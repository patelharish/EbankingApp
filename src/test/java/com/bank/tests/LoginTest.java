package com.bank.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bank.pageObjects.LoginPage;

public class LoginTest extends BaseClass {

    @Test(priority = 1)
    public void loginWithValidCredentials() {
         driver.get(baseURL);   
         log.info("URL is opened...");
         LoginPage lp = new LoginPage(driver);
         lp.setUserName(username);
         log.info("Entered username...");
         lp.setPassword(password);
         log.info("Entered password...");
         lp.clickSubmit();
         log.info("Submit Button clicked ...");
         
         String actualTitle = driver.getTitle();         
         String expectedTitle = "Guru99 Bank Manager HomePage";
         Assert.assertEquals(actualTitle, expectedTitle);
         log.info("User logged in successfully...");
         
         //another way to verify assertion
         if(driver.getTitle().equals(expectedTitle)) {
        	 Assert.assertTrue(true);
         }else {
        	 Assert.assertFalse(false);
         }
    }
    
    @Test(priority = 2)
    public void loginWithInvalidCredentials() throws InterruptedException {
    	driver.get(baseURL); 
    	log.info("Again URL opened...");
        LoginPage lp2 = new LoginPage(driver);
        lp2.setPassword(invusername);
        log.info("Entered invalid Username...");
        lp2.setPassword(invpassword);
        log.info("Entered invalid Password...");
        lp2.clickSubmit();
        log.info("Submit Button clicked...");              
    }
}
