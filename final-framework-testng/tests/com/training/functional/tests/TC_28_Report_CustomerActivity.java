package com.training.functional.tests;


	import org.testng.annotations.Test;

	import com.training.generics.ScreenShot;
	import com.training.pom.LoginPOM;
	import com.training.pom.Report_CustomerPOM;
	import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;

	import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	import org.openqa.selenium.NoSuchSessionException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.remote.UnreachableBrowserException;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;


	public class TC_28_Report_CustomerActivity {

		private WebDriver driver;
		private String baseUrl;
		private LoginPOM loginPOM;
		private Report_CustomerPOM report_customer;
		private static Properties properties;
		private ScreenShot screenShot;




		@BeforeClass
		public static void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
		}


		@Test(priority=0)
		
		

		public void setUp() throws Exception {
			WebDriver driver = DriverFactory.getDriver(DriverNames.CHROME);
			loginPOM = new LoginPOM(driver);
			report_customer = new Report_CustomerPOM(driver); 
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
		}

		@Test(priority=1)
		public void validLoginTest() throws InterruptedException {
			loginPOM.sendUserName("admin");
			loginPOM.sendPassword("admin@123");
			loginPOM.clickLoginBtn(); 
			report_customer.reportmenu(); 
			report_customer.reportcustomer();
			Thread.sleep(5000);
			report_customer.reportActivity();
			Thread.sleep(5000);
			
			
			report_customer.sendUserName("manzoor mehadi");
			report_customer.clickfilterBtn();
			
			 
			
			String actual = report_customer.customertext(); 
			String expected = "manzoor mehadi";
			boolean st = actual.contains(expected);
			assertTrue(st);
			
	         
	        System.out.println("Correct");
			
			screenShot.captureScreenShot("First");
		}

	
		

}
