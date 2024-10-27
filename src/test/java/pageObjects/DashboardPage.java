package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage extends BasePage {
	
	public DashboardPage (WebDriver driver)
	{
		super(driver);
	}

	   private WebDriver driver;
	    private WebDriverWait wait;

    // Locators
    @FindBy(xpath = "//h2[normalize-space()='Dashboard']")
    private WebElement dashboardHeader;
    
    @FindBy(xpath ="//a[@id='dropdowndDashboardMenuLink']")
    private WebElement dashboardLink;
    
    @FindBy (xpath="//ul[@class='dropdown-menu p-d-dashboard-drop-box-wrapper dashboard-menu-col show']")
    private List <WebElement> allDashboardLinks;
    
    @FindBy (xpath = "//a[@id='step-linehaul']")
    private WebElement LineHaul;
    
    @FindBy (xpath = "//a[@id='step-pnd']")
    private WebElement PanD;
    
    @FindBy (xpath = "//a[@id='step-assets']")
    private WebElement Assets;
    
    @FindBy (xpath = "//a[@id='step-operations']")
    private WebElement Operations;
    
    @FindBy (xpath = "//a[@id='step-maintenance']")
    private WebElement Maintaince;
    
    @FindBy (xpath ="//a[@id='step-human-resources']")
    private WebElement Hr;
    
    @FindBy(xpath = "//a[@id='step-payroll']")
    private WebElement payroll;
    
    @FindBy(xpath = "//a[normalize-space()='Reports']")
    private WebElement Reports;
    
    @FindBy(xpath = "//a[@id='step-settings']")
    private WebElement Settings;
    
    @FindBy(xpath = "//a[@id='step-admin']")
    private WebElement Admin;
    
    
    public void clickLineHaul()
    {
    	LineHaul.click();
    }
    public void clickPnd()
    {
    	PanD.click();
    }
    public void clickAssets()
    {
    	Assets.click();
    }
    public void clickOperations()
    {
    	Operations.click();
    }
    public void clickMaintance()
    {
    	Maintaince.click();
    }
    public void clickHumenResource() 
    {
        
    	Hr.click();
    }
    public void clickPayroll()
    {
    	payroll.click();
    }
    public void clickReports()
    {
    	Reports.click();
    }
    public void clickSettings()
    {
    	Settings.click();
    }
    public void clickAdmin()
    {
    	Admin.click();
    }
   

//    // Method to get the dashboard header text
//    public String getDashboardHeader() {
//        return dashboardHeader.getText();
//    }
//    
//    public void verifydashbaordallLink()
//    
//    {
//    	  // Click on the dashboard dropdown link to open the list of links
//        dashboardLink.click();
//        
//        // Wait for the dropdown to become visible
//        wait.until(ExpectedConditions.visibilityOfAllElements(allDashboardLinks));
//
//        // Store the main dashboard URL to return after each link navigation
//        String mainDashboardURL = driver.getCurrentUrl();
//
//        // Iterate over each link, click it, verify the navigation, then return to the dashboard
//        for (WebElement link : allDashboardLinks) {
//            String linkText = link.getText(); // Get the link's visible text
//            String href = link.getAttribute("href"); // Get the link's href attribute (URL)
//
//            // Open the link in the same tab/window
//            link.click();
//
//            // Wait for navigation to complete and the new page to load
//            wait.until(ExpectedConditions.urlToBe(href));
//
//            // Verify the new page - can be done by checking URL or an element on the new page
//            String currentUrl = driver.getCurrentUrl();
//            System.out.println("Navigated to: " + currentUrl);
//
//        }
//    }
    	
    
    

}


