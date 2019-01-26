package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Retail_CustomerOnlinePOM {
	
	
	private WebDriver driver;
	
	

	public Retail_CustomerOnlinePOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//i[@class='fa fa-bar-chart-o fw']")
	private WebElement report; 
	
	
	  @FindBy(xpath="//a[@class='parent'][contains(text(),'Customers')]") 
	  private  WebElement customer;
	 
	  @FindBy(xpath="//ul[@class='collapse in']//li[1]") 
	  private WebElement customeronline;

	  @FindBy(id="input-customer")
		private WebElement customername;
		
		@FindBy(id="button-filter")
		private WebElement filterBtn;
	
		//filtered value xpath
		@FindBy(xpath="//td[contains(text(),'Kaveri Waghmode')]")
		private WebElement fltvalue;
		
		//text value xpath
		@FindBy(xpath="//input[@id='input-customer']")
			private WebElement customervalue;
		
		public String customertext() {
			return this.fltvalue.getText();	
		}

		public String customerdetails() {
			return this.customervalue.getText();	
		}
	  public void reportmenu() {
			//this.report.clear();
			this.report.click();
			//Actions action = new Actions(driver);
			//action.moveToElement(customer).build().perform();
		
		//action.contextClick().perform();
		/*
		action.moveToElement(customer).perform();
		action.clickAndHold(customer).moveToElement(customerActivity).perform();
		this.report.click();
		*/
		
}
		
		public void reportcustomer() {
			//this.report.clear();
			//this.report.click();
			Actions action = new Actions(driver);
			action.moveToElement(customer).build().perform();
			
		
}
		public void reportOnline() {
			//this.report.clear();
			this.customer.click();
			Actions action = new Actions(driver);
			action.moveToElement(customeronline).click().build().perform();
	
		}
		
		public void sendUserName(String customername) {
			this.customername.clear();
			this.customername.sendKeys(customername);
		}
		
		public void clickfilterBtn() {
			this.filterBtn.click(); 
		
		
		
		
		
		
		}		
		
}


