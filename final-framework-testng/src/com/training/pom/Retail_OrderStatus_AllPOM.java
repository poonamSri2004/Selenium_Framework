package com.training.pom;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Retail_OrderStatus_AllPOM {
	private WebDriver driver; 
	
	public Retail_OrderStatus_AllPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
		
		@FindBy(xpath="//i[@class='fa fa-bar-chart-o fw']")
		private WebElement report; 
		
		
		  @FindBy(xpath="//a[@class='parent'][contains(text(),'Products')]") 
		  private  WebElement product;
		 
		  @FindBy(xpath="//a[contains(text(),'Purchased')]") 
		  private WebElement purchased;

		  @FindBy(id="input-status")
			private WebElement status;
			
			@FindBy(id="button-filter")
			private WebElement filterBtn;
			
			 @FindBy(xpath="//td[contains(text(),'Diamond necklace')]") 
			  private WebElement value;
		 
			 
			 
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
			
			public void reportproduct() {
				//this.report.clear();
				//this.report.click();
				Actions action = new Actions(driver);
				action.moveToElement(product).build().perform();
				
			
	}
			public void reportpurchased() {
				//this.report.clear();
				this.product.click();
				Actions action = new Actions(driver);
				action.moveToElement(purchased).click().build().perform();
		
			}
			
			public void selectorder(String customername) {
				//this.status.clear();
				Select s = new Select(status);
				s.selectByIndex(0);
			}
			
			
			public void clickfilterBtn() {
				this.filterBtn.click(); 
			
			}
			
			
			public String filtervalue() {
				
			return this.value.getText();
			
	}
			}		
			
	

	
