package com.training.functional.tests;


	

	import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

	import com.training.generics.ScreenShot;
	import com.training.pom.LoginPOM;
import com.training.pom.RTTC_056_DiscountOnExistingProductPOM;
import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;

	public class RTTC_056_DiscountOnExistingProduct_Test {
		

		private WebDriver driver;
		private String baseUrl;
		private LoginPOM loginPOM;
		private RTTC_056_DiscountOnExistingProductPOM discountProduct;
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
			discountProduct = new RTTC_056_DiscountOnExistingProductPOM(driver);
			baseUrl = properties.getProperty("baseURL");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl);
		}
		
		@Test(priority=1)
			public void validLoginTest() throws InterruptedException, AWTException {
			loginPOM.sendUserName("admin");//entering user name
			loginPOM.sendPassword("admin@123");//entering password
			loginPOM.clickLoginBtn(); 
			Thread.sleep(3000);
			}	
		@Test(priority=2)
			public void ProductTest() throws InterruptedException, AWTException {
			discountProduct.catelog();
			discountProduct.categories();
			Thread.sleep(3000);
			discountProduct.product();//clicking on product link
			discountProduct.clickEditBtn();//clicking on edit button
			discountProduct.data();//clicking on data tab
			discountProduct.quantity("45");//updating quantity value
			Thread.sleep(2000);
			discountProduct.discount();
			discountProduct.addDiscount();//clicking on add discount button
			discountProduct.disQTY("1"); //entering quantity
			discountProduct.price("50"); //entering price 
			discountProduct.cal();//selecting start date calendar
			Thread.sleep(2000);
			discountProduct.calvalue();//selecting end date calendar value
			
			discountProduct.endCal();//selecting calendar
			Thread.sleep(2000);
			discountProduct.calNextvalue();//selecting end date value
			Thread.sleep(2000);
						
			discountProduct.submit();//clicking on save button
					
			screenShot.captureScreenShot("Edit discount");
			
			}
		
/*		
		@Test(priority=3)
			//assertion for editing existing product discount 
			public void assertTest() {
			String actual = discountProduct.sucesstext();
			String expected = "Success: You have modified products!";
			boolean st = actual.contains(expected);
			assertTrue(st);
			         
	        System.out.println("Correct");
			
			screenShot.captureScreenShot("ExistingProductDiscount");
		}
*/
		}
	


