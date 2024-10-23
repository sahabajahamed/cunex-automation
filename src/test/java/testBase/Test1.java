package testBase;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
 WebDriver driver;

	// Driver is open
	@BeforeMethod
	public void setup() {
	try {
		  ChromeOptions options = new ChromeOptions();
	        Map<String, Object> prefs = new HashMap<>();

	        // Disable notifications permission pop-up
	        prefs.put("profile.default_content_setting_values.notifications", 2);
	      

	        // Set these preferences into ChromeOptions
	        options.setExperimentalOption("prefs", prefs);

	      
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver(options);

	        // Maximize window and set implicit wait
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	        // Navigate to the login page
	        driver.get("https://staging.groundmetrx.com/");
	       
		}
		catch (Exception e) {
	e.printStackTrace();
	}
	}
	
	// driver is close 
	@AfterMethod
	public void teardown()
	{
		if (driver!= null)
		{
			driver.quit();
		}
	}
	
	
	@Test
	public void timedasbordPerform()
	{	 driver.findElement(By.xpath("//input[@placeholder='Enter your username'")).sendKeys("Cunex Inc");
    	driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Thenewpasswordiscunex@362");
    	driver.findElement(By.xpath("//button[@class='btn full-btn']")).click();
		driver.findElement(By.xpath("//a[@id='step-human-resources']")).click();
		driver.findElement(By.xpath("//a[@id='arrow-time-dashboard']")).clear();
		
	}
}
