package com.training.functional.tests;

	import static org.testng.Assert.assertEquals;
	import static org.testng.Assert.assertTrue;

	import java.awt.AWTException;
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
	import com.training.pom.RTTC_058_AddCouponDiscountPOM;
	import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;

	/*
	 * Author 					: Poonam Saxena
	 * Test Case ID 			: RTTC_058
	 * Test Case Description 	: TO verify whether application allows admin to add discount to the product
	 * Precondition				: 1. user should launch the application by entering valid URL
	 *
	 *							  2. Login as admin
	 *							  3. Product is already added by the admin
	 *						
	 */
	
	
	public class RTTC_058_AddCouponDiscount_Test {

		private WebDriver driver;
		private String baseUrl;
		private LoginPOM loginPOM;
		private RTTC_058_AddCouponDiscountPOM coupon;
		private static Properties properties;
		private ScreenShot screenShot;

		@BeforeClass
		public static void setUpBeforeClass() throws IOException {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/others.properties");
			properties.load(inStream);
		}
		/*
		@AfterClass
		public void tearDown() throws Exception {
			Thread.sleep(1000);
			driver.quit();
		}
		
		*/

		@Test(priority=0)
		public void setUp() throws Exception {
			driver = DriverFactory.getDriver(DriverNames.CHROME);
			loginPOM = new LoginPOM(driver);
			coupon = new RTTC_058_AddCouponDiscountPOM(driver);
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
		}
		
		
		
		
		@Test(priority = 1) 
		public void validLoginTest() throws InterruptedException {
			loginPOM.sendUserName("admin");
			loginPOM.sendPassword("admin@123");
			loginPOM.clickLoginBtn(); 
			Thread.sleep(2000);
			
		}
		
		@Test(priority = 2) 
		
		public void couponDiscount() throws InterruptedException, AWTException{
			
			coupon.marketingicon();//clicking on marketing icon
			coupon.coupons();//clicking on marketing->coupon
			coupon.addnew();//clicking on add new button
			coupon.couponname("Christmas");//entering coupon name
			Thread.sleep(3000);
			coupon.couponcode("cse");//entering coupon code
			coupon.coupondiscount("10");//entering discount value
			coupon.couponproduct();//clicking product 
			coupon.provalue();//selecting product value
			Thread.sleep(2000);
			coupon.cal();//clicking on calendar icon
			coupon.calvalue();//selecting calendar value
			Thread.sleep(2000);
			coupon.endCal();//clicking on end date calendar icon
			coupon.calNextvalue();//selecting end date calendar value
			Thread.sleep(2000);
			coupon.save();//saving the record
					
			screenShot.captureScreenShot("coupon discount");
		}
		
		@Test(priority = 3) 
		//checking assertion for added coupons
		public void assertionCoupon1() throws InterruptedException{
			
			String Expected = "Success: You have modified coupons!";
			
					String Actual = coupon.sucesstext();
			 //System.out.println(); 
				Assert.assertTrue(Actual.contains(Expected));
			 //assertEquals(Actual, Expected);
			 System.out.println("Success: You have modified coupons!");
			 screenShot.captureScreenShot("Coupon assertion1");
		}	 		
		
		@Test(priority = 4) 
		//checking assertion for added discount value
		public void assertionCoupon2() throws InterruptedException{
		String Expected1 = "10.0000";
		
		String Actual1 = coupon.asserttext();
		//System.out.println(); 
		assertEquals(Actual1, Expected1);
		//boolean st = Actual1.contains(Expected1);
		//assertTrue(st);
		 System.out.println("matched : 10.0000");
		screenShot.captureScreenShot("Coupon assertion2");	

				
	}
			
			
	}		
		
	




