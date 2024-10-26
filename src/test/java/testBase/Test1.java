package testBase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
 WebDriver driver;
 WebDriver wait;

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
	
	
	@Test(priority=1)
	public void timedasbordPerform() throws InterruptedException, AWTException

	
	{	Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Thread.sleep(5000);
		// js.executeScript("document.body.style.zoom = '0.7';");
		Robot robot = new Robot();
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_SUBTRACT);
        robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		 robot.keyRelease(KeyEvent.VK_SUBTRACT);
		 robot.keyRelease(KeyEvent.VK_SUBTRACT);
        robot.keyRelease(KeyEvent.VK_CONTROL); 
		 driver.findElement(By.xpath("//input[@id='exampleInputUsername']")).sendKeys(" Cunex Inc.");
    	driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("Thenewpasswordiscunex@362");
		
		Thread.sleep(5000);
	
    	driver.findElement(By.xpath("//button[@class='btn full-btn']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='step-human-resources']")).click();
		 WebElement scrollableElement = driver.findElement(By.xpath("//div[@class='dashbord-left-menu-wraper blue-bg']"));
		
        js.executeScript("window.scrollBy(0,200)");
		js.executeScript("window.scrollBy(0,200);", scrollableElement);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='arrow-time-dashboard']")).click();
		Thread.sleep(5000);
		WebElement dropdown= driver.findElement(By.xpath("//select[@id='filter_paygroup']"));
		Select select= new Select(dropdown);
		Thread.sleep(5000);
		select.selectByVisibleText("Office");
		Thread.sleep(5000);
		 js.executeScript("document.body.style.zoom = '0.5';");

		 List<WebElement> ls= driver.findElements(By.xpath("//button[text()='Approve']"));

		 if (ls.isEmpty()) {
            System.out.println("No 'Approve' buttons found.");
        } else {
            for (WebElement button : ls) {
                button.click();

                String errorMessage = driver.findElement(By.id("swal2-html-container")).getText();

                if (errorMessage.contains("Please resolve those to continue.")) {
                    driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
					List<WebElement>driveLink=driver .findElements(By.xpath("//td[@class='sorting_1'] //a[@href]"));
					for (WebElement webElement : driveLink) {
						webElement.click();
						Thread.sleep(5000);
						driver.findElement(By.xpath("//div[@class='d-flex justify-content-end align-items-center mb-3']//button[@id='expand_btn']")).click();
						List<WebElement> markasNoCritical= driver .findElements(By.xpath("//button[@title='Mark as no critical']"));
							for (WebElement markNocritical : markasNoCritical) {
								markNocritical.click();
								select.selectByVisibleText("Incorrect Schedule");
								driver.findElement(By.id("no_critical_note")).sendKeys("exx");
								driver.findElement(By.xpath("//button[@class='custom_btn_sm mark_as_no_critical_btn']")).click();
								
							}

						driver.navigate().back();
					
						
					}
                } else if (errorMessage.contains("Non-Critical Exception")) {
                    driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled swal2-default-outline']")).click();
                } else if (errorMessage.contains("The data has been updated successfully.")) {
                    driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
                } else {
                    System.out.println("Unexpected error message: " + errorMessage);
                }
            }
			//button[normalize-space()='Ok']
			 
			
		 }
		
	}
}
