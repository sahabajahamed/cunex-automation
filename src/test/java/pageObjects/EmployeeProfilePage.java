package pageObjects;


import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeProfilePage extends BasePage {

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public EmployeeProfilePage(WebDriver driver) 
    {
        super(driver);

    }
    
    //Basic Inforamtion Xpath
    @FindBy(xpath = "//button[@id='basic_info_edit_btn']")
    private WebElement editButton;
    @FindBy(xpath = "//input[@id='emp_start_date']")
    private WebElement startDateClick;
    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td[@data-event='click']")
    private List<WebElement> startDate;
    @FindBy(xpath = "//input[@id='username']")
    private WebElement username;
    @FindBy(xpath = "//select[@id='role_id']")                      //SelectClass
    private WebElement role;
    @FindBy(xpath = "//input[@id='phone_number']")
    private WebElement phone;
    @FindBy(xpath = "//input[@id='fedex_id']")
    private WebElement fedExId;
    @FindBy(xpath = "//input[@id='home_terminal']")
    private WebElement homeTerminal; // input 1 in hometermianl 
    @FindBy(xpath = "//select[@id='department']")                       //SelectClass
    private WebElement depearment;
    @FindBy(xpath = "//input[@id='position']")
    private WebElement position;
    @FindBy(xpath = "//select[@id='entity_id']")                            //SelectClass
    private WebElement entity;
    @FindBy(xpath = "//select[@id='type']")//SelectClass
    private WebElement type;
    @FindBy(xpath = "//input[@id='manager_name']")
    private WebElement manager;
    @FindBy(xpath = "//input[@id='card_expiration_date']")
    private WebElement dotCardExcreption;
    @FindBy(xpath = "//input[@id='license_expiration_date']")
    private WebElement licenseExpiration;
    @FindBy(xpath = "//select[@id='shift_time']")
    private WebElement shiftTime;
    @FindBy(xpath = "//select[@id='emp_type']")  //SelectClass
    private WebElement empType;


    //Personal Information
    @FindBy(xpath = "//button[@id='personal_info_tab']")
    private WebElement personalTab;
    

    //Emergencey contact
    @FindBy(xpath = "//button[@id='emergency_contacts_info_add_btn']")
    private WebElement addNewContact;
    @FindBy(xpath = " (//input[@id='emergency_contacts[0][first_name]'])[1]")
    private WebElement emergencyFirstname;
    @FindBy(xpath="(//input[@id='emergency_contacts[0][last_name]'])[1]")
    private WebElement emergencyLastName;
    @FindBy(xpath = "(//select[@id='emergency_contacts[0][relationship]'])[1]")
    private WebElement selectRelationship;
    @FindBy(xpath = "(//input[@id='emergency_contacts[0][mobile_phone]'])[1]")
    private WebElement emergencyPhoneNumber;
    @FindBy(xpath = "(//input[@id='emergency_contacts[0][email]'])[1]")
    private WebElement emergencyEmail;
    @FindBy(xpath = "//button[@id='emergency_contacts_info_save_btn']")
    private WebElement clickSaveButton;
    @FindBy(xpath = "//button[@id='emergency_contacts_info_cancel_btn']")
    private WebElement emergencyCancelButton;

    //Payroll
    @FindBy(xpath = "//input[@id='emp_id']")
    private WebElement payrollEmpID;
    @FindBy(xpath = "//select[@id='entity_id']")
    private WebElement payrollEntity;
    @FindBy(xpath = "//select[@id='pay_group_id']")
    private WebElement payGroupID;
    @FindBy(xpath = "//select[@id='break_policy_id']")
    private WebElement breakpolicy;
    @FindBy(xpath = "//select[@id='pay_type']")
    private WebElement payType;
    @FindBy(xpath = "//input[@id='pay_rate']")
    private WebElement payRate;
    @FindBy(xpath = "//input[@id='safety_bonus']")
    private WebElement safteyBonus;
    @FindBy(xpath="//input[@id='fuel_pay']")
    private WebElement fuelPay;
    

    
    
}