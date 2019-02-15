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

import com.training.dataproviders.CreateCustomerGroupwithInvalidDataProviders;
import com.training.dataproviders.CustomerGroupDataProviders;
	import com.training.generics.ScreenShot;
	import com.training.pom.CustomerGroupPOM;
	import com.training.pom.CustomerLinkPOM;
	import com.training.pom.CustomerSubLinkPOM;
	import com.training.pom.LoginPOM;
	import com.training.pom.RTTC_056_DiscountOnExistingProductPOM;
	import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;

	/*
	 * Author 					: Poonam Saxena
	 * Test Case ID 			: RTTC_088
	 * Test Case Description 	: To verify whether application displays error message upion entering invalid details while creating user
	 * Precondition				: 1. user should have launched the application & placed the order
	 *
	 *							  2. admin should launch the application by entering valid URL
	 *
	 *						  	  3. Login as admin
	 */
	
	
	
	public class RTTC_088_CustomerCreateGroupWithInvaliddataTest {

		private WebDriver driver;
		private String baseUrl;
		private LoginPOM loginPOM;
		private CustomerLinkPOM customerLinkPOM;
		private CustomerSubLinkPOM customerSubLinkPOM;
		private CustomerGroupPOM createGroupPOM;
		private static Properties properties;
		private ScreenShot screenShot;
		
		
		
		public RTTC_088_CustomerCreateGroupWithInvaliddataTest() {
		}
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
			customerLinkPOM = new CustomerLinkPOM(driver);
			customerSubLinkPOM = new CustomerSubLinkPOM(driver);
			createGroupPOM = new CustomerGroupPOM(driver);
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
		
		//test to read and upload the data from excel sheet to customer group and customers page
		@Test(priority=2, dataProvider = "Testdata" , dataProviderClass= CreateCustomerGroupwithInvalidDataProviders.class)
		
		public void CreateGroupTest(String GroupName,String Description,String CustomerGroup,String FirstName,String LastName,String Email,String Telephone,String Password,String ConfirmPassword) throws InterruptedException, AWTException {
		customerLinkPOM.customer();
		customerLinkPOM.customerGroup();
		createGroupPOM.addNew();
		Thread.sleep(3000);
		createGroupPOM.customerGroupName(GroupName);
		createGroupPOM.description(Description);
		createGroupPOM.approver();
		createGroupPOM.save();
		customerLinkPOM.customer();//clicking on customer menu
		customerLinkPOM.customersublink();//clicking on customers sublink
		createGroupPOM.addNew(); //clicking on add new button
		Thread.sleep(3000);
		customerSubLinkPOM.GroupName();//clicking on group name 
		Thread.sleep(3000);
		customerSubLinkPOM.GroupValue();//selecting group value
		Thread.sleep(3000);
		customerSubLinkPOM.FirstName(FirstName);//entering first name
		customerSubLinkPOM.LastName(LastName);//entering last name
		customerSubLinkPOM.Email(Email);//entering email
		customerSubLinkPOM.Telephone(Telephone);//entering telephone
		customerSubLinkPOM.Password(Password);//entering password
		customerSubLinkPOM.ConfirmPwd(ConfirmPassword);//entering confirm password
		customerSubLinkPOM.save();//clicking on save button
		}
		@Test(priority=3)
		//assertion for editing existing product discount 
		public void assertTest() {
		String actual = customerSubLinkPOM.sucesstext();
		String expected = "Warning: Please check the form carefully for errors!";
		boolean st = actual.contains(expected);
		assertTrue(st);
		         
        System.out.println("Warning: Please check the form carefully for errors!");
		
		screenShot.captureScreenShot("Warning screenshot");
	}

		
	}	
		
		


