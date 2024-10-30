package utlis;


import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericFunction  {
	
    private WebDriver driver;
    private WebDriverWait wait;
    
    // Constructor to initialize the driver and wait
    
    public GenericFunction(WebDriver driver) 
    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
        
    }
    
	public   void performText(WebElement locator , String text)
	{
			WebElement element= wait.until(ExpectedConditions.visibilityOf(locator));
			element.clear();
			element.click();
			element.sendKeys(text);
	}
	
	public  void performClick(WebElement locator) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
	
	public void selectDropdownByText(WebElement locator, String visibleText) {
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated((By) locator));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }
	
	public void selectDropdownByValue(WebElement locator , String value)
	{
		WebElement dropdwonvalue = wait.until(ExpectedConditions.elementToBeClickable(locator));
	       Select dropdown = new Select(dropdwonvalue);
	}

   
    public void acceptAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
	
		
     }
    
    public void dismissAlert()
    {
    	 wait.until(ExpectedConditions.alertIsPresent());
    	 Alert alert = driver.switchTo().alert();
    	 alert.dismiss();
    	 
    }
    
}

