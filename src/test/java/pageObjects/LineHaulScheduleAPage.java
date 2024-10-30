package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LineHaulScheduleAPage extends BasePage {

    public LineHaulScheduleAPage(WebDriver driver) {
        super(driver);
     
    }

    @FindBy(xpath = "//a[@id='arrow-line-haul-schedule-a']")
    private WebElement linehaulScheduleA;

    @FindBy(xpath = "//h2[normalize-space()='Linehaul Schedule A']")
    private WebElement linehaulScheduleAText;

    @FindBy(xpath = "//a[normalize-space()='Add Assigned Schedule']")
    private WebElement addScheduleButton;

    @FindBy(xpath = "//select[@id='tractor' and @name='tractor']")
    private WebElement selectdropdown;

    public String verifyLinehaulScheduleText()
    {
        return linehaulScheduleAText.getText();
    }
    public void selectByvisiableTxt(String a)
    {
        getSelect(selectdropdown).selectByVisibleText(a);
    }





    
}
