package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Onboardingpage extends BasePage {

    public Onboardingpage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }
    //locators
    @FindBy (xpath ="//a[@id='arrow-onboarding-system']")
    private WebElement Onboardingsystem;
    @FindBy(xpath="//h2[normalize-space()='Onboarding Process']")
    private WebElement Onboardingheader;
    @FindBy(xpath = "//a[normalize-space()='Add New Hire']")
    private WebElement addnewhire;
    @FindBy(xpath ="//h5[normalize-space()='Add New Hire']")
    private WebElement addnewhiretext;
    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement Firstname;

    
    







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
    

}
