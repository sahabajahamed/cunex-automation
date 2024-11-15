package pageObjects;

import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Onboardingpage extends BasePage {

    public Onboardingpage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }
    //--------------------------------------------------ONBOARDING SYSTEM PAGE
    @FindBy (xpath ="//a[@id='arrow-onboarding-system']")
    private WebElement Onboardingsystem;
    @FindBy(xpath="//h2[normalize-space()='Onboarding Process']")
    private WebElement Onboardingheader;
    @FindBy(xpath = "//a[normalize-space()='Add New Hire']")
    private WebElement addnewhire;
    @FindBy(xpath = "//table[@id='pending_onboarders_list_table']//tbody//tr//td//a[@class='fw-semibold']")
    private List<WebElement> listOftheEmployee;
    @FindBy(xpath = "//table[@id='pending_onboarders_list_table']//tbody//tr//button[.='Reject Candidate']")
    private List<WebElement> listOftheRejectCandidate;
    @FindBy(xpath = "//button[normalize-space()='Yes']")
    private WebElement yesConfirmMessage;
    @FindBy(xpath = "//button[@class='swal2-deny swal2-styled']")
    private WebElement noConfirMessage;
    @FindBy(xpath = "//button[@id='hired_onboarders']")
    private WebElement hiredTab;


    //----------------------------------------------ADD NEW HIRE---------------------------------------------//
    @FindBy(xpath ="//h5[normalize-space()='Add New Hire']")
    private WebElement addnewhiretext;
    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement Firstname;
    @FindBy(xpath = "//input[@id='middle_name']")
    private WebElement Middlename;
    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement lastname;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;
    @FindBy(xpath = "//input[@id='phone_number']")
    private WebElement phoneno;
    @FindBy(xpath = "//select[@id='department']")
    private WebElement selectDepartment;
    @FindBy(xpath = "//select[@id='entity_id']")
    private WebElement selectEntity;
    @FindBy(xpath = "//button[@id='add_onboarder_btn']")
    private WebElement addButton;

    
    






//----------------------------------------------------Method ---------------------------------------------------------//
    public void onboarding()
    {
        Onboardingsystem.click();
        
    }
    public String Onboardingtext()
    {
        return Onboardingheader.getText();
    }
    public void addnewhire()
    {
        addnewhire.click();
    }
    public String addnewhiretext()
    {
        return addnewhiretext.getText();
    }

    public void firstname(String a)
    {
        Firstname.sendKeys(a);
    }
    public void middlename(String b)
    {
        Middlename.sendKeys(b);
    }
    public void lastname(String c)
    {
        lastname.sendKeys(c);
    }
    public void email(String d)
    {
       email.sendKeys(d);
    }
    public void phoneNo(String p)
    {
        phoneno.sendKeys(p);
    }
    public void selectdepartment(String dd)
    {
        getSelect(selectDepartment).selectByVisibleText(dd);
    }
    public void selectentity(String Entity)
    {
        getSelect(selectEntity).selectByVisibleText(Entity);
    }
    
    public void addbutton()
    {
        addButton.click();
    }
    
      public void goToHiredTab() {
        hiredTab.click();
     
    }
}
