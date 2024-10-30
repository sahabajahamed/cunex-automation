package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LineHaulScheduleAPage extends BasePage {
    private WebDriverWait wait;

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

    @FindBy(xpath = "//input[@id='run_origin']")
    private WebElement runOrigin;
    
    @FindBy(xpath = "//input[@id='run_destination']")
    private WebElement runDistination;
    @FindBy(xpath = "//input[@id='run_number']")
    private WebElement runNumber;

    @FindBy(xpath = "//input[@value='all']")
    private WebElement clickAllCheckBox;

    public String verifyLinehaulScheduleText()
    {
        return linehaulScheduleAText.getText();
    }
    public void selectByvisiableTxt(String a)
    {
        getSelect(selectdropdown).selectByVisibleText(a);
    }

    public void scheduleAbuttonclick()
    {   
        addScheduleButton.click();
    }
    public void clickScheduleA()
    {
        linehaulScheduleA.click();
    }

    public void VerifyUseraddSchedule(int origin, int distinatin, int runNumber)
    {

    }






    
}
