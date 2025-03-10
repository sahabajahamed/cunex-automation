package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageObjects.DashboardPage;
import pageObjects.EmployeePage;
import pageObjects.LoginPage;

public class EmployeeTest extends BaseTest {

    private LoginPage loginpage;
    private DashboardPage dashboardPage;
    private EmployeePage employeePage;
      private ExtentReports extent;
    private ExtentTest test;

    


    @Test
    public void verifyAddReimbursement() throws InterruptedException
    {

        loginpage = new LoginPage(driver);
        loginpage.loginPerform(" Cunex Inc.", "Thenewpasswordiscunex@362");
        test.info("Performed login");

        Assert.assertEquals(loginpage.SucessfullyMessage(), "Dashboard", "Login fail");
        test.pass("Login successful");

        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickHumenResource();
        test.info("Navigated to Human Resource");

        employeePage = new EmployeePage(driver);
        employeePage.clickEmployeeLink();
        test.info("Clicked on Employee link");

        employeePage.verifyReimbursementPage();
        test.info("Verified Reimbursement Page");

        employeePage.selectReimbursementEmployeeFromDropdown();
        test.info("Selected reimbursement employee from dropdown");

        employeePage.selectDateFieldFromCalender();
        test.info("Selected date from calendar");

        employeePage.enterReimbursementAmount(randomNumber(3));
        test.info("Entered reimbursement amount");

        employeePage.writeDescriptionForReimbursement(randomString(40));
        test.info("Entered description for reimbursement");

        employeePage.chouseImages();
        test.info("Chose images");

        Thread.sleep(3000);

        employeePage.createReimbursement();
        test.info("Created reimbursement");

        Thread.sleep(5000);
        test.pass("Reimbursement added successfully");
            
           

        }
       


        
    }



    

