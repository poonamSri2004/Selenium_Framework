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


public class RTTC_058_AddCouponDiscountPOM {
	private WebDriver driver; 


public RTTC_058_AddCouponDiscountPOM(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
}


//xpath for marketing->coupons icon

@FindBy(xpath="//*[@id=\"menu-marketing\"]/a/i")
private WebElement marketingicon;


@FindBy(xpath="//*[@id=\"menu-marketing\"]/ul/li[3]/a")
private WebElement coupons;


public void marketingicon() {
	this.marketingicon.click();
			}

public void coupons() {
	
	Actions action = new Actions(driver);
	action.moveToElement(coupons).click().build().perform();
	
}

//xpath for click add new button on coupons page

@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a/i")
private WebElement addnew;


public void addnew() {
	this.addnew.click();
			}

// Entering coupon name

@FindBy(id="input-name")
private WebElement couponname;

public void couponname(String couponname) {
	
	this.couponname.clear();
	this.couponname.sendKeys(couponname);
	
}

//Entering coupon code

@FindBy(name="code")
private WebElement couponcode;

public void couponcode(String couponcode) {
	
	this.couponcode.clear();
	this.couponcode.sendKeys(couponcode);
	
}

//Entering coupon discount

@FindBy(name="discount")
private WebElement coupondiscount;

public void coupondiscount(String coupondiscount) {
	
	this.coupondiscount.clear();
	this.coupondiscount.sendKeys(coupondiscount);
	
}

//clicking product

@FindBy(name="product")
private WebElement couponproduct;

public void couponproduct() {
	
	this.couponproduct.click();
		
}

//selecting product value

@FindBy(xpath="//*[@id=\"tab-general\"]/div[8]/div/ul/li[2]")
private WebElement provalue;

public void provalue() {
	Actions action = new Actions(driver);
	action.moveToElement(provalue).click().build().perform();
}
//selecting current date

@FindBy(xpath="//*[@id=\"tab-general\"]/div[10]/div/div/span/button")
private WebElement cal;
public void cal() {
this.cal.click();

}


@FindBy(xpath="/html/body/div[2]/div/div[1]/table/tbody/tr[5]/td[2]")
private WebElement calvalue;
public void calvalue() {
Actions action = new Actions(driver);
action.moveToElement(calvalue).click().build().perform();
//this.calvalue.click();
}

//selecting end date
@FindBy(xpath="//*[@id=\"tab-general\"]/div[11]/div/div/span/button")
private WebElement endCal;
public void endCal() {
	this.endCal.click();
			}

@FindBy(xpath="/html/body/div[3]/div/div[1]/table/tbody/tr[5]/td[6]")

private WebElement calNextvalue;
public void calNextvalue() {
	 	
Actions action = new Actions(driver);
action.moveToElement(calNextvalue).click().build().perform();
//this.calvalue.click();

//driver.switchTo().defaultContent();
}

// path to save record

@FindBy(xpath="//button[@type='submit']")

private WebElement save;

public void save() throws AWTException, InterruptedException {
	Robot robot = new Robot();
	robot.keyPress(KeyEvent.VK_PAGE_UP);
	robot.keyRelease(KeyEvent.VK_PAGE_UP);
	Thread.sleep(2000);
	//driver.switchTo().defaultContent();
	
	this.save.click();
	
				}


//path for success msg assertion
@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]")
//@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]/text()")
//@FindBy(xpath="//div[@class='alert alert-success']")
private WebElement success;

	public String sucesstext() {
		String str1=success.getText();
		System.out.println(str1);
		return str1;
	}
	
	//path for discount assertion 
	
	@FindBy(xpath="//*[@id=\"form-coupon\"]/div/table/tbody/tr[2]/td[4]")
	private WebElement assertdiscount;
	public String asserttext() {
		String str2=assertdiscount.getText();
		System.out.println(str2);
		return str2;
	
	}
}