package pageObjects;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeCardpage extends BasePage {
    WebDriverWait wait;
    public TimeCardpage(WebDriver driver)
    {
        super(driver);
    }


    //------------------------------------------------Timecard Xpath--------------------------------//

    @FindBy (xpath = "//button[@title='Mark as no critical']")
    private WebElement markAsNoCritical;
    @FindBy(xpath = "//button[@data-type='add']")
    private WebElement addHour;
    @FindBy(xpath = "//select[@id='critical_reason_id']")
    private WebElement selectReson;
    @FindBy(xpath = "//textarea[@id='no_critical_note']")
    private WebElement notes;
    @FindBy(xpath = "//button[@class='custom_btn_sm mark_as_no_critical_btn']")
    private WebElement markIt;
    @FindBy(xpath = "//select[@id='swal2-select']")
    private WebElement selectTypeOfhour;
    @FindBy(xpath = "//button[normalize-space()='OK']")
    private WebElement hourConfirmOKButton;
    @FindBy(xpath = "//select[@id='hours_earning_code']")
    private WebElement selectEarningCode;
    @FindBy(xpath = "//input[@id='total_hours']")
    private WebElement inputHolidayHour;
    @FindBy(xpath = "//button[@type='submit'][normalize-space()='Add Hour']")
    private WebElement clickHolidayAddHourButton;
    @FindBy(xpath = "//div[@id='accordionFlushExample']//div[@class='accordion-item']")
    private List<WebElement> eachdayClick;

    
    
    //-----------------------------------------------------Method create from Sahabaj--------------------------------------//

   


    public void expandDaySection(WebElement daySection)
    {

        daySection.click();
        wait.until(ExpectedConditions.visibilityOf(daySection));
    }
    
    public void performedConditioanlAction()
    {
        try {
            if (addHour.isDisplayed()) {
                addHour.click();
                getSelect(selectTypeOfhour).selectByIndex(2);
                hourConfirmOKButton.click();
                getSelect(selectReson).selectByIndex(2);
                inputHolidayHour.sendKeys("8");
                clickHolidayAddHourButton.click();

                

            }
        } catch (Exception e) {
            System.out.println("add hour button is not visaible");
        }
        try {
            if (markAsNoCritical.isDisplayed()) {
                markAsNoCritical.click();
                getSelect(selectReson).selectByIndex(2);
                notes.sendKeys("wasim ");
                markIt.click();

            }

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
    
    public void interactEachday()
    {
        for (WebElement webElement : eachdayClick) {
            expandDaySection(webElement);
            performedConditioanlAction();

        }
    }
    

    public void waitForPageToRefresh() {
        wait.until(ExpectedConditions.refreshed(
        ExpectedConditions.presenceOfElementLocated(By.tagName("body"))
        ));
    }

}
