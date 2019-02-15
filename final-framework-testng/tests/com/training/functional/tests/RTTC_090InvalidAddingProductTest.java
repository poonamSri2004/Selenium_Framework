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
import com.training.dataproviders.CustomerGroupDataProviders;
import com.training.dataproviders.DBAddproductDataprovider;
import com.training.generics.ScreenShot;
		import com.training.pom.LoginPOM;
import com.training.pom.RTTC_056_DiscountOnExistingProductPOM;
import com.training.pom.RTTC_057_Retail_AddProductDiscountPOM;

import com.training.pom.RTTC_090InvalidAddingProductPOM;
		import com.training.utility.DriverFactory;
		import com.training.utility.DriverNames;

		/*
		 * Author 					: Poonam Saxena
		 * Test Case ID 			: RTTC_090
		 * Test Case Description 	: To verify whether application displays error message upon entering invalid details while adding product with reward points
		 * Precondition				: 1. user should launch the application by entering valid URL

		 *							  2. Login as admin
		 */
		
		public class RTTC_090InvalidAddingProductTest {

			private WebDriver driver;
			private String baseUrl;
			private LoginPOM loginPOM;
			private RTTC_090InvalidAddingProductPOM creategroup;
			private RTTC_056_DiscountOnExistingProductPOM discountProduct;
			private RTTC_057_Retail_AddProductDiscountPOM prodiscount;
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
				prodiscount= new RTTC_057_Retail_AddProductDiscountPOM(driver);
				discountProduct = new RTTC_056_DiscountOnExistingProductPOM(driver);
				creategroup = new RTTC_090InvalidAddingProductPOM(driver);
				baseUrl = properties.getProperty("baseURL");
				screenShot = new ScreenShot(driver); 
				// open the browser 
				driver.get(baseUrl);
			}
			@Test(priority=1)
			public void validLoginTest() throws InterruptedException, AWTException {
			loginPOM.sendUserName("admin");//entering user name
			loginPOM.sendPassword("admin@123");
			loginPOM.clickLoginBtn();
			Thread.sleep(3000);
			}	
			
			@Test(priority=2, dataProvider = "Testdata" , dataProviderClass= DBAddproductDataprovider.class)
			
			 
			public void validTest(String ProductName,String MetaTitle,String Model,String Price,String Category,String Quantity,String Price1,String Points) throws InterruptedException, AWTException {
				discountProduct.catelog();//clicking on catalog
				discountProduct.categories();//clicking on catalog->categories
				Thread.sleep(3000);
				discountProduct.product();//clicking on product
				prodiscount.addnew();//clicking on add new button
				
				prodiscount.proname(ProductName);//entering product name

				prodiscount.metatagTitle(MetaTitle);//entering meta tag title
				discountProduct.data();//clicking on data tab
				prodiscount.model(Model);//entering model detail
				prodiscount.price(Price);//entering price
				Thread.sleep(2000);
				//discountProduct.quantity("50");//entering quantity
				prodiscount.link();//clicking on link tab
				Thread.sleep(2000);
				prodiscount.category();//clicking on category
				Thread.sleep(2000);
				prodiscount.categoryvalue();//selecting category value
				Thread.sleep(2000);	
			
			
				//@Test(priority = 1) 
				//public void validDiscountTest() throws InterruptedException, AWTException{
				prodiscount.Discount();//clicking on discount tab
				Thread.sleep(2000);
				prodiscount.addDiscount();//clicking on add discount button
				Thread.sleep(2000);
				prodiscount.disQTY(Quantity);//entering on discount quantity
				prodiscount.price1(Price1);////entering on discount price
				prodiscount.cal();//clicking on cal icon
				Thread.sleep(2000);
				prodiscount.calvalue();//selecting date value
				
				prodiscount.endCal();//clicking on end cal icon
				Thread.sleep(2000);
				prodiscount.calNextvalue();//clicking on end cal date
				Thread.sleep(2000);
				prodiscount.rewardpoint();
				prodiscount.points(Points);
				prodiscount.submit();//submitting the record
				
							
			}
			
			
			@Test(priority = 3)
			
			//assertion for error message
				public void assertTest() throws InterruptedException {
				
				String Expected = "Warning: Please check the form carefully for errors!";
				
				
				String Actual = prodiscount.asserttext();
		 //System.out.println(); 
			Assert.assertTrue(Actual.contains(Expected));
		 //assertEquals(Actual, Expected);
		 System.out.println("Warning: Please check the form carefully for errors!");
		 screenShot.captureScreenShot("TC090 error code");
				
		}
}
