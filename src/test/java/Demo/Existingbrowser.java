package Demo;

import java.util.Map;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v120.debugger.Debugger;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Existingbrowser {

    public static void main(String[] args) {

        // ChromeOptions options = new ChromeOptions();
        // options.setExperimentalOption("debuggerAddress", "localhost:4747");
        // ChromeDriver driver = new ChromeDriver(options);
        // Capabilities capabilities = driver.getCapabilities();
        // Map<String, Object> asMap = capabilities.asMap();
        // asMap.forEach((key, value) -> {
        //     System.out.println("key " + key + "value " + value);
        // });
        // driver.get("https://staging.groundmetrx.com/");
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver=new ChromeDriver();
        Capabilities cap=driver.getCapabilities();
        Map<String,Object>mycap=cap.asMap();
        System.out.println(mycap);
        // driver.findElement(By.xpath("//input[@id='exampleInputUsername']")).sendKeys("Cunex Inc.");
        // driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("123456");
        // driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        // driver.findElement(By.xpath("//a[@id='step-human-resources']")).click();

    }
    // public static String randomstring() {
    //     String randomname = RandomStringUtils.randomAlphabetic(5);
    //     return randomname;
    // }
    // public static String randomlocation()
    // {
    //     String randomlocation = RandomStringUtils.randomAlphabetic(2);
    //     return randomlocation;
    // }

    // public static String randomnumber() {
    //     String randomphone = RandomStringUtils.randomNumeric(2);
    //     return randomphone;
    // }

    // public static String randomemail() {
    //     String randomemail = RandomStringUtils.randomAlphabetic(5) + "@gmail.com";
    //     return randomemail;
    // }
    // public void signIn() {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'signIn'");
    // }

}
