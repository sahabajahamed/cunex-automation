package testCases;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Weavers.Cunex.Dashbaord__001;
import pageObjects.DashboardPage;
import pageObjects.LineHaulScheduleAPage;
import pageObjects.LoginPage;

public class LineHaulScheduleATest extends BaseTest{
    private WebDriverWait wait;
   private LoginPage loginpage;
   private  DashboardPage dashboard;
   private LineHaulScheduleAPage scheduleA;


    @Test
    public void clickaddAssigniedSchedule()
    {   loginpage= new LoginPage(driver);
        loginpage.loginPerform(" Cunex Inc.", "Thenewpasswordiscunex@362");
        dashboard =new DashboardPage(driver);
        dashboard.clickLineHaul();
        scheduleA =new LineHaulScheduleAPage(driver);
        scheduleA.clickScheduleA();
        scheduleA.scheduleAbuttonclick();
    }
    
}
