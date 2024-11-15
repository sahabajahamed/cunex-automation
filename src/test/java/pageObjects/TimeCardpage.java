package pageObjects;



import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TimeCardpage extends BasePage {
    
    public TimeCardpage()
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

    
    
    //-----------------------------------------------------Method create --------------------------------------//

    public void clickEachDay()
    {
        
    }
}
