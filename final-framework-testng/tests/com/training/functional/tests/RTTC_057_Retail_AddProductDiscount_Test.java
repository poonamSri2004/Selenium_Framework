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
import com.training.pom.RTTC_056_DiscountOnExistingProductPOM;
import com.training.pom.RTTC_057_Retail_AddProductDiscountPOM;
import com.training.pom.RTTC_058_AddCouponDiscountPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;


public class RTTC_057_Retail_AddProductDiscount_Test {
	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private RTTC_058_AddCouponDiscountPOM coupon;
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
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(priority = 0)
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		discountProduct = new RTTC_056_DiscountOnExistingProductPOM(driver);
		prodiscount= new RTTC_057_Retail_AddProductDiscountPOM(driver);
		coupon = new RTTC_058_AddCouponDiscountPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@Test(priority = 1) 
	public void validLoginTest() throws InterruptedException {
		loginPOM.sendUserName("admin");//entering user name
		loginPOM.sendPassword("admin@123");//entering password
		loginPOM.clickLoginBtn(); 
		Thread.sleep(2000);
	}
	
	@Test(priority = 2) 
		
	public void addproduct() throws InterruptedException, AWTException {
		discountProduct.catelog();//clicking on catalog
		discountProduct.categories();//clicking on catalog->categories
		Thread.sleep(3000);
		discountProduct.product();//clicking on product
		prodiscount.addnew();//clicking on add new button
		
		prodiscount.proname("Finger Ring");//entering product name

		prodiscount.metatagTitle("Finger Ring for ladies");//entering meta tag title
		discountProduct.data();//clicking on data tab
		prodiscount.model("SKU-012");//entering model detail
		prodiscount.price("500");//entering price
		Thread.sleep(2000);
		discountProduct.quantity("50");//entering quantity
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
		prodiscount.disQTY("1");//entering on discount quantity
		prodiscount.price1("50");////entering on discount price
		prodiscount.cal();//clicking on cal icon
		Thread.sleep(2000);
		prodiscount.calvalue();//selecting date value
		
		prodiscount.endCal();//clicking on end cal icon
		Thread.sleep(2000);
		prodiscount.calNextvalue();//clicking on end cal date
		Thread.sleep(2000);
					
		prodiscount.submit();//submitting the record
	}
	
	@Test(priority = 3)
	
	//assertion for adding discount
		public void assertTest() throws InterruptedException {
		
		String Expected = "Success: You have modified products!";
		
		
		String Actual = coupon.sucesstext();
 //System.out.println(); 
	Assert.assertTrue(Actual.contains(Expected));
 //assertEquals(Actual, Expected);
 System.out.println("Success: You have modified products!");
 screenShot.captureScreenShot("TC057 product added");
		
}
	
}
