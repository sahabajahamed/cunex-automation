package NewThings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Runcunex {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "localhost:34311");
        WebDriver driver = new ChromeDriver(options);
        // driver.get("https://staging.groundmetrx.com/");
        driver.manage().window().maximize();
        // driver.findElement(By.xpath("//input[@id='exampleInputUsername']")).sendKeys("Cunex Inc.");
        // driver.findElement(By.xpath("//input[@id='exampleInputPassword1']")).sendKeys("123456");
        // driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
        driver.findElement(By.xpath("//a[@id='step-human-resources']")).click();
    }

}
