package testBase;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OHC_AddStaff {
    WebDriverWait wait;
	WebDriver driver;
    
    // Driver is open
	@BeforeMethod
	public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new org.openqa.selenium.chrome.ChromeDriver();
        // Maximize window and set implicit wait
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			// Navigate to the login page
            driver.get("hhttps://ohcadmin.demotemple.com/");
            driver.findElement(By.xpath("//input[@id=':r3hr:']")).clear();
            driver.findElement(By.xpath("//input[@id=':r3hr:']")).sendKeys("ohcdev@yopmail.com");
            driver.findElement(By.xpath("//input[@id=':r3hs:']")).clear();
            driver.findElement(By.xpath("//input[@id='auth-login-v2-password']")).sendKeys("test@123");
            driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        
	}

	// driver is close 
	@AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }


    public void selectRandomDate()
    
    {
        List<WebElement> allDates = driver.findElements(
        By.xpath("//div[@role='rowgroup']//div[@class='MuiDayCalendar-weekContainer css-mvmu1r']//button"));
        Random random = new Random();
        int randomDate = random.nextInt(allDates.size());
        allDates.get(randomDate).click();

    }
    












    @Test
    public void addNewStaff()
    {
        driver.findElement(By.xpath(
                "//body/div[@id='__next']/div[contains(@class,'layout-wrapper css-uinsfl')]/div[contains(@class,'MuiDrawer-root MuiDrawer-docked layout-vertical-nav css-1e72eac')]/div[contains(@class,'MuiPaper-root MuiPaper-elevation MuiPaper-elevation0 MuiDrawer-paper MuiDrawer-paperAnchorLeft MuiDrawer-paperAnchorDockedLeft css-fijinl')]/div[contains(@class,'MuiBox-root css-ohwg9z')]/div[contains(@class,'scrollbar-container ps')]/ul[contains(@class,'MuiList-root MuiList-padding nav-items css-1ta9ch5')]/li[5]/a[1]")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Add New Staff']")).click();

    }

}
