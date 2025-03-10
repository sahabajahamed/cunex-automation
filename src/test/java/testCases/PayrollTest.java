package testCases;

import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.PayrollPage;
import pageObjects.TimeCardpage;
import pageObjects.TimeDashboardPage;

public class PayrollTest extends BaseTest {


    private LoginPage loginPage;
		private DashboardPage dashboard;
		private TimeDashboardPage timedashboardPage;
        private TimeCardpage timecard;
        private PayrollPage payroll;
    @Test
    public void verifyPayroll() throws InterruptedException
    {
            loginPage= new LoginPage(driver);
			loginPage.loginPerform("Cunex Inc.", "123456");
			dashboard= new DashboardPage(driver);
            dashboard.clickPayroll();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            payroll =new PayrollPage(driver);
            payroll.nevigateTopayroll();
            payroll.SelectEntity("Cunex Inc.");
            Thread.sleep(4000);
            payroll.clickBeginButton();
        //    switchToNWindow();


            payroll.clickTimeSheet();
            switchToNWindow();
            timedashboardPage = new TimeDashboardPage(driver);
            timedashboardPage.clickApproveButton();
           
            Thread.sleep(4000);
            timedashboardPage.clickDriverName();
            Thread.sleep(4000);
            switchToNWindow();
            timecard.performedConditioanlAction();
            
            
            
            
    }
    
}

