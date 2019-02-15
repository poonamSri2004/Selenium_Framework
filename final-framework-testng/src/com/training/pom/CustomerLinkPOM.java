package com.training.pom;

	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.Calendar;
	import java.util.Date;
	import java.util.List;
	import java.util.TimeZone;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class CustomerLinkPOM { 
		
		
			private WebDriver driver; 
			
			public CustomerLinkPOM(WebDriver driver) {
				this.driver = driver; 
				PageFactory.initElements(driver, this);
			}
			




			//path to click on customer main icon
			
			

		@FindBy(xpath="//li[@id='menu-customer']//a[@class='parent']")
		private WebElement customers;
		
		//path for customer link
		@FindBy(xpath="//*[@id=\"menu-customer\"]/ul/li[1]/a")
		private WebElement customersublink;
		
		//path for customer link
		
		@FindBy(xpath="//*[@id=\"menu-customer\"]/ul/li[2]/a")
		private WebElement customerGroup; 
		
		
				
				public void customer() {
					this.customers.click();
							}
					
				public void customerGroup() {
					
					Actions action = new Actions(driver);
					action.moveToElement(customerGroup).click().perform();
					
				}
				public void customersublink() {
					
					Actions action = new Actions(driver);
					action.moveToElement(customersublink).click().perform();
					
				}
		
	}	
		
		
		
		
		