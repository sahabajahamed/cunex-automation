package Cunex;

import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Basepage {
     public static WebDriver driver;

    public void signIn() {

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();

        // Disable notifications permission pop-up
        prefs.put("profile.default_content_setting_values.notifications", 2);
      

        // Set these preferences into ChromeOptions
        options.setExperimentalOption("prefs", prefs);

      
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);


    
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    driver.get("https://staging.groundmetrx.com");

    }
    public static String randomstring() {
        String randomname = RandomStringUtils.randomAlphabetic(5);
        return randomname;
    }
    public static String randomlocation()
    {
        String randomlocation = RandomStringUtils.randomAlphabetic(2);
        return randomlocation;
    }

    public static String randomnumber() {
        String randomphone = RandomStringUtils.randomNumeric(2);
        return randomphone;
    }

    public static String randomemail() {
        String randomemail = RandomStringUtils.randomAlphabetic(5) + "@gmail.com";
        return randomemail;
    }


}
