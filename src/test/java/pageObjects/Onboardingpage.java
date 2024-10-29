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
    
    
    
}
