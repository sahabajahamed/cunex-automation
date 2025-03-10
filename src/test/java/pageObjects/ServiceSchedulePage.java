package pageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ServiceSchedulePage extends BasePage {
    Random random = new Random();
    
    public ServiceSchedulePage(WebDriver driver)
    {
        super(driver);
    }

    /*------------------------------------XPATH---------------------------------- */
    @FindBy(xpath = "//table//tr/td[2]")
    private List<WebElement> assetElements;
    @FindBy(xpath="//input[@aria-controls='pending_list_table']")
    private WebElement searchField;







    public void searchAsset() throws InterruptedException
    {
        for (WebElement asset : assetElements)
        {
            
            
             String assetNumber = asset.getText().trim();
             searchField.clear();
             searchField.sendKeys(assetNumber);
             Thread.sleep(3000);
            
        }
    }
    







    
    
}
