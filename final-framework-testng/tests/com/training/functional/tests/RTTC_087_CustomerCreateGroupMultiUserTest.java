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
	 * Test Case ID 			: RTTC_087
	 * Test Case Description 	: To verify whether application allows admin to create a group & register multiple user to the group
	 * Precondition				: 1. user should have launched the application & placed the order
	 *
	 *						  	  2. admin should launch the application by entering valid URL
	 *
	 *						  	  3. Login as admin
	 */
	
	public class RTTC_087_CustomerCreateGroupMultiUserTest {

		private WebDriver driver;
		private String baseUrl;
		private LoginPOM loginPOM;
		private CustomerLinkPOM customerLinkPOM;
		private CustomerSubLinkPOM customerSubLinkPOM;
		private CustomerGroupPOM createGroupPOM;
		private static Properties properties;
		private ScreenShot screenShot;

		
		public RTTC_087_CustomerCreateGroupMultiUserTest() {
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
		
		
		//reading the data from excel sheet for creating multiple user
		
		@Test(priority=2, dataProvider = "Testdata" , dataProviderClass= CustomerGroupDataProviders.class)
		
		public void CreateGroupTest(String GroupName,String Description,String CustomerGroup,String FirstName,String LastName,String Email,String Telephone,String Password,String ConfirmPassword) throws InterruptedException, AWTException {
		customerLinkPOM.customer();//clicking on customer link
		customerLinkPOM.customerGroup();//clicking on customer->customerGroup link
		createGroupPOM.addNew();//clicking on add new button
		Thread.sleep(3000);
		createGroupPOM.customerGroupName(GroupName);//entering Group Name value
		createGroupPOM.description(Description);//entering description 
		createGroupPOM.approver();//clicking on approver 
		createGroupPOM.save();//clicking on save button
		customerLinkPOM.customer();//clicking on customer link
		customerLinkPOM.customersublink();//clicking on customer->customers link
		createGroupPOM.addNew();//clicking on add new button
		Thread.sleep(3000);
		customerSubLinkPOM.GroupName1(CustomerGroup);//clicking on group name
		Thread.sleep(3000);
		//customerSubLinkPOM.GroupValue1(CustomerGroup);//selecting group value
		//Thread.sleep(3000);
		customerSubLinkPOM.FirstName(FirstName);//entering first name
		customerSubLinkPOM.LastName(LastName);//entering last name
		customerSubLinkPOM.Email(Email);//entering email 
		customerSubLinkPOM.Telephone(Telephone);//entering phone number
		customerSubLinkPOM.Password(Password);//entering password
		customerSubLinkPOM.ConfirmPwd(ConfirmPassword);//entering confirm password
		//createGroupPOM.save();
		customerSubLinkPOM.save();//clicking on save
		}	
		
		@Test(priority=3)
		//assertion for editing existing product discount 
		public void assertTest() {
		String actual = createGroupPOM.sucesstext();
		String expected = "Success: You have modified customers!";
		boolean st = actual.contains(expected);
		assertTrue(st);
		         
	    System.out.println("Success: You have modified customers!");
		
		screenShot.captureScreenShot("created group");
			}
	}	
		
		


