package com.training.functional.tests;


	

	import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import com.training.generics.ScreenShot;
	import com.training.pom.LoginPOM;
import com.training.pom.RTTC_056_DiscountOnExistingProductPOM;
import com.training.pom.RTTC_060_Retail_EmailsendPOM;
import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;


public class RTTC_060_Retail_Emailsend_Test { 
		

		private WebDriver driver;
		private String baseUrl;
		private LoginPOM loginPOM;
		private RTTC_060_Retail_EmailsendPOM mailbox;
		private static Properties properties;
		private ScreenShot screenShot;

		@BeforeClass
		public static void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
		}
		
		@AfterClass
		public void tearDown() throws Exception {
			Thread.sleep(1000);
			driver.quit();
		}

		@Test(priority=0)
		public void setUp() throws Exception {
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			loginPOM = new LoginPOM(driver);
			mailbox = new RTTC_060_Retail_EmailsendPOM(driver);
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
		}
		
			
		
		@Test(priority=1)
		public void validLoginTest() throws InterruptedException, AWTException {
			loginPOM.sendUserName("admin");//entering user name
			loginPOM.sendPassword("admin@123");//entering password
			loginPOM.clickLoginBtn(); //clicking on login button
			Thread.sleep(3000);
		}
		
		@Test(priority=2)
		public void marketingMenu() throws InterruptedException{
			mailbox.marketingMenu();//clicking menu link
			mailbox.mail();//clicking mail link
			mailbox.mailboxTo();//clicking on mailbox to
			mailbox.mailboxvalue();//selecting value for mail To
			mailbox.subject("Christmas wish");//entering subject
			mailbox.message("Christmas wish");//entering message
			mailbox.send();//clicking on send email button
			screenShot.captureScreenShot("send mail");
		}
			@Test(priority=3)
			//assertion for first email sent
			public void assertionMail1() throws InterruptedException{
			String Expected = "Your message has been successfully sent!";
			
			String Actual = mailbox.assertmail();
			//System.out.println(); 
			Assert.assertTrue(Actual.contains(Expected));
			//assertEquals(Actual, Expected);
			System.out.println("Your message has been successfully sent!");
			screenShot.captureScreenShot("Mail1");
			}
	 
			 @Test(priority=4)
			 //sending second email
			 public void sendMail2() throws InterruptedException {
			 Thread.sleep(2000);
			 mailbox.mailboxTo();
			 mailbox.messageToProduct();//selecting product value
			 mailbox.subject1("All Affiliates");	//entering subject
			 mailbox.message("");//passing message value same from previous method
			 mailbox.send();//clicking send email button
			 }
			 @Test(priority=5)
				//assertion for second email sent
				public void assertionMail2() throws InterruptedException{
				String Expected = "Your message has been successfully sent!";
				
				String Actual = mailbox.assertmail();
				//System.out.println(); 
				Assert.assertTrue(Actual.contains(Expected));
				//assertEquals(Actual, Expected);
				System.out.println("Your message has been successfully sent!");
				screenShot.captureScreenShot("Mail2");
				}
		}
	