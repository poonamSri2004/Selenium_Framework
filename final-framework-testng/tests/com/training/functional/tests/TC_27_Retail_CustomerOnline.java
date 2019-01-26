package com.training.functional.tests;



	import org.testng.annotations.Test;

	import com.training.generics.ScreenShot;
	import com.training.pom.LoginPOM;
	import com.training.pom.Report_CustomerPOM;
	import com.training.pom.Retail_CustomerOnlinePOM;
	import com.training.pom.Retail_LogoutPOM;
	import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;

	import org.testng.annotations.BeforeMethod;

	import static org.testng.Assert.assertEquals;
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


	public class TC_27_Retail_CustomerOnline {

		private WebDriver driver;
		private String baseUrl;
		private LoginPOM loginPOM;
		private Retail_CustomerOnlinePOM report_customeronline;
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
			report_customeronline = new Retail_CustomerOnlinePOM(driver);
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
			report_customeronline.reportmenu(); 
			report_customeronline.reportcustomer();
			Thread.sleep(5000);
			report_customeronline.reportOnline();
			Thread.sleep(5000);
			
			
			report_customeronline.sendUserName("Kaveri Waghmode");
			report_customeronline.clickfilterBtn();
			
						
			String actual = report_customeronline.customertext();
			String expected = "Kaveri Waghmode";
			boolean st = actual.contains(expected);
			assertTrue(st);
			
	         
	        System.out.println("Correct");
			
			screenShot.captureScreenShot("First");
		}
		


	/*	
		
		@AfterClass
		public void tearDown() throws Exception {
			Thread.sleep(1000);
			
	    driver.quit();
	}
	
	*/	

}

