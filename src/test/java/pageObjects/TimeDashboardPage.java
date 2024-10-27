package pageObjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeDashboardPage extends BasePage{
	private WebDriverWait wait;
	
	public TimeDashboardPage(WebDriver driver) {
		super(driver);
		
		
	}
	@FindBy(xpath = "//a[@id='arrow-time-dashboard']")
	private WebElement timeDashboard;
	
	@FindBy(xpath = "//h2[normalize-space()='Time Dashboard']")
	private WebElement  timedashoardText;
	
	@FindBy (xpath = "//button[@class='custom_btn_sm approve_time_dashboard']")
	private  List<WebElement> approveButtons;
	
	@FindBy(xpath = "//div[@id='swal2-html-container']")
	private WebElement popupMessage;
	
	@FindBy (xpath = "//button[@class='swal2-confirm swal2-styled swal2-default-outline']")
	private WebElement approve;
	
	@FindBy (xpath = "//button[normalize-space()='OK']")
	private WebElement OkButton;
	
	@FindBy(xpath="//td[@class='sorting_1'] //a[@href]")
	private List<WebElement>driverLinks;
	@FindBy(xpath="//div[@class='d-flex justify-content-end align-items-center mb-3']//button[@id='expand_btn']") private 
	WebElement expandButton;

	@FindBy(xpath="//button[@title='Mark as no critical']")
	private List<WebElement> markAsNoCritical;
	@FindBy(xpath="//select[@id='critical_reason_id']") 
	private WebElement dropdwnText;
	@FindBy(id="no_critical_note") 
	private WebElement critcialtext;
	@FindBy(xpath="//button[@class='custom_btn_sm mark_as_no_critical_btn']") 
	private WebElement markItButton;
	
	
	 String messageText = popupMessage.getText();

	
	public String verifyTimedashboardtext()
	{
		return timedashoardText.getText();
	}
	public void clickTimedashboard()
	{
		timeDashboard.click();
	}
	
	public void clickApproveButton() throws InterruptedException
	{
		for(WebElement approveButton : approveButtons)
		{
			 wait.until(ExpectedConditions.elementToBeClickable(approveButton)).click();
			 wait.until(ExpectedConditions.visibilityOf(popupMessage));
			 String messageText = popupMessage.getText();
			
			 
			 if(messageText.contains("Please resolve those to continue."))
				 
			 {
				handleCritical();
			 }
			 else if (messageText.contains("Non-Critical Exception"))
			 {
				 handleCritical();
				
			}else if (messageText.contains("The data has been updated successfully.")) 
			{
				sucessfull();
			}
		}
		
		
	}
	public void handleNonCritical()
	{
		approve.click();
		OkButton.click();
	}
	

	
	public void handleCritical() throws InterruptedException
	{
		OkButton.click();
					
			WebElement[] driveLinks = null;
			WebElement[] markAsNoCritical = null;

					for (WebElement webElement : driveLinks) {
						webElement.click();
						Thread.sleep(5000);
						String mainWindowHandle = driver.getWindowHandle();
						Set<String> allWindowHandles = driver.getWindowHandles();

						for (String windowHandle : allWindowHandles) {
							if (!windowHandle.equals(mainWindowHandle)) 
							{
								driver.switchTo().window(windowHandle);
								expandButton.click();
							for (WebElement markNocritical :  markAsNoCritical) {
								Thread.sleep(5000);
								markNocritical.click();
								Thread.sleep(5000);
								Select sel = new Select( dropdwnText);
								sel.selectByVisibleText("Incorrect Schedule");
								critcialtext.sendKeys("exx");
								markItButton.click();
								
							}
							driver.close();

						driver.navigate().back();
							}
						}
					
						
					}
	}
	public void sucessfull()
	{
		OkButton.click();
	}
	
	// code will be added
	
}
