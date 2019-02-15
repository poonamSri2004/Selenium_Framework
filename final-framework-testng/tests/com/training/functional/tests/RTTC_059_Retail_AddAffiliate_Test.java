package com.training.functional.tests;


	import static org.testng.Assert.assertEquals;
	import static org.testng.Assert.assertTrue;

	import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import com.training.generics.ScreenShot;
	import com.training.pom.LoginPOM;
	import com.training.pom.RTTC_056_DiscountOnExistingProductPOM;
	import com.training.pom.RTTC_057_Retail_AddProductDiscountPOM;
	import com.training.pom.RTTC_058_AddCouponDiscountPOM;
import com.training.pom.RTTC_059_Retail_AddAffiliatePOM;
import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;


	/*
	 * Author 					: Poonam Saxena
	 * Test Case ID 			: RTTC_059
	 * Test Case Description 	: TO verify whether application allows admin to add affiliate
	 * Precondition				: 1. user should launch the application by entering valid URL
	 *
	 *							  2. Login as admin
	 *
	 *						
	 */
	
	
	public class RTTC_059_Retail_AddAffiliate_Test {
		private WebDriver driver;
		private String baseUrl;
		private LoginPOM loginPOM;
		private RTTC_058_AddCouponDiscountPOM coupon;
		private RTTC_059_Retail_AddAffiliatePOM addAffiliate;
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
			addAffiliate = new RTTC_059_Retail_AddAffiliatePOM(driver);
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
		}
		
		
	
		@Test(priority = 1) 
		public void validLoginTest() throws InterruptedException {
			loginPOM.sendUserName("admin");//enter user name
			loginPOM.sendPassword("admin@123");//enter password
			loginPOM.clickLoginBtn(); //clicking login button
			Thread.sleep(2000);
		}
			@Test(priority = 2)
			
			public void marketingMenuTest() throws InterruptedException, AWTException {
			addAffiliate.marketingMenu();//click on marketing menu
			addAffiliate.affiliate();//click on affiliate link
			addAffiliate.addNew();//clicking on add new button
			addAffiliate.firstName("manzoor");//entering first name
			addAffiliate.lastName("mehadi");//entering last name
			addAffiliate.email("manzoor@gmail.com");//entering email
			addAffiliate.telephone("9876543210");//entering phone number
			addAffiliate.password("manzoor1");//entering password
			Thread.sleep(2000);
			addAffiliate.confirmPassword("manzoor1");//entering confirm password
			addAffiliate.address1("yeshwanthapur");//entering add1
			addAffiliate.address2("bangalore");//entering add2
			addAffiliate.city("bangalore");//entering city
			addAffiliate.postcode("560022");//entering pin code
			addAffiliate.country();//selecting country
			//Thread.sleep(3000);
			addAffiliate.countryvalue();//selecting country value
			Thread.sleep(3000);
			addAffiliate.StateClick();//selecting state
			addAffiliate.State1();//selecting state value
			addAffiliate.paymentTab();//clicking on payment tab
			addAffiliate.payeeName("test");//entering payee name
			addAffiliate.save();//saving the record
			screenShot.captureScreenShot("SubmitRecord-Affiliate");
				}
			
			
			@Test(priority = 3)
			public void assertionTest() throws InterruptedException {
							
				String Expected = "Success: You have modified affiliates!";
				
				String Actual = addAffiliate.asserttext();
		 //System.out.println(); 
			Assert.assertTrue(Actual.contains(Expected));
		 //assertEquals(Actual, Expected);
		 System.out.println("Success: You have modified affiliates!");
		 screenShot.captureScreenShot("success");
			}
			
			
	}
	
