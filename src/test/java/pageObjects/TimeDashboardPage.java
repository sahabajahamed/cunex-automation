package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

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
	
	
	 String messageText = popupMessage.getText();

	
	public String verifyTimedashboardtext()
	{
		return timedashoardText.getText();
	}
	public void clickTimedashboard()
	{
		timeDashboard.click();
	}
	
	public void clickApproveButton()
	{
		for(WebElement approveButton : approveButtons)
		{
			 wait.until(ExpectedConditions.elementToBeClickable(approveButton)).click();
			 wait.until(ExpectedConditions.visibilityOf(popupMessage));
			 approveButton.click();
			 
			 if(messageText.contains("Non-Critical Exception"))
				 
			 {
				 handleNonCritical();
			 }
			 else if (messageText.contains("Please resolve those to continue."))
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
	
	public void handleCritical()
	{
		OkButton.click();
	}
	public void sucessfull()
	{
		OkButton.click();
	}
	
	// code will be added
	
}
