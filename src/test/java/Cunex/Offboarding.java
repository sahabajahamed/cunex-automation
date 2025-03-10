package Cunex;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Offboarding extends Basepage {
    @BeforeMethod
    void setup() {
        Basepage basepage = new Basepage();
        basepage.signIn();
        TestLogin tl = new TestLogin();
        tl.login();
        if (Basepage.driver == null) {
            throw new IllegalStateException("WebDriver is not initialized. Check Basepage.signIn()");
        }
    }

    @Test
    void offboarding() throws InterruptedException, AWTException {

        Locators input = new Locators(Basepage.driver);
        // input.clickHumanResources();
        // Actions actions = new Actions(Basepage.driver);
        // actions.scrollByAmount(0, 500).perform();
        // input.clickEmployees();
        // Thread.sleep(6000);
        // Robot r1 = new Robot();
        // r1.mouseWheel(5);
        // r1.mouseMove(500, 500);
        // Thread.sleep(2000);
        // r1.keyPress(KeyEvent.VK_SHIFT);
        // Thread.sleep(2000);
        // r1.mouseWheel(5);
        // Thread.sleep(2000);
        // r1.keyRelease(KeyEvent.VK_SHIFT);
        // input.clickFirstActiveButton();
        // input.SelectStatus();
        // input.clickupdateBtn();
        // input.clickoffboardingYes();
        // input.checkOffMsg();
        // input.clickok();

        input.clickHumanResources();
        Actions actions = new Actions(Basepage.driver);
        actions.scrollByAmount(0, 500).perform();
        input.clickOffboarding();
        input.clickofftab();

        Thread.sleep(3000);
        // actions.sendKeys(Keys.PAGE_DOWN).perform();
        input.clickonFirstname();
        Thread.sleep(2000);
        WebDriver driver = Basepage.driver;
        String mainWindow = driver.getWindowHandle();

        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(mainWindow)) {
                driver.switchTo().window(window); // Switch to new window
                break;
            }

        }

        input.clickOffboarderEdit();
        input.selectTermReason();
        input.pickTermDate();
        input.EnterLastWorkdate();
        input.SelectRehirable();
        input.selectTermType();
        Thread.sleep(3000);
        input.SelectChecklists();
        input.ClickOffUpdate();
        input.checkOffToast();
        input.clickOffdoc();
        input.clickSfSetfield();
        Thread.sleep(2000);
        input.EnterofcName();
        input.Enter_Business_contact_name();
        actions.scrollByAmount(0, 500).perform();
        input.Enter_authorized_officer_name();
        input.Click_sf23_savefield();
        Thread.sleep(2000);
        input.Click_sf23_sign();
        input.Enter_sf23_signature();
        input.Click_sf23_submit_sign();
        input.click_sf23_confirmation();
        Thread.sleep(5000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        input.click_Termination_letter();
        input.Enter_position();
        Thread.sleep(2000);
        input.Enter_policy_name();
        input.Enter_details_Termination_Event();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        input.Enter_hr_representative();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(5000);
        input.click_termination_save_fields();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        input.click_termination_sign();
        Thread.sleep(2000);
        input.perform_sign();
        Thread.sleep(2000);
        input.click_acceptandsign();
        input.click_sign_confirmation();
        input.click_terminate();
        input.click_terminate_confirmation();

    }

    @AfterMethod
    void close() {
        Basepage.driver.quit();
    }

}
