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
	import com.training.pom.RTTC_89POM;
import com.training.pom.Report_CustomerPOM;
import com.training.pom.SalesPOM;
import com.training.generics.ScreenShot;
	import com.training.pom.LoginPOM;
	import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;

	/*
	 * Author 					: Poonam Saxena
	 * Test Case ID 			: RTTC_056
	 * Test Case Description 	: To verify whether application allows user to place an order as guest user & admin to change order order status as complete
	 * Precondition				: 1. user should launch the application by entering valid URL

	 *						
	 */
	
	
	
	public class RTTC_089_CustomerCreateOrderTest {
		

		private WebDriver driver;
		private String baseUrl2;
		private LoginPOM loginPOM;
		private RTTC_89POM createOrder;
		private SalesPOM salesPOM;
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
			createOrder = new RTTC_89POM(driver);
			salesPOM = new SalesPOM(driver);
			baseUrl2 = properties.getProperty("baseURL2");
			screenShot = new ScreenShot(driver); 
			// open the browser 
			driver.get(baseUrl2);
		}
		
		/*
		@Test(priority=1)
		public void validLoginTest() throws InterruptedException, AWTException {
		createOrder.sendUserName("poonam.saxena2004@gmail.com");//entering user name
		createOrder.sendPassword("poonam");//entering password
		createOrder.clickLoginBtn(); 
		Thread.sleep(3000);
		}	
		
		*/
	@Test(priority=2)
		public void ProductTest() throws InterruptedException, AWTException {
		
		createOrder.shopnow();
		createOrder.productEthnic();
		createOrder.productname();
		createOrder.addToCart();
		createOrder.cartitem();
		//createOrder.viewCart();
		createOrder.checkout();
		//createOrder.registercheckout();
		createOrder.continuebtn();
		createOrder.firstname("Poonam");
		createOrder.lastName("Saxena");
		createOrder.Email("test32@gmail.com");
		createOrder.Telephone("9810020900");
		createOrder.Address1("ABC");
		createOrder.City("Delhi");
		createOrder.postalcode("110062");
		createOrder.Country();
		createOrder.countryvalue();
		createOrder.StateClick();
		createOrder.State1();
		//createOrder.CheckboxPayment();
		//createOrder.continuebtn1();
		createOrder.paymentpassword("poonam");
		createOrder.paymentConfirmPwd("poonam");
		
		createOrder.policyPayment();
		createOrder.continuebtn2();
		
		createOrder.continuebtn3();
		createOrder.Comment("Test");
		
		createOrder.continuebtn3();
		createOrder.CheckboxTC();
		
		createOrder.continuebtn4();
		createOrder.confirmOrder();
		
	}
	
	@Test(priority=3)
	//assertion for editing existing product discount 
	public void assertTest() {
	String actual = createOrder.sucesspagemsg();
	String expected = "Your order has been placed!";
	boolean st = actual.contains(expected);
	assertTrue(st);
	         
    System.out.println("Correct");
	
	screenShot.captureScreenShot("OrderPlaced");
		}
	@Test(priority=4)
	public void saleTest() throws InterruptedException, AWTException {
	createOrder.adminurl();
	loginPOM.sendUserName("admin");	
	loginPOM.sendPassword("admin@123");	
	loginPOM.clickLoginBtn();
	salesPOM.SalesMenu();
	salesPOM.Order();
	salesPOM.viewicon();
	salesPOM.OrderStatus();
	salesPOM.OrderstatusVal();
	salesPOM.AddHistory();
	
	}
	
	/*
	@Test(priority = 5)
	
	//assertion for error message
		public void assertTest1() throws InterruptedException {
		
		String Expected = " Success: You have modified orders!";
		
		
		String Actual = createOrder.asserttext1();
 //System.out.println(); 
	Assert.assertTrue(Actual.contains(Expected));
 //assertEquals(Actual, Expected);
 System.out.println(" Success: You have modified orders!");
 screenShot.captureScreenShot("TC089 success");
		
}

	*/
}