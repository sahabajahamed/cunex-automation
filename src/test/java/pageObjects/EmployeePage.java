package pageObjects;

import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collector;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeePage extends BasePage{
    private WebDriverWait wait;
    Random random = new Random();

    public EmployeePage(WebDriver driver) {
        super(driver);
      
    }
    //Sorting of the each column function
    @FindBy(xpath = "//a[@id='arrow-employees']")
    private WebElement clickEmployee;
    @FindBy(xpath = "//a[@id='reimbursements']")
    private WebElement reimbursement;
    @FindBy(xpath = "(//button[normalize-space()='Create']")
    private WebElement clickReimButton;
    @FindBy(xpath = "//h5[@id='exampleModalLabel']")
    private WebElement addReimText;
    @FindBy(xpath = "//button[@data-bs-toggle='modal']")

    //Modal reimbursmenet xpath
    private WebElement clickReimbursementButton;
    @FindBy(id = "select2-user_id-container")
    private WebElement clickSelectEmployeeTextField;
    @FindBy(xpath = "//ul[@id='select2-user_id-results']//li")
    private List<WebElement> driverSuggesationName;
    @FindBy(xpath = "//input[@id='date']")
    private WebElement dateField;
    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td[@data-event='click']")
    private List<WebElement> calenderSelect;
    @FindBy(xpath = "//input[@id='amount']")
    private WebElement amountTextField;
    @FindBy(xpath = "//textarea[@id='description']")
    private WebElement descriptionText;
    @FindBy(xpath = "//input[@id='images']")
    private WebElement chouseImages;
    @FindBy(xpath = "//button[normalize-space()='Create']")
    private WebElement clickCreateButton;



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

        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window); // Switch to new window
                break;
            }
        }
    }

    public void  selectReimbursementEmployeeFromDropdown()
    {

        clickReimbursementButton.click();
        clickSelectEmployeeTextField.click();

        
        int randomName = random.nextInt(driverSuggesationName.size());
        WebElement randomSuggestion = driverSuggesationName.get(randomName);
        randomSuggestion.click();
       

    }

    public void selectDateFieldFromCalender()
    {
        dateField.click();
        if (!calenderSelect.isEmpty()) {
            int randomIndex = random.nextInt(calenderSelect.size());
            WebElement randomDate = calenderSelect.get(randomIndex);
            randomDate.click();

        } else {
            System.out.println("No selectable dates found.");
        }
    }

    public void enterReimbursementAmount(String amount)
    {
        amountTextField.sendKeys(amount);
    }
    
    public void writeDescriptionForReimbursement(String desp)
    {
        descriptionText.sendKeys(desp);
    }

    public void chouseImages()
    {
        File file = new File("src/images/screenshot-staging_groundmetrx_com-2024_11_04-16_59_47.png");
			String absoulutePath = file.getAbsolutePath();
			chouseImages.sendKeys(absoulutePath);
    }


    public void createReimbursement()
    {
       clickCreateButton.click();
    }

    
    
    public void clickEmployeeLink()
    {
        clickEmployee.click();
    }

   

    

    public String getAddReimText()
    {
        return addReimText.getText();
    }
   

    

    }







    

