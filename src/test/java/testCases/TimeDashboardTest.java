package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.TimeDashboardPage;

public class TimeDashboardTest extends BaseTest {
	@Test(priority = 1)
	public void VerifyTimedashboard()
	{
		LoginPage lp= new LoginPage(driver);
		lp.loginPerform("Cunex Inc.", "Thenewpasswordiscunex@362");
		DashboardPage dp= new DashboardPage(driver);
		dp.clickHumenResource();
		TimeDashboardPage tp=new TimeDashboardPage(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		tp.clickTimedashboard();
		Assert.assertEquals(tp.verifyTimedashboardtext(), "Time Dashboard", "Message not matched ");
	
		
	}
	
	@Test(priority = 2)
	public void performApproveButton()
	{
		// code added
	}
	
	
	

}
