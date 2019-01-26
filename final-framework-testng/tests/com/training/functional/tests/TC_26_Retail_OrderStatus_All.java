
package com.training.functional.tests;



import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.Retail_OrderStatus_AllPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import static org.testng.Assert.assertTrue;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;


public class TC_26_Retail_OrderStatus_All {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private Retail_OrderStatus_AllPOM retail_orerstatus;
	private static Properties properties;
	private ScreenShot screenShot;
	private String customername;
	String Actual,Expected;
	



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
		retail_orerstatus = new Retail_OrderStatus_AllPOM(driver);
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
		//retail_logout.clickLogoutBtn(); 
		screenShot.captureScreenShot("First");
		
		retail_orerstatus.reportmenu(); 
		retail_orerstatus.reportproduct();
		Thread.sleep(5000);
		retail_orerstatus.reportpurchased();
		
		Thread.sleep(5000);
		retail_orerstatus.selectorder(customername);
		retail_orerstatus.clickfilterBtn();
	
		 	
		 Actual = retail_orerstatus.filtervalue();
				
         Expected = "Diamond necklace";
         
       
		assertEquals(Actual,Expected);
         
		      
        	
	}


	
	/*

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		
    driver.quit();
}
*/
	

}
