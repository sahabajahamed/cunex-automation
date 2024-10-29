package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;


import pageObjects.DashboardPage;
import pageObjects.LoginPage;
import pageObjects.Onboardingpage;


public class OnboardingTest extends BaseTest {
@Test
    public void onboardingtestclick()
    {
        LoginPage l1=new LoginPage(driver);
        l1.loginPerform("Cunex Inc.", "Thenewpasswordiscunex@362");
        DashboardPage d1=new DashboardPage(driver);
        d1.clickHumenResource();
        Onboardingpage o1=new Onboardingpage(driver);
        o1.onboarding();
        Assert.assertEquals(o1.Onboardingtext(), "Onboarding Process","Onboarding system page is not getting");
        o1.addnewhire();
        Assert.assertEquals(o1.addnewhiretext(), "Add New Hire","addnewhire pop up is not displaying");
        
    }
}
