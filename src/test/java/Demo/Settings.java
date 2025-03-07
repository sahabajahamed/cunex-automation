package Demo;

import java.awt.AWTException;
import java.awt.Desktop.Action;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Settings extends Launch {
    @BeforeClass
    void setup() {
        Launch lch = new Launch();
        lch.launch();

    }

    @Test
    void updateSettings() throws InterruptedException {
        Locators run = new Locators(driver);
        run.setusername("Admin");
        run.setpassword("123456");
        run.clicksignin();
        Thread.sleep(2000);
        run.clicksettings();
        String settingpage = driver.getTitle();
        System.out.println(settingpage);
        run.setTitle(randomstring());
        run.setDescription(
                "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.");
        Thread.sleep(2000);
        try {
            run.clickcameraicon();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        
        Actions action = new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        run.setEmail(randomemail());
        action.sendKeys(Keys.PAGE_UP).perform();
        run.setFbAppid(randomnumber());
        action.sendKeys(Keys.PAGE_DOWN).perform();
        run.clicksettingsSavechanges();
        Thread.sleep(2000);

    }

    @AfterClass
    void teardown() {
        driver.quit();

    }

}
