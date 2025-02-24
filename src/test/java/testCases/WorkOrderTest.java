package testCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.WorkOrderPage;

public class WorkOrderTest extends BaseTest {


    private LoginPage loginpage;
    private DashboardPage dashboardPage;
    private  WorkOrderPage workOder;
   
    @Test
    public void Verify_Complete_to_Pending_WorkOrder() 
    {

        loginpage = new LoginPage(driver);
        loginpage.loginPerform("Cunex Inc.", "123456");
        Assert.assertEquals(loginpage.SucessfullyMessage(), "Dashboard", "Login failed!");

        dashboardPage = new DashboardPage(driver);
        dashboardPage.clickMaintance();

        workOder = new WorkOrderPage(driver);
        workOder.click_WorkOrder();
        workOder.click_Complete_tab();

        int num = 10;

        while (num > 0) {
            try {
                workOder.click_Pending_Button(); // Click Pending
                workOder.click_Yes_button(); // Click Yes
                workOder.selectDropdown(1); // Select an option from dropdown
                workOder.click_OK_button(); // Click OK
                workOder.click_OK_button(); // Confirm OK
                System.out.println("Successfully moved work order to Pending");
            } catch (Exception e) {
                System.out.println("Error processing work order: " + e.getMessage());
            }

            num--; // Decrement counter
        }

    }
@Test
public void Verify_Pending_to_Complete_workOrder()
{
    loginpage = new LoginPage(driver);
    loginpage.loginPerform("Cunex Inc.", "123456");
    Assert.assertEquals(loginpage.SucessfullyMessage(), "Dashboard", "Login failed!");

    dashboardPage = new DashboardPage(driver);
    dashboardPage.clickMaintance();

    workOder = new WorkOrderPage(driver);
    workOder.click_WorkOrder();
    int num = 10;
    while(num!=0)
    {
        try {
            workOder.click_Complete_Button(); // Click complete
            workOder.click_Yes_button(); // Click Yes
            workOder.selectDropdown(1); // Select an option from dropdown
            workOder.click_OK_button(); // Click OK
            workOder.click_OK_button(); // Confirm OK
            System.out.println("Successfully moved work order to Pending");
        } catch (Exception e) {
            System.out.println("Error processing work order: " + e.getMessage());
        }

        num--; // Decrement counter
    }
}
    
}
