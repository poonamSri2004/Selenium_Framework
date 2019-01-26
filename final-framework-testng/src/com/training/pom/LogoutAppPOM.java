package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LogoutAppPOM {
	private WebDriver driver; 
	
	public LogoutAppPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn;
	
	//@FindBy(id="btn btn-primary")
	//private WebElement loginBtn; 
	
	@FindBy(xpath="//i[@class='fa fa-user-o']")
	
	
    
	//@FindBy(xpath="//div[@id='HeaderWelcomeSystem_ANSdB1kF']")
	//@FindBy(xpath="//span[@class='tb_text']")
	private WebElement usericon;
	@FindBy(xpath="//a[@href='http://retail.hommelle.com/account/logout']//span[@class='tb_text']")
	//----not working @FindBy(xpath="//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/ul/li[4]/a/span")
	//----------notworkng @FindBy(xpath="//i[@class='fa fa-sign-out']")
	//@FindBy(xpath="//span[contains(text(),'LOGOUT')]")
	
	//----------tried working but not clicking @FindBy(xpath="//li[@class='tb_link tb_menu_system_account_logout']")
	
			private WebElement userlogout;	
	
	//@FindBy(xpath="//ul[@class='dropdown-menu tb_list_1']")
	//private WebElement userlist;
	
	//@FindBy(xpath = "//*[@id='message']/p")
	
	@FindBy(xpath="//p[contains(text(),'You have been logged off your account. It is now s')]")
		private WebElement Usermsg;

	public String AssertRole() throws InterruptedException {
		Thread.sleep(3000);
		String str1 = Usermsg.getText();
		System.out.println(str1);
		return str1;
	}
	
	
	public void sendUserName(String userName) {
		//this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		//this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	public void usericon () throws InterruptedException {
		
		Thread.sleep(5000);
		System.out.println("test");
		Actions action = new Actions(driver);
		action.clickAndHold(usericon).build().perform();
		
		//action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'LOGOUT')]"))).click().perform();
		//this.usericon.click().perform();
		
		
		
	}
	
	

	public void userlist1() throws InterruptedException {
		//this.report.clear();
		Thread.sleep(3000);
		System.out.println("test1");
		Actions action = new Actions(driver);
		action.moveToElement(userlogout).click().build().perform();
		
		
	}
	
	
	
	
		
}