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

	public class RTTC_059_Retail_AddAffiliatePOM {
		
		
			private WebDriver driver; 
			
			public RTTC_059_Retail_AddAffiliatePOM (WebDriver driver) {
				this.driver = driver; 
				PageFactory.initElements(driver, this);
			}
			// path for marketing menu
			@FindBy(xpath="//li[@id='menu-marketing']")
			private WebElement marketingMenu;
			@FindBy(xpath="//*[@id=\"menu-marketing\"]/ul/li[2]/a")
			private WebElement affiliate;
			public void marketingMenu(){
			this.marketingMenu.click();}
			public void affiliate() {
				
				Actions action = new Actions(driver);
				action.moveToElement(affiliate).click().build().perform();
				
			}
			//clicking on add new button
			@FindBy(xpath="//a[@class='btn btn-primary']")
			private WebElement addNew;
			public void addNew(){
				this.addNew.click();}
			
			//path to enter the FirstName
			@FindBy(id="input-firstname")
			private WebElement firstName;
			
			public void firstName(String firstName) {
				
				this.firstName.clear();
				this.firstName.sendKeys(firstName);
				}

			//path to enter the LastName
			@FindBy(id="input-lastname")
			private WebElement lastName;
			
			public void lastName(String lastName) {
				
				this.lastName.clear();
				this.lastName.sendKeys(lastName);
				}
			//path to enter the E-Mail 
			@FindBy(id="input-email")
			private WebElement email;
			
			public void email(String email) {
				
				this.email.clear();
				this.email.sendKeys(email);
				}
			//path to enter the Telephone 
			@FindBy(id="input-telephone")
			private WebElement telephone;
			
			public void telephone(String telephone) {
				
				this.telephone.clear();
				this.telephone.sendKeys(telephone);
				}
			//path to enter the password
			@FindBy(id="input-password")
			private WebElement password;
			
			public void password(String password) {
				
				this.password.clear();
				this.password.sendKeys(password);
				}
			//path to enter the confirmPassword
			@FindBy(id="input-confirm")
			private WebElement confirmPassword;
			
			public void confirmPassword(String confirmPassword) {
				
				this.confirmPassword.clear();
				this.confirmPassword.sendKeys(confirmPassword);
				}
			//path to enter the address1
			@FindBy(id="input-address-1")
			private WebElement address1;
			
			public void address1(String address1) {
				
				this.address1.clear();
				this.address1.sendKeys(address1);
				}
			//path to enter the address2
			@FindBy(id="input-address-2")
			private WebElement address2;
			
			public void address2(String address2) {
				
				this.address2.clear();
				this.address2.sendKeys(address2);
				}
			//path to enter the city
			@FindBy(id="input-city")
			private WebElement city;
			
			public void city(String city) {
				
				this.city.clear();
				this.city.sendKeys(city);
				}
			//path to enter the postcode
			@FindBy(id="input-postcode")
			private WebElement postcode;
			
			public void postcode(String postcode) {
				
				this.postcode.clear();
				this.postcode.sendKeys(postcode);
				}
			//path to enter the country
			@FindBy(id="input-country")
			private WebElement country;
			public void country() {
	
				this.country.click();
			}
				
			@FindBy(xpath="//option[@value='99']")
			private WebElement countryvalue;
			public void countryvalue() throws InterruptedException {
				Select s = new Select(country);
							
				s.selectByValue("99");
				
				//Thread.sleep(2000);
				System.out.println("india is selected");
				
				}
			//path to enter the State
			
			@FindBy(xpath="//select[@id='input-zone']")
			//@FindBy(xpath="//select[@id ='input-zone' and name='zone-id']")
			private WebElement State;
			
			public void StateClick() {
				System.out.println("state is clicking");
				this.State.click();
				System.out.println("state is clicked");
			}
			
			//@FindBy(xpath="//select[@id ='input-zone' and name='zone-id']")
			@FindBy(id="//*[@id=\"input-zone\"]/option[16]")
			private WebElement State1;
			public void State1() throws InterruptedException {
				
				Select s = new Select(State);
				s.selectByVisibleText("Karnataka");
				Thread.sleep(2000);
				}
				
			
			//path to enter the payment tab
			@FindBy(xpath="//a[contains(text(),'Payment Details')]")
			private WebElement paymentTab;
			
			public void paymentTab() throws AWTException, InterruptedException {
				Thread.sleep(2000);
				this.paymentTab.click();
				}
			//path to enter the Cheque Payee Name
			@FindBy(id="input-cheque")
			private WebElement payeeName;
			
			public void payeeName(String payeeName) throws AWTException {
				
				
				this.payeeName.clear();
				this.payeeName.sendKeys(payeeName);
				}
			//path to submit 
			
			@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
			private WebElement save;
			
			public void save() {
				
				this.save.click();
				
			}
			
			
			//path for assertion
			//@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]")
			@FindBy(xpath="//div[@class='alert alert-success']")
			private WebElement assertdiscount;
			public String asserttext() {
				String str2=assertdiscount.getText();
				System.out.println(str2);
				return str2;
			
}
			
	}
