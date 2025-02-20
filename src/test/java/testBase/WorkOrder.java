package testBase;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkOrder {

    WebDriverWait wait;
    WebDriver driver;
    Random random2 = new Random();
   
   
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
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.body.style.zoom='80%'");
            driver.findElement(By.xpath("//input[@id='exampleInputUsername']")).sendKeys(" Cunex Inc.");
            driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("123456");
            driver.findElement(By.xpath("//button[@class='btn full-btn']")).click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // driver is close 
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void addPendingWorkOrder() throws InterruptedException {
        driver.get("https://staging.groundmetrx.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        int num = 4000;
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@id='step-maintenance']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@id='arrow-work-orders']")).click();
        Thread.sleep(3000);
        while (num != 0) {

            driver.findElement(By.xpath("//a[normalize-space()='Create Work Order']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//span[@id='select2-asset_number-container']")).click();
            Thread.sleep(3000);
            List<WebElement> suggestionAsset = driver
                    .findElements(By.xpath("//ul[@id='select2-asset_number-results']//li"));

            int randomName = random2.nextInt(suggestionAsset.size());
            WebElement randomSuggestion = suggestionAsset.get(randomName);
            randomSuggestion.click();

            Thread.sleep(3000);
            driver.findElement(By.xpath("//textarea[@placeholder='Add or Create Service Task']")).click();
            Thread.sleep(3000);
            List<WebElement> suggestionItem = driver.findElements(By.xpath("//ul[@id='select2-items-results']/li"));

            int randomItem = random2.nextInt(suggestionItem.size());
            WebElement randomclickSuggestionItem = suggestionItem.get(randomItem);
            randomclickSuggestionItem.click();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//input[@id='due_date']")).click();
            Thread.sleep(2000);
            List<WebElement> calenderXpath = driver
                    .findElements(By.xpath("//table[@class='dt-datetime-table']/tbody/tr/td[@class='selectable']"));
            int randomclick = random2.nextInt(calenderXpath.size());
            WebElement randomClick2 = calenderXpath.get(randomclick);
            randomClick2.click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//span[@id='select2-assignee_id-container']")).click();
            Thread.sleep(2000);
            List<WebElement> assigne = driver.findElements(By.xpath("//span[@class='select2-results']/ul/li"));
            int randomAssigne = random2.nextInt(assigne.size());
            WebElement randomclickAssigne = assigne.get(randomAssigne);
            randomclickAssigne.click();
            Thread.sleep(2000);

            driver.findElement(By.xpath("//button[normalize-space()='Create']")).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
            Thread.sleep(2000);

            num--;
        }
    }

    @Test
    public void deleteWorkOrder() throws InterruptedException {
        driver.get("https://staging.groundmetrx.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='step-maintenance']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='arrow-work-orders']"))).click();


        for (int i = 0; i < 150; i++) {
            try{
                try {
                  try{
                Thread.sleep(1000);
                // wait.until(ExpectedConditions.elementToBeClickable()).click();
                WebElement complete = driver.findElement(By.linkText("Complete"));
                complete.click();
                            WebElement yesButton = driver.findElement(By.xpath("//button[normalize-space()='Yes']"));
                            yesButton.click();
                        }
        
                        catch (Exception e) {
                            System.out.println("a");
                        }
        
                 
        
                            WebElement selectElement =  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='swal2-select']")));
                            Select select = new Select(selectElement);
                            select.selectByIndex(1);
        
                            WebElement okButton = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
                            okButton.click();
        
                            WebElement finalOkButton = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
                            finalOkButton.click();
                    } catch (Exception e) {
                            // WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']")));
                            // okButton.click();
                            System.out.println("not found");
                        } 
              Thread.sleep(1000);
                    WebElement okButton = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
                            okButton.click();
                        } catch (Exception e) {
                    System.out.println("aa");
                }
        }



        // List<WebElement> allCompleteButton = wait
        //         .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.linkText("Complete")));

        //     for (WebElement completeButton : allCompleteButton) {
        //         try {
        //             wait.until(ExpectedConditions.elementToBeClickable(completeButton)).click();
        //             WebElement yesButton = wait
        //                     .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Yes']")));
        //             yesButton.click();
        //         }

        //         catch (Exception e) {
        //             System.out.println("a");
        //         }

        //         try {

        //             WebElement selectElement = wait
        //                     .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='swal2-select']")));
        //             Select select = new Select(selectElement);
        //             select.selectByIndex(1);

        //             WebElement okButton = wait
        //                     .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']")));
        //             okButton.click();

        //             // WebElement finalOkButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']")));
        //             // finalOkButton.click();
        //         } catch (Exception e) {
        //             // WebElement okButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']")));
        //             // okButton.click();
        //             System.out.println("not found");
        //         } 
        // try {
        //     WebElement okButton = wait
        //                     .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']")));
        //             okButton.click();
        //         } catch (Exception e) {
        //     System.out.println("aa");
        // }

        //     }




    }
}
