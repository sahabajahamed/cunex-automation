package Demo;

import java.awt.AWTException;

import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class adduser extends Launch{
    // @BeforeMethod
    // void setup() {
    //     Launch lch = new Launch();
    //     lch.launch();

    // }

    @Test
    void testlogin() throws InterruptedException {
        Launch lch = new Launch();
        lch.launch();
        Locators run = new Locators(driver);
        // run.setusername("Admin");
        // run.setpassword("123456");
        // run.clicksignin();
        // Thread.sleep(2000);
        run.clickusers();
        Thread.sleep(2000);
        run.clickuserlist();              

        for (int i = 0; i < 10; i++) {
            run.clickaddnewuser();
            Thread.sleep(2000);

            try {
                run.clickcameraicon();
            } catch (AWTException e) {
                e.printStackTrace();
            }
            // Thread.sleep(2000);
            // run.setfirstname(Launch.randomstring());
            // run.setlastname(Launch.randomstring());
            // run.setemail(Launch.randomemail());
            // run.setUsername(Launch.randomstring());
            // run.setphone(Launch.randomnumber());
            // Thread.sleep(2000);
            // Actions actions = new Actions(driver);
            // actions.sendKeys(Keys.PAGE_DOWN).perform();
            // Thread.sleep(2000);
            // run.clicksave();
            // run.usercreated();
            // Thread.sleep(2000);
        }

    }

    @AfterClass
    void teardown() {
        driver.quit();

    }
}
