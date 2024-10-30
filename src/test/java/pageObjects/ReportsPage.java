package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReportsPage extends BasePage {
    
    public ReportsPage(WebDriver driver) {
        super(driver);

     
    }

     @FindBy(xpath = "//a[@target='_blank']")
    private List<WebElement> blankTargetLinks;

    public List<WebElement> getBlankTargetLinks() {
        return blankTargetLinks;
    }
    @FindBy(tagName = "h2") 
    private WebElement header;
    
    public String getHeaderText() {
        return header.getText();
    }



    
}
