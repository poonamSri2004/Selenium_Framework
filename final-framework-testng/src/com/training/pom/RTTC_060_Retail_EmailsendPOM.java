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
import org.openqa.selenium.support.ui.Select;

	public class RTTC_060_Retail_EmailsendPOM {
		
		
			private WebDriver driver; 
			
			public RTTC_060_Retail_EmailsendPOM(WebDriver driver) {
				this.driver = driver; 
				PageFactory.initElements(driver, this);
			}
			
			
			
			//path to click on marketing icon
			
			@FindBy(xpath="//li[@id='menu-marketing']")
			private WebElement marketingMenu;
			
			public void marketingMenu(){
				this.marketingMenu.click();}
				
			//path to click on mail icon
			@FindBy(xpath="//a[contains(text(),'Mail')]")
			private WebElement mail;
			
			public void mail() {
				
				Actions action = new Actions(driver);
				action.moveToElement(mail).click().build().perform();
			}
			
			//path to select to value from drop down
			
			@FindBy(xpath="//select[@id='input-to']")
			private WebElement mailboxTo;
			@FindBy(xpath="//option[@value='customer_all']")
			private WebElement mailboxvalue;
			
			public void mailboxTo() {
				this.mailboxTo.click();
				Actions action = new Actions(driver);
				action.moveToElement(mailboxTo).click().build().perform();
			}
			public void mailboxvalue() throws InterruptedException {
				Select s = new Select(mailboxTo);
				s.selectByVisibleText("All Customers");
				Thread.sleep(2000);
			}
			
			//path to enter Subject textbox
			@FindBy(xpath="//input[@id='input-subject-1']")
			private WebElement subject;
			public void subject(String subject) {
				
				this.subject.sendKeys(subject);
				}
							
			//path to enter message testbox
			@FindBy(xpath="//div[@class='note-editable panel-body']")
			private WebElement message;
			public void message(String message) {
				
				this.message.sendKeys(message);
				}
			@FindBy(id="button-send")
			//@FindBy(xpath="//*[@id=\"button-send\"]")
			//@FindBy(xpath="//button[@id='button-send']")
			private WebElement send;
			public void send() {
				//Actions action = new Actions(driver);
				//action.moveToElement(send).click().build().perform();
				this.send.click();
				}
			//path for mail assertion 
			
			@FindBy(xpath="//div[@class='alert alert-success']")
			private WebElement assertmail;
			public String assertmail() {
				String str2=assertmail.getText();
				System.out.println(str2);
				return str2;
			
			}
			
			@FindBy(xpath="//option[@value='product']")
			private WebElement messageToProduct;
			public void messageToProduct() throws InterruptedException {
				Select s = new Select(mailboxTo);
				s.selectByVisibleText("Products");
				Thread.sleep(2000);
			}
			
			//path to enter Subject textbox
			@FindBy(xpath="//input[@id='input-subject-1']")
			private WebElement subject1;
			
					
			public void subject1(String subject1) {
				this.subject1.clear();
				this.subject1.sendKeys(subject1);
				}
			}

