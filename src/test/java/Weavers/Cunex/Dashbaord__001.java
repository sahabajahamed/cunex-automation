package Weavers.Cunex;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Dashbaord__001 {
	WebDriver driver;
	private WebDriverWait wait;
 
	
	
	@BeforeMethod
    public void setUp() {
    	  // Create ChromeOptions to handle browser permissions
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
        driver.findElement(By.xpath("//input[@placeholder='Enter your username']")).sendKeys("Cunex Inc."); 
        driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Thenewpasswordiscunex@362");
        driver.findElement(By.xpath("//button[@class='btn full-btn']")).sendKeys(Keys.RETURN);


}
	
	@AfterMethod
    public void tearDown()
    {
    	driver.quit();
    	
    }
	
	
	
	@Test
	public void dashbaordlink()
	{	
		WebElement dashboardline = driver.findElement(By.xpath("//a[@id='dropdowndDashboardMenuLink']"));
		dashboardline.click();
		List<WebElement> list = driver.findElements(By.xpath("//ul[@class='dropdown-menu p-d-dashboard-drop-box-wrapper dashboard-menu-col show']"));
		
		
		for (WebElement allPagelist : list)
		{
			String str = allPagelist.getText();
			String href = allPagelist.getAttribute("href");
			allPagelist.click();
			wait.until(ExpectedConditions.urlToBe(href));

//            // Verify the new page - can be done by checking URL or an element on the new page
//            String currentUrl = driver.getCurrentUrl();
//            System.out.println("Navigated to: " + currentUrl);
//            
//            try {
//                WebElement uniqueElement = driver.findElement(By.xpath("//h1")); // Replace with a unique element on the page
//                System.out.println("Verified page element: " + uniqueElement.getText());
//            } catch (Exception e) {
//                System.out.println("Failed to verify element on " + currentUrl);
//            }
//
//            // Navigate back to the main dashboard URL to continue with the next link
//            driver.navigate().to(str);
//
//            // After returning, wait for the dropdown to become visible again before clicking the next link
//            dashboardline.click();
//            wait.until(ExpectedConditions.visibilityOfAllElements(list));
//        }
			
		}
		}
}
		




