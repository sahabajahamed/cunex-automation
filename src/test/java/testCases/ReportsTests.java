package testCases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.ReportsPage;

public class ReportsTests extends BaseTest{
    private WebDriver driver;
    private LoginPage loginPage;
    private ReportsPage reportsPage;
    private DashboardPage dasboard;

    @Test
    public void reportslinkHeader()
    {
        loginPage= new LoginPage(driver);
		loginPage.loginPerform(" Cunex Inc.", "Thenewpasswordiscunex@362");
        dasboard.clickReports();
        
        List<WebElement> links = reportsPage.getBlankTargetLinks();
        for (WebElement link : links) {
            String mainTab = driver.getWindowHandle();
            link.click();

            Set<String> allTabs = driver.getWindowHandles();
            for (String tab : allTabs) {
                if (!tab.equals(mainTab)) {
                    driver.switchTo().window(tab);
                    break;
                }
                  driver.close();
                 driver.switchTo().window(mainTab);
            }
            // Verify the header text in the new tab
            String actualHeaderText = reportsPage.getHeaderText();
            String expectedHeaderText = link.getText(); //
            
    }
    


    
}
}