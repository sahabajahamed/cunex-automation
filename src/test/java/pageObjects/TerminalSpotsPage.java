package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TerminalSpotsPage extends BasePage {
    
    public TerminalSpotsPage(WebDriver driver) {
        super(driver);

     
    }

     @FindBy(xpath = "//a[@target='_blank']")
    private List<WebElement> blankTargetLinks;

    public List<WebElement> getBlankTargetLinks() {
        return blankTargetLinks;
    }
    @FindBy(tagName = "h2") 
    private WebElement header;

    @FindBy(xpath = "//a[@id='add-terminal-btn']")
    private WebElement addNewTerminalButton;

    @FindBy(xpath = "//input[@id='terminal_number']")
    private WebElement terminalNumber;

    @FindBy(xpath = "//input[@id='terminal_name']")
    private WebElement terminalName;

    @FindBy(xpath = "//input[@id='terminal_address']")
    private WebElement terminalAddress;

    @FindBy(xpath = "//input[@id='abbreviation']")
    private WebElement abbreviation;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement phone;






    
    public String getHeaderText() {
        return header.getText();
    }

    public void clickAddNewTerminalButton() {
        addNewTerminalButton.click();
    }
    //write a code for terminal formfillp
    public void fillTerminalForm(String terminalNumber, String terminalName, String terminalAddress,
            String abbreviation, String phone) {

        this.terminalNumber.sendKeys(terminalNumber);
        this.terminalName.sendKeys(terminalName);
        this.terminalAddress.sendKeys(terminalAddress);
        this.abbreviation.sendKeys(abbreviation);
        this.phone.sendKeys(phone);

       
    }
    

    

   


    


    
}
