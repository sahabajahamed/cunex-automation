package testBase;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AnupamaScript {
    WebDriverWait wait;
    WebDriver driver;
   

    // Driver is open
    @BeforeMethod
    public void setup() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        // Maximize window and set implicit wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://blue-pebble.weavers-web.com/admin/login/");


        }
    
        @Test
        public void imageTest() throws InterruptedException {
            // Navigate to the login page
           
            driver.findElement(By.xpath("//input[@placeholder='Username or Email']")).sendKeys("Admin");
            driver.findElement(By.xpath("//input[@id='your-password']")).sendKeys("123456");
            driver.findElement(By.xpath("//input[@id='remeber']")).click();
            driver.findElement(By.xpath("//button[normalize-space()='Sign In']")).click();
            driver.findElement(By.xpath("(//ul[@class='sidebar-menu show']/li)[2]")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//a[normalize-space()='Add User']")).click();
            
    
            WebElement image = driver.findElement(By.xpath("//input[@id='imageUpload']/parent::div"));
            image.click();
            String imagepath = "/home/wadmin/Desktop/Cunex Automation (Github)/cunex-automation/src/test/java/data folder/391879.jpg";
            image.sendKeys(imagepath);


       
           

        }
    
    // driver is close 
	// @AfterMethod
    // public void teardown() {
    //     if (driver != null) {
    //         driver.quit();
    //     }
    // }
}

