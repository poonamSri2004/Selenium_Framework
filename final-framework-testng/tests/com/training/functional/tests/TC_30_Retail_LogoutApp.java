package com.training.functional.tests;



import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.LogoutAppPOM;
import com.training.pom.Retail_LogoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class TC_30_Retail_LogoutApp {


	private WebDriver driver;
	//private String baseUrl;
	private String baseURL2;
	private LogoutAppPOM logoutappPOM;
	private static Properties properties;
	private ScreenShot screenShot;


	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@Test(priority=0)

	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		//loginPOM = new LoginPOM(driver);
		logoutappPOM = new LogoutAppPOM(driver); 
		baseURL2 = properties.getProperty("baseURL2");
		screenShot = new ScreenShot(driver); 
		
		
		// open the browser 
		driver.get(baseURL2);
		
		System.out.println(driver.getTitle());
	}

	
	

	

	@Test(priority = 1)
	public void validLoginTest() throws InterruptedException {
		
		//LogoutAppPOM logoutappPOM = new LogoutAppPOM(driver);
		logoutappPOM.sendUserName("poonam.saxena2004@gmail.com");
		logoutappPOM.sendPassword("poonam");
		logoutappPOM.clickLoginBtn();
		logoutappPOM.usericon();
		Thread.sleep(3000);
		logoutappPOM.userlist1();
		//retail_logout.clickLogoutBtn(); 
		screenShot.captureScreenShot("First");
		
		
		
	}


	@Test(priority = 2)
	public void logout() throws InterruptedException {
		String Expected = "You have been logged off your account. It is now safe to leave the computer.";
		String Actual = logoutappPOM.AssertRole();
		System.out.println();
		assertEquals(Actual, Expected);
		System.out.println("Correct");
		screenShot.captureScreenShot("First");
	}




	@AfterClass
	public void tearDown() throws Exception {
		
		
    driver.quit();
    
  
	}
	

}


	



