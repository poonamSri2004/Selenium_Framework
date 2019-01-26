import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseEvent {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\POONAMSAXENA\\eclipse-Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		Actions action = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath("//div[@class='padB10 lh1-2 iconText fmtTooltip']"));
		System.out.println(ele.getText());
		Thread.sleep(3000);
		action.contextClick().perform();
		Thread.sleep(15000);
		action.moveToElement(ele).perform();
		Thread.sleep(5000);
		action.moveByOffset(300,0).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(@class,'iconText')][contains(text(),'Cabs')]")).click();
		Thread.sleep(5000);
		//action.clickAndHold().moveToElement(ele).release().build().perform();
	}

}
