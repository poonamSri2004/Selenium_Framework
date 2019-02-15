package com.training.pom;



	import java.awt.AWTException;
	import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.text.DateFormat;
	import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

	public class RTTC_89POM {
		
		
			private WebDriver driver; 
			
			public RTTC_89POM(WebDriver driver) {
				this.driver = driver; 
				PageFactory.initElements(driver, this);
			}
			
			
			@FindBy(xpath="//input[@id='input-payment-password']")
			private WebElement paymentpassword;
			@FindBy(xpath="//input[@id='input-payment-confirm']")
			private WebElement paymentConfirmPwd;
			
			//path to click product
			@FindBy(xpath="//span[contains(text(),'Shop Now')]")
			private WebElement shopnow;
			
			@FindBy(xpath="//span[contains(text(),'Ethnic')]")
			private WebElement ethnic;
			
			//path to click product name
			@FindBy(xpath="//*[@id=\"ProductsSystem_QQI8r357\"]/div[1]/div[3]/div/div[3]/div/div/div[1]/h4/a")
			
			private WebElement productname;
			
			
			//path to click add to cart 
			//@FindBy(id="button-cart")
			
			@FindBy(xpath="//*[@id=\"button-cart\"]")
			//@FindBy(xpath="//button[contains(text(),'Add to Cart')]")
			private WebElement addToCart;
			
			//path to click cart item
			
			//@FindBy(xpath="//*[@id=\"cart\"]/ul/li/h3/a/i")
			@FindBy(xpath="//i[@class='tb_icon ico-linea-ecommerce-bag']")
			private WebElement cartitem;
			
			//path to view cart
			
			@FindBy(xpath="//a[contains(text(),'View Cart')]")
			private WebElement viewCart;
			
			//path to checkout button
			
			@FindBy(xpath="//*[@id=\"System_V2Exp1o9\"]/div[3]/div[2]/a")
			private WebElement checkout;
			
			//path for register checkout
			
			@FindBy(xpath="//input[@value='register']")
			private WebElement registercheckout;  
			
			@FindBy(xpath="//input[@value='guest']")
			private WebElement guestcheckout;
			
			//path for continue button on register page
			@FindBy(xpath="//*[@id=\"button-account\"]")
			private WebElement continuebtn;
			
			
			//path for first name 
			@FindBy(id="input-payment-firstname")
			private WebElement firstname;
			
			//path for last name 
			@FindBy(id="input-payment-lastname")
			private WebElement lastname;
			
			//path for email
			@FindBy(id="input-payment-email")
			private WebElement email;
			
			//path for telephone 
			@FindBy(id="input-payment-telephone")
			private WebElement telephone;
			
			//path for address1
			@FindBy(id="input-payment-address-1")
			private WebElement address1;
			
			//path for city
			@FindBy(id="input-payment-city")
			private WebElement city;
			
			//path for country
			@FindBy(id="input-payment-country")
			private WebElement country;
		
			//path for country value
			@FindBy(xpath="//option[@value='99']")
			private WebElement countryvalue;
			
			
			//path for State
			@FindBy(xpath="//select[@id='input-payment-zone']")
			//@FindBy(xpath="//select[@id ='input-zone' and name='zone-id']")
			private WebElement State;
			
			//path for State value
			@FindBy(xpath="//option[@value='1486']")
			private WebElement State1;
			
			
			//path for postal code
			@FindBy(xpath="//input[@id='input-payment-postcode']")
			private WebElement postalcode;
			
			//path for policy check
			@FindBy(xpath="//*[@id=\"collapse-payment-address\"]/div/div[2]/div[1]/label/input")
			private WebElement policycheckbox;
			
			/*
			@FindBy(xpath="//input[@id='button-payment-address']")
			private WebElement continuebtn;

			@FindBy(xpath="//input[@id='button-shipping-address']")
			private WebElement shipcontinuebtn; 

			@FindBy(xpath="//*[@id=\"button-shipping-address\"]")
			private WebElement continuebtn3;

			@FindBy(xpath="//input[@id='button-shipping-method']")
			private WebElement shipmethodcontinuebtn; 

			@FindBy(xpath="//input[@id='button-payment-method']")
			private WebElement continueafterchkbox;
			*/
			
			//path for continue button on register page after enter user details
			@FindBy(xpath="//input[@id='button-register']")
			private WebElement continuebtn2;
			
			//path and method for clicking on continue button after entering user details
			//@FindBy(id="button-shipping-address")
			@FindBy(xpath="//input[@id='button-shipping-method']")
			//@FindBy(css="input#button-shipping-address")
			private WebElement continuebtn3;
			//path for continue button after 
			//@FindBy(xpath="//input[@id='button-shipping-method']")
			
			//private WebElement continuebtn3;
			//path for continue button on payment page
			@FindBy(css="input#button-payment-method")
			//@FindBy(xpath="//*[@id=\"button-payment-method\"]")
			private WebElement continueshippingbtn4;
				
			public void shopnow () throws InterruptedException {
				
				Thread.sleep(5000);
				System.out.println("test");
				//this.shopnow.click();
				Actions action = new Actions(driver);
				action.clickAndHold(shopnow).build().perform();
				 this.ethnic.click();
				 action.moveToElement(shopnow).release();
				 
				 System.out.println("product selected");
				//action.moveToElement(shopnow).click().perform();
				//this.usericon.click().perform();
				
							
			}
			
			
			
			public void productEthnic() throws InterruptedException {
				//this.report.clear();
				Thread.sleep(5000);
				System.out.println("test1");
				Actions action = new Actions(driver);
				action.moveToElement(ethnic).click().perform();
			}
			
			
			public void productname() throws InterruptedException {
				//this.productname.click();
				
				Thread.sleep(3000);
				((JavascriptExecutor) driver).executeScript("window.open()");
				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));
				driver.switchTo().activeElement();
				driver.get("http://retail.hommelle.com/home");
				}
			
			
			
			public void addToCart() throws InterruptedException {
				this.addToCart.click();
				//Actions action = new Actions(driver);
				//action.moveToElement(addToCart).click().perform();
				Thread.sleep(3000);
			}
			
			public void cartitem () throws InterruptedException {
				
				Thread.sleep(3000);
				Actions action = new Actions(driver);
				action.clickAndHold(cartitem).build().perform();
				this.viewCart.click();
				 action.moveToElement(cartitem).release();
				 
				 System.out.println("view product");
				Thread.sleep(3000);
			}
			
			/*
			public void viewCart() throws InterruptedException {
							Actions action = new Actions(driver);
				action.moveToElement(viewCart).click().perform();
				Thread.sleep(5000);
			}
			*/
			public void checkout() throws InterruptedException {
				this.checkout.click();
				Thread.sleep(3000);
			}
			
			public void registercheckout() throws InterruptedException {
				this.registercheckout.click();
				Thread.sleep(3000);
			}
			public void guestcheckout() throws InterruptedException {
				this.guestcheckout.click();
				Thread.sleep(3000);
			}
			public void continuebtn() throws AWTException {
				
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_DOWN);
				robot.keyRelease(KeyEvent.VK_DOWN);
				
				//driver.switchTo().defaultContent();
				System.out.print("Test1");
				
				Actions a = new Actions(driver);
			       a.moveToElement(continuebtn).click().perform();
			}
			
			public void firstname(String firstname) {
				//this.password.clear(); 
				this.firstname.sendKeys(firstname); 
			}
			public void lastName(String lastname) {
				//this.userName.clear();
				this.lastname.sendKeys(lastname);
			}
			
			public void Email(String email) {
				//this.userName.clear();
				this.email.sendKeys(email);
			}
			
			public void Telephone(String telephone) {
				//this.userName.clear();
				this.telephone.sendKeys(telephone);
			}
			
			public void Address1(String address1) {
				
				this.address1.sendKeys(address1);
			}
			
			public void City(String city) {
				
				this.city.sendKeys(city);
			}
			
			public void postalcode(String postalcode) {
				
				this.postalcode.sendKeys(postalcode);
			}
			
			public void Country() throws InterruptedException {
				this.country.click();
				Thread.sleep(3000);
			}
			
			public void countryvalue() throws InterruptedException {
				Select s = new Select(country);

				s.selectByValue("99");

				System.out.println("india is selected");

				}
			
			
			public void StateClick() {
				System.out.println("state is clicking");
				this.State.click();
				System.out.println("state is clicked");
			}
			
			//@FindBy(xpath="//select[@id ='input-zone' and name='zone-id']")
			
			
			public void State1() throws InterruptedException {
				
				Select s = new Select(State);
				s.selectByVisibleText("Delhi");
				Thread.sleep(2000);
				}
			
			public void paymentpassword(String paymentpassword) {
				//this.password.clear(); 
				this.paymentpassword.sendKeys(paymentpassword); 
			}
			
			public void paymentConfirmPwd(String paymentConfirmPwd) {
				//this.password.clear(); 
				this.paymentConfirmPwd.sendKeys(paymentConfirmPwd); 
			}
			//@FindBy(xpath="//label[@class='checkbox']//input[@value='1']")
			@FindBy(xpath="//*[@id=\"collapse-payment-address\"]/div/fieldset/div[3]/div[2]/label/input")
			private WebElement paymentcheckbox;
			
			public void CheckboxPayment() {
				
				this.paymentcheckbox.click();
				
			}
			//*[@id="button-guest"]
			
			
			public void policyPayment() {
				
				this.policycheckbox.click();
				
			}
			
			public void continuebtn2() throws AWTException {
				//Robot robot = new Robot();
				//robot.keyPress(KeyEvent.VK_DOWN);
				//robot.keyRelease(KeyEvent.VK_DOWN);
				
				
				//driver.switchTo().defaultContent();
				
				
				//Actions a = new Actions(driver);
			      // a.moveToElement(continuebtn2).click().perform();
				this.continuebtn2.click();
								
			}
			
			@FindBy(name="comment")
			private WebElement comment;
			
			public void Comment(String comment) {
				
				this.comment.sendKeys(comment);
			}
			
			
	
			public void continuebtn3() throws AWTException, InterruptedException {
				
				
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,-200)");
				continuebtn3.click();
				
				//driver.switchTo().defaultContent();
				//this.continuebtn3.click();
				
				//Actions a = new Actions(driver);
			    //a.moveToElement(continuebtn3).click().perform();
			}
			
			
			//path and method for term and condition on shipping page
			@FindBy(xpath="//*[@id=\"collapse-payment-method\"]/div/div[2]/div[1]/label/input")
			
			private WebElement checkboxTC;
			
			public void CheckboxTC() {
				
				this.checkboxTC.click();
				
			}
			
			
			//----method for continue button for 
			public void continuebtn4() throws AWTException {
				
						       this.continueshippingbtn4.click();
			}
			
			//path for confirm order 
			@FindBy(xpath="//*[@id=\"button-confirm\"]")
			private WebElement confirmOrder;
			//------method for confirm order
			public void confirmOrder() throws AWTException {
				
			       this.confirmOrder.click();
			}
			
			
			@FindBy(xpath="//*[@id=\"PageTitleSystem_B083XYxw\"]/h1")
			private WebElement pagemsg;
			public String sucesspagemsg() {
				return this.pagemsg.getText();
			
			}
			
			//--------method to open admin url in another tab
			public void adminurl() throws InterruptedException {
				//this.productname.click();
				
				Thread.sleep(3000);
				//((JavascriptExecutor) driver).executeScript("window.open()");
				//ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				//driver.switchTo().window(tabs.get(2));
				//driver.switchTo().activeElement();
				driver.get("http://retail.hommelle.com/admin");
				}
			
			//path and method for assertion 
			@FindBy(xpath="/html/body/div[1]/div/div[3]/div[3]/div[2]/div/div[1]/div[1]")
			private WebElement success;
			public String asserttext1() {
				String str2=success.getText();
				System.out.println(str2);
				return str2;
			
}
}