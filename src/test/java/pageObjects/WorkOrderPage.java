package pageObjects;

import java.time.Duration;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkOrderPage extends BasePage{

  
    WebDriverWait wait;

    // Constructor
    public WorkOrderPage(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(2));  // ✅ Initialize wait
    }

    /* ALL LOCATORS */
    @FindBy(xpath="//a[@id='arrow-work-orders']")
    private WebElement workOrder;

    @FindBy(xpath="//a[normalize-space()='Create Work Order']")
    private WebElement CreateWorkOrder;

    @FindBy(xpath="//button[@id='completed-tab']")
    private WebElement completTab;

    @FindBy(linkText = "Pending")
    private WebElement pendingButtons;  // ✅ Use List to handle multiple buttons

    @FindBy(linkText = "Complete")
    private WebElement completeButton;

    @FindBy(xpath="//button[normalize-space()='Yes']")
    private WebElement yesButton;

    @FindBy(xpath="//button[normalize-space()='OK']")
    private WebElement successOkButton;

    @FindBy(xpath = "//select[@id='swal2-select']")
    private WebElement selectElement;

    /*--------------------ACTION METHODS--------------------*/

    public void click_WorkOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(workOrder)).click();
    }

    public void click_Create_WorkOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(CreateWorkOrder)).click();
    }

    public void click_Complete_tab() {
        wait.until(ExpectedConditions.elementToBeClickable(completTab)).click();
    }

    // public void click_All_Pending_Buttons() {
    //     for (WebElement button : pendingButtons) {
    //         try {
    //             wait.until(ExpectedConditions.elementToBeClickable(button)).click();
    //         } catch (Exception e) {
    //             System.out.println("Skipping a Pending button due to error: " + e.getMessage());
    //         }
    //     }
    // }

    public void click_Pending_Button() {
       
            try {
                wait.until(ExpectedConditions.elementToBeClickable(pendingButtons)).click();
            } catch (Exception e) {
                System.out.println("Skipping a Pending button due to error: " + e.getMessage());
            }
        
    }

    public void click_Yes_button() {
        wait.until(ExpectedConditions.elementToBeClickable(yesButton)).click();
    }

    public void click_OK_button() {
        wait.until(ExpectedConditions.elementToBeClickable(successOkButton)).click();
    }

    public void selectDropdown(int dropdown) {
        try {
            wait.until(ExpectedConditions.visibilityOf(selectElement));
            Select select = new Select(selectElement);
            select.selectByIndex(1);

        } catch (Exception e) {
            System.out.println("Dropdown selection failed: " + e.getMessage());
        }
    }

public void click_Complete_Button()
{
    try {
        wait.until(ExpectedConditions.elementToBeClickable(completeButton)).click();
    } catch (Exception e) {
        System.out.println("Skipping a Pending button due to error: " + e.getMessage());
    }
}
    






















    public void completeWorkOrder() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(completeButton)).click();
            wait.until(ExpectedConditions.elementToBeClickable(yesButton)).click();
           
            wait.until(ExpectedConditions.elementToBeClickable(successOkButton)).click();
           
            
            

            wait.until(ExpectedConditions.elementToBeClickable(selectElement));
            Select select = new Select(selectElement);
            select.selectByIndex(1);

            wait.until(ExpectedConditions.elementToBeClickable(successOkButton)).click();
        } catch (StaleElementReferenceException e) {
            System.out.println("Element was stale, retrying...");
            completeWorkOrder();  // Recursive retry
        } catch (Exception e) {
            System.out.println("Error completing work order: " + e.getMessage());
        }
    }
}
    

