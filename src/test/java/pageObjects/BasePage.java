package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BasePage {
public static WebDriver driver;
	
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public Select getSelect(WebElement dropdownElement) {
        return new Select(dropdownElement);
    }
	
	
	
// Some code transfer...
}
