package com.training.pom;


	

	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
	import java.util.Calendar;
	import java.util.Date;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.Keys;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class RTTC_057_Retail_AddProductDiscountPOM {
		
		
			private WebDriver driver; 
			
			public RTTC_057_Retail_AddProductDiscountPOM (WebDriver driver) {
				this.driver = driver; 
				PageFactory.initElements(driver, this);
			}

			//path to click on add new button
			@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a")
			private WebElement addnew;

			public void addnew(){

			this.addnew.click();

			}

			//path to enter product name
			@FindBy(id="input-name1")
			private WebElement productname;

			public void proname(String productname) {
							
			this.productname.sendKeys(productname);
			}

			//path to enter meta tag title
			@FindBy(id="input-meta-title1")
			private WebElement metaTagTitle;

			public void metatagTitle(String metaTagTitle) {
							
			this.metaTagTitle.sendKeys(metaTagTitle);
			}
			
			//path to enter model
			@FindBy(name="model")
			private WebElement model;

			public void model(String model) {
							
			this.model.sendKeys(model);
			}
			
			//path to enter price
			@FindBy(name="price")
			private WebElement price;

			public void price(String price) {
							
			this.price.sendKeys(price);
			}
			
			//path to click on link tab
			@FindBy(xpath="//a[contains(text(),'Links')]")
			private WebElement link;

			public void link(){

			this.link.click();

			}
			
			//path to click on category
			@FindBy(id="input-category")
			private WebElement category;
			@FindBy(xpath="//*[@id=\"tab-links\"]/div[2]/div/ul/li[1]/a")
			//@FindBy(xpath="//li[@data-value='456']")
			private WebElement val;

			public void category(){

			this.category.click();

			}
			//path to click on category value
			public void categoryvalue() {
						Actions action = new Actions(driver);
						action.moveToElement(val).click().build().perform();
						//this.val.click();
						}

			@FindBy(xpath="//a[contains(text(),'Discount')]")
			private WebElement Discount;
			
			public void Discount(){

				this.Discount.click();
				
				}		
			
			//path to click on discount tab
			@FindBy(xpath="//*[@id=\"discount\"]/tfoot/tr/td[2]/button")
			//@FindBy(xpath="//li[@data-value='456']")
			private WebElement addDiscount;
			
			public void addDiscount(){

			this.addDiscount.click();
			
			}	
			//----------------------------------
			//path to enter the quantity in discount tab
			@FindBy(name="product_discount[0][quantity]")
			private WebElement disQTY;
			public void disQTY(String disQTY) {
				this.disQTY.sendKeys(disQTY);
			}
		//path to enter the price in discount tab
			@FindBy(name="product_discount[0][price]")
			private WebElement price1;
			public void price1(String price1) {
				
				this.price1.sendKeys(price1);
						
			}

			//path for cal button click

			@FindBy(xpath="//tr[@id='discount-row0']//td[5]//div[1]//span[1]//button[1]")
			private WebElement cal;
			public void cal() {
			this.cal.click();
			
	}
			
		//path to select the date 
			@FindBy(xpath="/html/body/div[5]/div/div[1]/table/tbody/tr[5]/td[5]")
			private WebElement calvalue;
			public void calvalue() {
			Actions action = new Actions(driver);
			action.moveToElement(calvalue).click().build().perform();
			//this.calvalue.click();
			}
			
		//path for end date cal click	
			@FindBy(xpath="//*[@id=\"discount-row0\"]/td[6]/div/span/button/i")
			private WebElement endCal;
			public void endCal() {
				this.endCal.click();
						}
			
		//path for next date select 	
			@FindBy(xpath="/html/body/div[6]/div/div[1]/table/tbody/tr[5]/td[7]")
			
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
			action.moveToElement(calNextvalue).click().build().perform();
			
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
			
			@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]")
			private WebElement assertdiscount;
			public String asserttext() {
				String str2=assertdiscount.getText();
				System.out.println(str2);
				return str2;
			
			}		
			
}
