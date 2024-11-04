package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.EmployeePage;
import pageObjects.LoginPage;

public class EmployeeTest extends BaseTest {

    private LoginPage loginpage;
    private DashboardPage dashboardPage;
    private EmployeePage employeePage;


    @Test
    public void verifyAddReimbursement()
    {
        loginpage= new LoginPage(driver);
		loginpage.loginPerform(" Cunex Inc.", "Thenewpasswordiscunex@362");
        Assert.assertEquals(loginpage.SucessfullyMessage(), "Dashboard", "Login fail ");
        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickHumenResource();
        employeePage = new EmployeePage(driver);
        employeePage.clickEmployeeLink();
        employeePage.verifyReimbursementPage();

        
    }



    
}
