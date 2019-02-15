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

	public class CatalogPOM { 
		
		
			private WebDriver driver; 
			
			 public CatalogPOM (WebDriver driver) {
				this.driver = driver; 
				PageFactory.initElements(driver, this);
			}
			 
			//path to click on catalog->category
				
				@FindBy(xpath="//li[@id='menu-catalog']")
				private WebElement catalog;
				
				@FindBy(xpath="//a[contains(text(),'Categories')]")
				private WebElement category; 
				
				//path to navigate on catalog->category->product screen
				
				@FindBy(xpath="//*[@id=\"menu-catalog\"]/ul/li[2]/a")
				
				private WebElement product;
						
						
				public void catelog() {
					this.catalog.click();
							}
				
				public void categories() {
					
					Actions action = new Actions(driver);
					action.moveToElement(category).build().perform();
					
				}
				
				public void product() {
					Actions action = new Actions(driver);
					action.moveToElement(product).click().build().perform();
				}
				
	}
				