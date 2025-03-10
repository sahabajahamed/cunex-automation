package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver) {
        super(driver);
       
    }


    private  WebDriver driver;
	
	
	

    // Locators
    @FindBy(xpath = "//input[@placeholder='Enter your username']") 
    private WebElement usernameField;

    @FindBy(xpath = "//input[@placeholder='Enter password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@class='btn full-btn']") 
    private WebElement loginButton;
    
    @FindBy (xpath ="//ul[normalize-space()='Invalid Credentials']")
    private WebElement errorMessage;
    
    @FindBy (xpath = "//ul[normalize-space()='Username or Password incorrect']")
    private WebElement validusernameerror;
 
    @FindBy (xpath = "//h2[normalize-space()='Dashboard']")
    private WebElement sucessfullyMessage;
    

    public String invalidusernameerrorMessageDisplyed()
    {
    	return errorMessage.getText();
    }
    public String validusernameerrormessge()
    {
    	return validusernameerror.getText();
    }
    
    public String SucessfullyMessage()
    {
    	return sucessfullyMessage.getText();
    }

    
    // Method to perform login
    public void loginPerform(String username, String password) 
    {
        usernameField.clear();
        usernameField.sendKeys(username);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
    }
    
                                                                                                                                      
    //write a method to get the title of the page
    public String getPageTitle() {
        return driver.getTitle();
    }
}
