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

	public class CustomerSubLinkPOM {
		
		
			private WebDriver driver; 
			
			public CustomerSubLinkPOM (WebDriver driver) { 
				this.driver = driver; 
				PageFactory.initElements(driver, this);
			}
			//path for Group name
			@FindBy(id="input-customer-group")
			private WebElement groupname;
			
			//path to select Group name from list
			
			@FindBy(xpath="//*[@id=\"input-customer-group\"]/option[42]")
			private WebElement groupvalue;
			
			
			//path to enter first name
			@FindBy(id="input-firstname")
			private WebElement firstname;
			
			//path to enter last name
			@FindBy(id="input-lastname")
			private WebElement lastname;
			
			//path to enter email
			@FindBy(id="input-email")
			private WebElement email;
			//path to enter telephone
			@FindBy(id="input-telephone")
			private WebElement telephone;
			//path to enter password
			@FindBy(id="input-password")
			private WebElement password;
			
			//path to enter confirm password
			@FindBy(id="input-confirm")
			private WebElement confirmpwd;
			
			//path for save button
			//@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
			//@FindBy(xpath="//button[@type='submit']")
			@FindBy(xpath="//i[@class='fa fa-save']")
			private WebElement save;
			
			@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]")
			private WebElement success;
			
			//---method for groupname 
			public void GroupName() {
				this.groupname.click();
				
			}
			
			
			public void GroupName1(String groupname) {
				//this.groupname.clear(); 
				this.groupname.sendKeys(groupname); 
				
				//this.groupname.click();
				
			}
			//---method for groupvalue 
			public void GroupValue() {
				Select s = new Select(groupname);
				s.selectByVisibleText("privileged customer");
				//s.selectByValue("119");
				
				//Thread.sleep(2000);
				System.out.println("Group name is selected");
				
			}
			//---method for firstname 
			public void FirstName(String firstname) {
				this.firstname.clear(); 
				this.firstname.sendKeys(firstname); 
			}
			//---method for lastname 
			public void LastName(String lastname) {
				this.lastname.clear(); 
				this.lastname.sendKeys(lastname); 
			}
			
			//---method for email 
			public void Email(String email) {
				this.email.clear(); 
				this.email.sendKeys(email); 
			}
			//---method for telephone
			public void Telephone(String telephone) {
				this.telephone.clear(); 
				this.telephone.sendKeys(telephone); 
			}
			//---method for password
			public void Password(String password) {
				this.password.clear(); 
				this.password.sendKeys(password); 
			}
			//---method for confirm password
			public void ConfirmPwd(String confirmpwd) throws InterruptedException {
				this.confirmpwd.clear(); 
				this.confirmpwd.sendKeys(confirmpwd); 
				
			}
			
		
			//------method for save button
			
			public void save() throws AWTException, InterruptedException {
				
				
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_PAGE_UP);
				robot.keyRelease(KeyEvent.VK_PAGE_UP);
				Thread.sleep(3000);
				Actions a = new Actions(driver);
			    a.moveToElement(save).click().build().perform();
			    
			    System.out.println("Test");
					
	}
			
			
			
			public String sucesstext() {
				return this.success.getText();	
			}
			
			//----------method for getvalues
			
	
			
			public String getfirstnamevalue()
			{
				return this.firstname.getAttribute("value");
			} 
			public String getlastnamevalue()
			{
				return this.lastname.getAttribute("value");
			} 
			public String getemailvalue()
			{
				return this.email.getAttribute("value");
			} 
			public String gettelephonevalue()
			{
				return this.telephone.getAttribute("value");
			} 
			public String getpasswordvalue()
			{
				return this.password.getAttribute("value");
			} 
			public String getconfirmpwdvalue()
			{
				return this.confirmpwd.getAttribute("value");
			} 
			
}
