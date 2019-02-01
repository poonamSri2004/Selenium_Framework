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

public class RTTC_056_DiscountOnExistingProductPOM {
	
	
		private WebDriver driver; 
		
		public RTTC_056_DiscountOnExistingProductPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		
		
		//path to click on catalog->category
		
		@FindBy(xpath="//li[@id='menu-catalog']")
		private WebElement catalog;
		
		@FindBy(xpath="//a[contains(text(),'Categories')]")
		private WebElement category; 
		
		
		public void catelog() {
			this.catalog.click();
					}
		
		
		
		public void categories() {
			
			Actions action = new Actions(driver);
			action.moveToElement(category).build().perform();
			
		}
		
		//path to navigate on catalog->category->product screen
		
		@FindBy(xpath="//*[@id=\"menu-catalog\"]/ul/li[2]/a")
		
		private WebElement product;
				
		public void product() {
			Actions action = new Actions(driver);
			action.moveToElement(product).click().build().perform();
		}
		
		//path to click on edit button on product screen
		
			@FindBy(xpath="//tbody//tr[1]//td[8]//a[1]//i[1]")
			private WebElement editBtn;
			
			public void clickEditBtn() {
				this.editBtn.click(); 
				
			}
			
			//path to click on data tab
		
			@FindBy(xpath="//a[contains(text(),'Data')]")
			private WebElement data;
			
			
			public void data() {
				this.data.click();
				
			}
			
			//path to enter the quantity in data tab
			@FindBy(name="quantity")
			private WebElement qtyname;
			
			public void quantity(String qtyname) {
				
				this.qtyname.clear();
				this.qtyname.sendKeys(qtyname);
				
			}
			
			//path to click on discount tab
			
			@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[7]/a")
			private WebElement discount;
			
			public void discount() {
				this.discount.click();
			
}
			//path to click on addDiscount button in discount tab
	
			@FindBy(xpath="//*[@id=\"discount\"]/tfoot/tr/td[2]/button")
			private WebElement addDiscount;
			public void addDiscount() {
				this.addDiscount.click();
			}
			//path to enter the quantity in discount tab
			@FindBy(name="product_discount[0][quantity]")
			private WebElement disQTY;
			public void disQTY(String disQTY) {
				this.disQTY.sendKeys(disQTY);
			}
		//path to enter the price in discount tab
			@FindBy(name="product_discount[0][price]")
			private WebElement price;
			public void price(String price) {
				
				this.price.sendKeys(price);
						
			}

			//path for cal button click

			@FindBy(xpath="//*[@id=\"discount-row0\"]/td[5]/div/span/button")
			private WebElement cal;
			public void cal() {
				//Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
				//Get Current Day as a number
			    //int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
			    //System.out.println("Today Int: " + todayInt +"\n");
			//System.out.println(calendar);
			this.cal.click();
			
	}
			
		//path to select the date 
			//@FindBy(className="picker-switch")
			@FindBy(xpath="/html/body/div[5]/div/div[1]/table/tbody/tr[1]/td[6]")
			private WebElement calvalue;
			public void calvalue() {
			//Actions action = new Actions(driver);
			//action.moveToElement(calvalue).click().perform();
			this.calvalue.click();
			}
			
	
			
			//path for end date cal click	
			@FindBy(xpath="//*[@id=\"discount-row0\"]/td[6]/div/span/button")
			private WebElement endCal;
			public void endCal() {
				this.endCal.click();
						}
			
		//path for next date select 	
			//@FindBy(xpath="/html/body/div[10]/div/div[1]/table/tbody/tr[1]/td[7]")
			@FindBy(xpath="/html/body/div[6]/div/div[1]/table/tbody/tr[1]/td[7]")
			private WebElement calNextvalue;
			public void calNextvalue() {
			
				
				/*
				DateFormat dateFormat = new SimpleDateFormat("yyyy/dd/MM");
				    Calendar cal = Calendar.calNextvalue;
				    cal.setTime(new Date());
				    cal.add(Calendar.DATE, 1);
				    String newDate = dateFormat.format(cal.getTime());
				*/
			
			
			
			Actions action = new Actions(driver);
			action.moveToElement(calNextvalue).click().perform();
			
			}

						
		//Xpath for save button
			
			
			@FindBy(xpath="//button[@type='submit']")
				private WebElement save;
			
			
			public void submit() throws AWTException {
						
				
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_PAGE_UP);
				robot.keyRelease(KeyEvent.VK_PAGE_UP);
				
				driver.switchTo().defaultContent();
				System.out.print("Test1");
				
				Actions a = new Actions(driver);
			       a.moveToElement(save).click().perform();
					
	}
			
			
				/*
				JavascriptExecutor js = (JavascriptExecutor) driver;  
				String Script = null;
				Object Arguments = null;
				js.executeScript(Script,Arguments);
				
				 js.executeScript("window.scrollBy(1000,0)");
				   
				   
				Actions action1 = new Actions(driver);
				action.sendKeys(Keys.PAGE_UP).perform();
				}

	*/
			
			
					//path for assertion check
			@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]")
			private WebElement success;
			public String sucesstext() {
				return this.success.getText();	
			}


}