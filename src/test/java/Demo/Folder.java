package Demo;

import java.awt.AWTException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Folder extends Launch {
    @BeforeClass
    void setup() {
        Launch lch = new Launch();
        lch.launch();

    }

    @Test
    void testlogin() throws InterruptedException {
        Locators run = new Locators(driver);
        run.setusername("Admin");
        run.setpassword("123456");
        run.clicksignin();
        Thread.sleep(2000);
        run.clickFolder();
        run.clickAddFolder();
        run.setFolderName("akash");
        run.clickFolderSubmit();
    }

    @Test
    void Editfolder() throws InterruptedException, AWTException {
        Locators run = new Locators(driver);
        run.setusername("Admin");
        run.setpassword("123456");
        run.clicksignin();
        Thread.sleep(2000);
        run.clickFolder();
        String folderpage = driver.getTitle();
        System.out.println(folderpage);
        Thread.sleep(2000);
        run.clickEditFolder();
        run.EditFolderName();
        run.clicksubmit();

    }
    @Test
    void DeleteFolder() throws InterruptedException
    {
        Locators run = new Locators(driver);
        run.setusername("Admin");
        run.setpassword("123456");
        run.clicksignin();
        Thread.sleep(2000);
        run.clickFolder();
        run.clickFolderDeleteIcon();
        run.clickdeleteconfirmation();

    }

    @AfterClass
    void teardown() {
        driver.quit();

    }
}
