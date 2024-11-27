package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PayrollPage extends BasePage {
    private WebDriverWait wait;private WebDriver driver;

    public  PayrollPage(WebDriver driver)
    {
        super(driver);
    }

    //---------------------------------------------Payrol Xpath------------------------------------------//
    @FindBy(xpath = "//a[@id='arrow-line-haul-payroll']")
    private WebElement goTopayroll;
    @FindBy(xpath = "//select[@id='entity_id']")
    private WebElement SelectEntity;
    @FindBy(xpath = "//a[normalize-space()='Begin']")
    private WebElement clickBeginButton;
    @FindBy(xpath = "//a[normalize-space()='Time Sheet']")
    private WebElement ClickTimeSheet;


    




    public void nevigateTopayroll()
    {
        goTopayroll.click();
    }

    public void SelectEntity(String select)
    {
        getSelect(SelectEntity).selectByVisibleText(select);
    }

    public void clickTimeSheet()
    {
        ClickTimeSheet.click();

    }

    public void clickBeginButton()
    {
        clickBeginButton.click();
    }
}
