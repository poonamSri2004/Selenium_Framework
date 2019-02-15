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

public class CustomerGroupPOM {
	
	
		private WebDriver driver; 
		
		public CustomerGroupPOM (WebDriver driver) { 
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
			//path for addnew button
				@FindBy(xpath="//i[@class='fa fa-plus']")
				private WebElement addNew;
				
				//path for Customer Group Name
				@FindBy(xpath="//input[@placeholder='Customer Group Name']")
				private WebElement customerGroupName;
				
				//path for description
				
				@FindBy(xpath="//textarea[@id='input-description1']")
				private WebElement description;
				
				//path for radio button yes
				
				@FindBy(xpath="//input[@value='1']")
				private WebElement approve;
				
				
				//path for save button
				@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
				private WebElement save;
				
				
				//---method for add new button
				public void addNew() {
					this.addNew.click();
							}
				
				//---method for Customer Group Name
				public void customerGroupName(String customerGroupName) {
					this.customerGroupName.clear(); 
					this.customerGroupName.sendKeys(customerGroupName); 
				}
				//---method for description
				public void description(String description) {
					this.description.clear(); 
					this.description.sendKeys(description); 
				}
				
				//---method for approver
				public void approver() {
					this.approve.click(); 
					
				}
				
				//------method for save button
								
				public void save() throws AWTException, InterruptedException {
					
					
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_PAGE_UP);
					robot.keyRelease(KeyEvent.VK_PAGE_UP);
					
					driver.switchTo().defaultContent();
					Actions a = new Actions(driver);
				    a.moveToElement(save).click().perform();
				    Thread.sleep(2000);
				    
						
		}
				
				//path for assertion check
				@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]")
				private WebElement success;
				public String sucesstext() {
					return this.success.getText();	
				}
}		