package Demo;

import java.io.File;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Launch {

    public static WebDriver driver;

    public void launch() {

        // ChromeOptions options = new ChromeOptions();
        // File crx = new File("/home/wadmin/Desktop/Automation/undefined 4.1.0.0.crx");
        // options.addExtensions(crx);
        // driver = new ChromeDriver(options);

        // driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // driver.get("https://blue-pebble.weavers-web.com/admin/login");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "localhost:42337");
        driver = new ChromeDriver(options);
          driver.get("https://blue-pebble.weavers-web.com/admin/login/");
        driver.manage().window().maximize();

    }

    public static String randomstring() {
        String randomname = RandomStringUtils.randomAlphabetic(5);
        return randomname;
    }

    public static String randomnumber() {
        String randomphone = "91"+RandomStringUtils.randomNumeric(8);
        return randomphone;
    }

    public static String randomemail() {
        String randomemail = RandomStringUtils.randomAlphabetic(5) + "@gmail.com";
        return randomemail;
    }
    public static void windowhandle()
    {
        String mainWindow = driver.getWindowHandle();

// Open a new tab/window (assuming it opens another window)
driver.findElement(By.xpath("//a[@target='_blank']")).click();

// Get all window handles
Set<String> allWindows = driver.getWindowHandles();

for (String window : allWindows) {
    if (!window.equals(mainWindow)) {
        driver.switchTo().window(window);
        break;
    }
}

// Switch back to the main window
driver.switchTo().window(mainWindow);
    }
    JavascriptExecutor js = (JavascriptExecutor) driver;

}
