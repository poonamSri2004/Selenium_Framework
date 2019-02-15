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

public class RTTC_090InvalidAddingProductPOM {
		
		
			private WebDriver driver; 
			
			public RTTC_090InvalidAddingProductPOM(WebDriver driver) {
				this.driver = driver; 
				PageFactory.initElements(driver, this);
			}
			
			//xpath for assertion message
			@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]")
			private WebElement success;
			public String asserttext() {
				String str2=success.getText();
				System.out.println(str2);
				return str2;
			
			}		
}
