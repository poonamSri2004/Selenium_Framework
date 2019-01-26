package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Retail_LogoutPOM {
	private WebDriver driver; 
	
	public Retail_LogoutPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;
	
	//@FindBy(xpath="//i[@class='fa fa-sign-out fa-lg']")
	//private WebElement logoutBtn; 
	
	
	@FindBy(xpath="//span[@class='hidden-xs hidden-sm hidden-md']")
	private WebElement logoutBtn; 
	
	
	
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	public void clickLogoutBtn() {
		this.logoutBtn.click(); 
	}

	/*
	public SessionId getSessionID() {
		System.out.println(driver);
		SessionId SessionID = null;
		return SessionID;
	
	}
	*/
	
}


