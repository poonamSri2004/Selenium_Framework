package com.training.functional.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.Retail_LogoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;


public class TC_29_Retail_Logout {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	public Retail_LogoutPOM retail_logout;
	private static Properties properties;
	private ScreenShot screenShot;
	private String Actual,Expected;



	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@Test(priority=0)

	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		retail_logout = new Retail_LogoutPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		
		
		// open the browser 
		driver.get(baseUrl);
		
		System.out.println(driver.getTitle());
	}

	@Test(priority=1)
	public void validLoginTest() {
		
		loginPOM.sendUserName("admin");
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn(); 
		//retail_logout.clickLogoutBtn(); 
		
		
		screenShot.captureScreenShot("First");
	}


	@Test(priority=2)
	public void validLogoutTest() throws Exception {
		Thread.sleep(5000);		
		System.out.println("logout");
		retail_logout.clickLogoutBtn(); 
		System.out.println("system");
		System.out.println(driver.getCurrentUrl());
		
			Actual = driver.getTitle();
		System.out.println("test");
			
         Expected = "Administration";
        assertEquals(Actual,Expected);
        System.out.println("Correct");
		
		
		screenShot.captureScreenShot("First");
		
	}


	
	
	@AfterClass
	public void tearDown() throws Exception {
		
    
		
		
		
		
		driver.quit();
		
}



	}




