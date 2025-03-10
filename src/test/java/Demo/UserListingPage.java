package Demo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.testng.Assert;
import pageObjects.LoginPage;

public class UserListingPage extends Launch {
    @BeforeClass
    void setup() {
        Launch lch = new Launch();
        lch.launch();

    }

    @Test
    void editusertest() throws InterruptedException, AWTException {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // To edit the user

        Locators run = new Locators(driver);
        Logintest login = new Logintest();
        login.testlogin();
        // Actions actions = new Actions(driver);
        // actions.sendKeys(Keys.PAGE_DOWN).perform();
        // Thread.sleep(2000);
        // run.clicknext();
        // run.clickedit();
        // run.selectgooglefolder("Harlan Estrada");
        // run.clickeditsavebutton();
        // run.userupdated();
        // Thread.sleep(2000);
        // // To delete the user
        // js.executeScript("window.history.back();");
        // js.executeScript("window.history.back();");
        // System.out.println(driver.getTitle());
        // Thread.sleep(2000);
        // actions.sendKeys(Keys.PAGE_DOWN).perform();
        // Thread.sleep(2000);
        // run.clicknext();
        // Thread.sleep(2000);
        // run.clickdeleteicon();
        // run.clickdeleteconfirmation();

        // update the status and check whether status updated on the listing page
        Thread.sleep(2000);
        run.clickstatusedit();
        run.selectstatus();
        run.clickeditsavebutton();
        run.copyfirstName();
        Thread.sleep(2000);
        driver.navigate().back();
        driver.navigate().back();
        Thread.sleep(2000);
        run.pastefirstname();
        Thread.sleep(2000);
        run.seeStatusCheck();
        Thread.sleep(2000);
    }

    // To check that when user select active from the filter then in the table all
    // active status should be visible
    @Test
    void filterTest() throws InterruptedException, AWTException {
        Locators run = new Locators(driver);
        Logintest login = new Logintest();
        login.testlogin();
        Thread.sleep(2000);
        run.selectstatusfilter();
        Thread.sleep(2000);
        Robot rb = new Robot();
        rb.delay(200);
        rb.mouseMove(600, 450);
        rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        // run.AreAllstatuscheck();
        // Thread.sleep(2000);
        for (int i = 0; i <= 8; i++) {
            Thread.sleep(2000);
            run.AreAllstatuscheck();
        Thread.sleep(2000);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(2000);
            run.clickNextPage();
            Thread.sleep(2000);
            run.AreAllstatuscheck();
        }

    }

    // @AfterClass
    // void teardown() {
    //     driver.quit();

    // }

}
