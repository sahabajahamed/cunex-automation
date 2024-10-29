package testCases;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.TimeDashboardPage;

public class TimeDashboardTest extends BaseTest {
	private LoginPage loginPage;
	private DashboardPage dashboard;
	private TimeDashboardPage timedashboardPage;

	@Test(priority = 1)
	public void VerifyTimedashboard() throws InterruptedException, AWTException
	{
		loginPage= new LoginPage(driver);
		loginPage.loginPerform("Cunex Inc.", "Thenewpasswordiscunex@362");
		dashboard= new DashboardPage(driver);
		dashboard.clickHumenResource();
		timedashboardPage=new TimeDashboardPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		 timedashboardPage.clickTimedashboard();
		Assert.assertEquals(timedashboardPage.verifyTimedashboardtext(), "Time Dashboard", "Message not matched ");
	
		
	}
	
	@Test(priority = 2)
	public void userAbletoperformApproveButton() throws InterruptedException, AWTException
	{
		loginPage= new LoginPage(driver);
		BaseTest.normalZoom();
		BaseTest.zommout();
		loginPage.loginPerform("Cunex Inc.", "Thenewpasswordiscunex@362");
		dashboard= new DashboardPage(driver);
		dashboard.clickHumenResource();
		BaseTest.zommout();
		timedashboardPage=new TimeDashboardPage(driver);
		timedashboardPage.clickTimedashboard();
		timedashboardPage.clickApproveButton();
		
		
	}
	
	
	

}
