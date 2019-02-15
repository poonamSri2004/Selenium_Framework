package com.training.functional.tests;


		import static org.testng.Assert.assertTrue;

		import java.awt.AWTException;
		import java.awt.Robot;
		import java.awt.event.KeyEvent;
		import java.io.FileInputStream;
		import java.io.IOException;
		import java.util.Properties;
		import org.testng.annotations.DataProvider; //Data Provider
		import org.openqa.selenium.WebDriver;
		import org.testng.Assert;
		import org.testng.annotations.AfterClass;
		import org.testng.annotations.AfterMethod;
		import org.testng.annotations.BeforeClass;
		import org.testng.annotations.BeforeMethod;
		import org.testng.annotations.Test;
		import com.training.dao.RetailDAO2;
import com.training.dataproviders.LoginDataProviders;
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
		 * Test Case ID 			: RTTC_086
		 * Test Case Description 	: To verify whether application allows admin to create a group & register user to the group & getting stored in datbase
		 * Precondition				: 1. user should have launched the application & placed the order
		 *
	     *					 		  2. admin should launch the application by entering valid URL
	     *
		 *							 3. Login as admin
		 *
		 *						
		 */
		
		
		
		public class RTTC_086_CustomerCreateGroupDBTest {
			

			private WebDriver driver;
			private String baseUrl;
			private LoginPOM loginPOM;
			private CustomerLinkPOM customerLinkPOM;
			private CustomerSubLinkPOM customerSubLinkPOM;
			private CustomerGroupPOM createGroupPOM;
			private static Properties properties;
			private ScreenShot screenShot;
			private String screenfirstname;
			private String screenlastname;
			private String screenmail;
			private String screenphone;
			private String screenpwd;
			private String screenconfirmpwd;
			
			

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
			
			
			@Test(priority=2)//This test is entering values on customer->customer group and saving the entered values.
			public void CreateGroupTest() throws InterruptedException, AWTException {
			customerLinkPOM.customer();
			customerLinkPOM.customerGroup();
			createGroupPOM.addNew();
			Thread.sleep(3000);
			createGroupPOM.customerGroupName("privileged customer");
			createGroupPOM.description("privileged customer");
			createGroupPOM.approver();
			createGroupPOM.save();
			}	
			@Test(priority=3)
			//assertion for customer group 
			public void assertTest() {
			String actual = createGroupPOM.sucesstext();
			String expected = "Success: You have modified customer groups!";
			boolean st = actual.contains(expected);
			assertTrue(st);
			         
	        System.out.println("Assertion 1 is Correct");
			
			screenShot.captureScreenShot("TC86_assertion1");
		}
			
			//test to enter the value in customers screen and comparing the values from database
			
			@Test(priority =4, dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
		    public void loginDBTest(String FName, String LName,String mail, String PNumber,String pwd,String confirmpwd) throws InterruptedException, AWTException {
			
				customerLinkPOM.customer();
				customerLinkPOM.customersublink();
				createGroupPOM.addNew();
				Thread.sleep(3000);
				customerSubLinkPOM.GroupName();
				Thread.sleep(3000);
				customerSubLinkPOM.GroupValue();
				Thread.sleep(3000);
				customerSubLinkPOM.FirstName("manzoor");
				
				
				screenfirstname = customerSubLinkPOM.getfirstnamevalue();
				System.out.println("name value is " + screenfirstname);
						
									
				customerSubLinkPOM.LastName("mehadi");
				screenlastname = customerSubLinkPOM.getlastnamevalue();
				System.out.println("name value is " + screenlastname);
				
				customerSubLinkPOM.Email("abcde@xyz.com");
				screenmail = customerSubLinkPOM.getemailvalue();
				System.out.println("name value is " + screenmail);
				
				
				customerSubLinkPOM.Telephone("9876543210");
				screenphone = customerSubLinkPOM.gettelephonevalue();
				System.out.println("name value is " + screenphone);
				
				customerSubLinkPOM.Password("manzoor1");
				screenpwd = customerSubLinkPOM.getpasswordvalue();
				System.out.println("name value is " + screenpwd);
				
				customerSubLinkPOM.ConfirmPwd("manzoor1");
				screenconfirmpwd = customerSubLinkPOM.getconfirmpwdvalue();
				System.out.println("name value is " + screenconfirmpwd);
				
				//saving the entered values in customers page
				customerSubLinkPOM.save();
				//assertions to compare the entered value from database
				 Assert.assertEquals(screenfirstname, FName);
		        Assert.assertEquals(screenlastname, LName);
		        Assert.assertEquals(screenmail, mail);
		        Assert.assertEquals(screenphone, PNumber);
		        Assert.assertEquals(screenpwd, pwd);
		        Assert.assertEquals(screenconfirmpwd, confirmpwd);
				
				
				//assertion to check the successfully saves data
				
				String actual = createGroupPOM.sucesstext();
				String expected = "Success: You have modified customers!";
				boolean st = actual.contains(expected);
				assertTrue(st);
				         
		        System.out.println("Success: You have modified customers!");
				
				screenShot.captureScreenShot("TC86_Assertion2");
						
			}
			
			
}
