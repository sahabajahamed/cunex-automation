package pageObjects;

import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeePage extends BasePage{
    private WebDriverWait wait;

    public EmployeePage(WebDriver driver) {
        super(driver);
      
    }
    //Sorting of the each column function
    @FindBy(xpath = "//a[@id='reimbursements']")
    private WebElement reimbursement;
    @FindBy(xpath = "//button[@data-bs-toggle='modal']")
    private WebElement clickReimButton;
    @FindBy(xpath = "//h5[@id='exampleModalLabel']")
    private WebElement addReimText;


    //Employee column header 
    @FindBy(xpath = "//th[@aria-label='First Name: activate to sort column descending']")
    private WebElement firstNameHeader;
    @FindBy(xpath = "//table[@id='drivers_list_table']//th[@aria-label='Last Name: activate to sort column ascending'][normalize-space()='Last Name']")
    private WebElement lastNameHeader;
    @FindBy(xpath = "//table[@id='drivers_list_table']//th[@aria-label='Username: activate to sort column ascending'][normalize-space()='Username']")
    private WebElement usernameHeader;
    @FindBy(xpath = "//table[@id='drivers_list_table']//th[@aria-label='Department: activate to sort column ascending'][normalize-space()='Department']")
    private WebElement depermentHeader;

    // Row data for ech column

    @FindBy(xpath = "//table[@id='drivers_list_table']//td[@data-name='first_name']")
    private List<WebElement> firstNameColumn;
    @FindBy(xpath = "//table[@id='drivers_list_table']//td[@data-name='last_name']")
    private List<WebElement> lastNameColumn;
    @FindBy(xpath = "//table[@id='drivers_list_table']//td[@data-name='department']")
    private List<WebElement> depermentColumn;
    
    //Method to Click Header and Verify Sorting Order

    //actions perform
    public void verifyReimbursementPage()
    {
        reimbursement.click();
        String mainWindow = driver.getWindowHandle();
        Set<String> allWindow = driver.getWindowHandles();
        for (String window : allWindow) 
        {
            if (!window.equals(allWindow)) {
                driver.switchTo().window(window);
                clickReimButton.click();

            }
            driver.close();

        }
        driver.switchTo().window(mainWindow);
    }

    

    public String getAddReimText()
    {
        return addReimText.getText();
    }
   

    

    }







    

