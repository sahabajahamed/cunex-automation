package testCases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AttachExistingBrowser {
    public static void main(String[] args) {
        // Set Chrome options to attach to the existing browser
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222"); // Attach to running Chrome

        // Initialize WebDriver (only once)
        WebDriver driver = new ChromeDriver(options);

        // Now you can control the already opened browser
        driver.get("https://staging.groundmetrx.com/");

        // Print the title to confirm connection
        System.out.println("Page Title: " + driver.getTitle());

        // Perform further actions as needed...
        driver.quit();
    }
}
