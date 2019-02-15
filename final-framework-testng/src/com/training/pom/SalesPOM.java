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
import org.openqa.selenium.support.ui.Select;

public class SalesPOM {
	private WebDriver driver; 
	
	 public SalesPOM  (WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	 
	 
	//path to click on sales->Orders
		
		@FindBy(xpath="//li[@id='menu-sale']")
		private WebElement salesmenu;
		
		@FindBy(xpath="//*[@id=\"menu-sale\"]/ul/li[1]/a")
		private WebElement order; 
		
		@FindBy(xpath="//table//tbody/tr[1]/td[8]//i[@class=\"fa fa-eye\"]")
		private WebElement viewicon;
		
		
		//path for order status
		@FindBy(xpath="//select[@id='input-order-status']")	
		private WebElement orderstatus;
		
		//path for order status value
		@FindBy(xpath="//option[@value='5']")
		private WebElement OrderstatusVal;
		
		//path for button history
		
		@FindBy(xpath="//button[@id='button-history']")
		private WebElement addhistory;
		
		
		//---method for sales menu
		public void SalesMenu() {
			this.salesmenu.click();
					}
		
		//----method for sales-order
		public void Order() {
			
			Actions action = new Actions(driver);
			action.moveToElement(order).click().build().perform();
			
		}
		
		//-------method for view icon
		public void viewicon() {
			this.viewicon.click();
					}
		
		//----method for order status click
		public void OrderStatus() throws InterruptedException, AWTException {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			
			this.orderstatus.click();
			Thread.sleep(3000);
		}
		
		//-----method for order status value
		public void OrderstatusVal() throws InterruptedException {
			Select s = new Select(orderstatus);

			s.selectByValue("Complete");

			System.out.println("Complete is selected");

			}
		
		public void AddHistory() {
			this.addhistory.click();
					}
		
}
	 
	 
	 

