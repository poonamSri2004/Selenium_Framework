
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.training.utility.Driver;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
 

public class TurkishAirlinesDatePickerTest {
 
    static WebDriver driver;
    private String today;
 
    //Setup Driver
    @BeforeClass
    public static void setupTest() {
        System.setProperty(Driver.CHROME, Driver.CHROME_PATH);
		driver = new ChromeDriver(); 
        driver.navigate().to("http://www.turkishairlines.com/tr-tr/");
        driver.manage().window().maximize();
    }
 
    @Test
    public void datePickerTest() {
        //Declare a implicit wait for synchronisation
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
 
        //Get Today's number
        today = getCurrentDay();
        System.out.println("Today's number: " + today + "\n");
 
    }




//Get The Current Day
private String getCurrentDay(){
    //Create a Calendar Object
    Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

    //Get Current Day as a number
    int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
    System.out.println("Today Int: " + todayInt +"\n");

    //Integer to String Conversion
    String todayStr = Integer.toString(todayInt);
    System.out.println("Today Str: " + todayStr + "\n");

    return todayStr;
}

}
