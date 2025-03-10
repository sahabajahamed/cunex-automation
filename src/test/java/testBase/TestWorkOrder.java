package testBase;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
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

public class TestWorkOrder {
     private WebDriver driver;
    private WebDriverWait wait;
    private Random random = new Random();

    private static final String BASE_URL = "https://staging.groundmetrx.com/";
    private static final String MAINTENANCE_STEP_XPATH = "//a[@id='step-maintenance']";
    private static final String WORK_ORDERS_ARROW_XPATH = "//a[@id='arrow-work-orders']";
    private static final String CREATE_WORK_ORDER_XPATH = "//a[normalize-space()='Create Work Order']";
    private static final String ASSET_NUMBER_CONTAINER_XPATH = "//span[@id='select2-asset_number-container']";
    private static final String ASSET_NUMBER_RESULTS_XPATH = "//ul[@id='select2-asset_number-results']//li";
    private static final String SERVICE_TASK_TEXTAREA_XPATH = "//textarea[@placeholder='Add or Create Service Task']";
    private static final String ITEMS_RESULTS_XPATH = "//ul[@id='select2-items-results']/li";

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
         }
         catch (Exception e) {
			e.printStackTrace();
		}
	}
           

    
    
    
    

    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
     @Test
     public void addPendingWorkOrder() {
         driver.get(BASE_URL);
         clickElement(By.xpath(MAINTENANCE_STEP_XPATH));
         clickElement(By.xpath(WORK_ORDERS_ARROW_XPATH));

         int num = 4000;
         while (num != 0) {
             clickElement(By.xpath(CREATE_WORK_ORDER_XPATH));
             clickElement(By.xpath(ASSET_NUMBER_CONTAINER_XPATH));

             List<WebElement> suggestionAsset = wait
                     .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(ASSET_NUMBER_RESULTS_XPATH)));
             WebElement randomSuggestion = suggestionAsset.get(random.nextInt(suggestionAsset.size()));
             randomSuggestion.click();

             clickElement(By.xpath(SERVICE_TASK_TEXTAREA_XPATH));
             List<WebElement> suggestionItem = wait
                     .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(ITEMS_RESULTS_XPATH)));

             // Add logic to handle suggestionItem if needed

             num--;
         }
     }
    
     private void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }
    
}
