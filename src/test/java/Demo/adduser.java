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

public class adduser extends Launch {
    // @BeforeMethod
    // void setup() {
    // Launch lch = new Launch();
    // lch.launch();

    // }

    @Test
    void testlogin() throws InterruptedException {
        Launch lch = new Launch();
        lch.launch();
        Locators run = new Locators(driver);
        run.setusername("Admin");
        run.setpassword("123456");
        run.clicksignin();
        Thread.sleep(2000);
        run.clickusers();
        Thread.sleep(2000);
        run.clickuserlist();

        for (int i = 0; i < 1; i++) {
            run.clickaddnewuser();
            Thread.sleep(2000);

            try {
                run.clickcameraicon();
            } catch (AWTException e) {
                e.printStackTrace();
            }
            Thread.sleep(2000);
            run.setfirstname(Launch.randomstring());
            run.setlastname(Launch.randomstring());
            run.setemail(Launch.randomemail());
            run.setUsername(Launch.randomstring());
            run.setphone(Launch.randomnumber());
            Thread.sleep(2000);
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            Thread.sleep(2000);
            run.clicksave();
            run.usercreated();
            Thread.sleep(2000);
        }

    }

    // Verify that when the user clicks the Save button without entering input in
    // all required text fields, appropriate error messages are displayed.
    @Test
    void AddUser() throws InterruptedException {
        Launch lch = new Launch();
        lch.launch();
        Locators run = new Locators(driver);
        run.clickaddnewuser();
        run.setfirstname("");
        run.setlastname("");
        run.setemail("");
        run.setUsername("");
        run.setphone("");
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        run.clicksave();
        Thread.sleep(2000);
        run.check_fname();
        run.check_Lname();
        run.check_email();
        run.check_username();
        run.check_phone();

    }

    // When a user enters only spaces in the First Name or Last Name text field, a
    // proper error message should be displayed, but it is either missing or not
    // functioning correctly.
    @Test
    void adduser2() throws InterruptedException {
        Launch lch = new Launch();
        lch.launch();
        Locators run = new Locators(driver);
        run.setfirstname(" ");
        run.setlastname(" ");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        run.clicksave();
        run.check_fname_2();
        run.check_Lname_2();

    }

    // When a user enters numbers in the First Name or Last Name text field and
    // clicks Save, a proper error message should be displayed, but it is either
    // missing or not functioning correctly.
    @Test
    void adduser3() throws InterruptedException {
        Launch lch = new Launch();
        lch.launch();
        Locators run = new Locators(driver);
        run.setfirstname("4635463");
        run.setlastname("46354653");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        run.clicksave();
        run.check_fname_2();
        run.check_Lname_2();
    }

    // When a user enters special characters in the First Name or Last Name text
    // fields and clicks Save, a proper error message should be displayed, but it is
    // either missing or not functioning correctly.
    @Test
    void adduser4() throws InterruptedException {
        Launch lch = new Launch();
        lch.launch();
        Locators run = new Locators(driver);
        run.clear_firstname();
        run.clear_lastname();
        run.setfirstname("^%^%^%^%^%");
        run.setlastname("^&%^%^%^%^%");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        run.clicksave();
        run.check_fname_2();
        run.check_Lname_2();
    }

    // When a user enters an invalid email format in the email text field and clicks
    // Save, a proper error message should be displayed, but it is either missing or
    // not functioning correctly.
    @Test
    void adduser5() throws InterruptedException {
        Launch lch = new Launch();
        lch.launch();
        Locators run = new Locators(driver);
        run.clear_email();
        run.setemail("fgfgdg");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        run.clicksave();
        run.Email_tooltip();

    }

    // When a user enters an invalid email format in the email text field and clicks
    // Save, a proper error message should be displayed, but it is either missing or
    // not functioning correctly.
    @Test
    void adduser6() throws InterruptedException {
        Launch lch = new Launch();
        lch.launch();
        Locators run = new Locators(driver);
        run.clear_email();
        run.setemail("fghgfhg@.com");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        run.clicksave();
        run.Email_tooltip2();
    }

    // When a user enters an already existing email address in the email text field
    // and clicks Save, a proper error message should be displayed, but it is either
    // missing or not functioning correctly.
    @Test
    void adduser7() throws InterruptedException {
        Launch lch = new Launch();
        lch.launch();
        Locators run = new Locators(driver);
        run.clear_email();
        run.clickusers();
        run.clickuserlist();
        Thread.sleep(2000);
        String email_text = run.check_email2();
        run.clickaddnewuser();
        run.setemail(email_text);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        run.clicksave();
        run.check_email3();

    }

    // When a user enters a space in the username text field and clicks Save, a
    // proper error message should be displayed, but it is either missing or not
    // functioning correctly.
    @Test
    void adduser8() throws InterruptedException {
        Launch lch = new Launch();
        lch.launch();
        Locators run = new Locators(driver);
        run.clear_email();
        run.setUsername(" ");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        run.clicksave();
        run.check_username2();

    }

    // To check that when the user enters only numbers in the username field, the
    // system should accept the input.
    @Test
    void adduser9() throws InterruptedException, AWTException {
        Launch lch = new Launch();
        lch.launch();
        Locators run = new Locators(driver);
        run.clickcameraicon();
        Thread.sleep(2000);
        run.setfirstname(Launch.randomstring());
        run.setlastname(Launch.randomstring());
        run.setemail(Launch.randomemail());
        run.setUsername("3543654");
        run.setphone(Launch.randomnumber());
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        run.clicksave();
        run.usercreated();
        Thread.sleep(2000);

    }

    // To check that when the user enters only alphabets in the username field, the
    // system should accept the input.
    @Test
    void adduser10() throws AWTException, InterruptedException {
        Launch lch = new Launch();
        lch.launch();
        Locators run = new Locators(driver);
        run.clickaddnewuser();
        run.clickcameraicon();
        Thread.sleep(2000);
        run.setfirstname(Launch.randomstring());
        run.setlastname(Launch.randomstring());
        run.setemail(Launch.randomemail());
        run.setUsername("reryery");
        run.setphone(Launch.randomnumber());
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        run.clicksave();
        run.usercreated();
        Thread.sleep(2000);
    }

    // To check that when the user enters special characters in the username field,
    // the system should display a proper error message and prevent submission.
    @Test
    void adduser11() throws InterruptedException {
        Launch lch = new Launch();
        lch.launch();
        Locators run = new Locators(driver);
        run.clickaddnewuser();
        run.setUsername("%$%$%$");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        run.clicksave();
        run.check_username3();

    }
    // To check that when the user enters less than the minimum required characters
    // in the username field, the system should display a proper error message.

    @Test
    void adduser12() throws InterruptedException {
        Launch lch = new Launch();
        lch.launch();
        Locators run = new Locators(driver);
        run.clear_username();
        run.setUsername("12");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        run.clicksave();
        run.check_username2();

    }

    // To check that when the user enters more than the maximum allowed characters
    // in the username field, the system should display a proper error message.
    @Test
    void adduser13() throws InterruptedException {
        Launch lch = new Launch();
        lch.launch();
        Locators run = new Locators(driver);
        run.clear_username();
        run.setUsername("122345675898456345623");
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        run.clicksave();
        run.check_username2();

    }

    // To check that when the user enters a username that already exists, the system
    // should display a proper error message.
    @Test
    void adduser14() throws InterruptedException {
        Launch lch = new Launch();
        lch.launch();
        Locators run = new Locators(driver);
        run.clear_username();
        run.clickusers();
        run.clickuserlist();
        run.clickedit();
        String U_name = run.get_editprofile_username();
        run.clickusers();
        Thread.sleep(2000);
        run.click_adduser();
        run.clear_username();
        run.setUsername(U_name);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        run.clicksave();
        run.check_username4();

    }

    // When the user enters an insufficient phone number (fewer digits than the
    // required format) in the phone number field and attempts to save or submit, a
    // proper error message should be displayed.
    @Test
    void adduser15() {
        Launch lch = new Launch();
        lch.launch();
        Locators run = new Locators(driver);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        run.setphone("33434434");
        run.clicksave();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        run.check_phone_msg();

    }

    // When the user enters special characters in the phone number text field and
    // attempts to save or submit, a proper error message should be displayed.
    @Test
    void adduser16() {
        Launch lch = new Launch();
        lch.launch();
        Locators run = new Locators(driver);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        run.clear_phoneno();
        run.setphone("^%^^%^%");
        run.clicksave();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        run.check_phone_msg();
    }

    // When the user enters maximum input in the phone number text field and
    // attempts to save or submit, a proper error message should be displayed.
    @Test
    void adduser17() {
        Launch lch = new Launch();
        lch.launch();
        Locators run = new Locators(driver);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        run.clear_phoneno();
        run.setphone("3754364536453645365463");
        run.clicksave();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        run.check_phone_msg();
    }

    // When the user selects a video instead of an image for the profile picture, a
    // proper error message should be displayed.
    @Test
    void adduser18() throws AWTException, InterruptedException {
        Launch lch = new Launch();
        lch.launch();
        Locators run = new Locators(driver);
        Actions actions = new Actions(driver);
        // actions.sendKeys(Keys.PAGE_UP).perform();
        run.get_video_onprofile();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        run.clicksave();
        run.check_profile_msg();

    }
    //To check that when the user uploads a **.png file** as a profile picture, it should be accepted without any error.
    @Test
    void adduser19() throws InterruptedException, AWTException
    {
        Launch lch = new Launch();
        lch.launch();
        Locators run = new Locators(driver);
        Actions actions = new Actions(driver);
        run.get_video_onprofile_png();
        Thread.sleep(2000);
        run.setfirstname(Launch.randomstring());
        run.setlastname(Launch.randomstring());
        run.setemail(Launch.randomemail());
        run.setUsername(Launch.randomstring());
        run.setphone(Launch.randomnumber());
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        run.clicksave();
        if(run.usercreated_displayed()==true)
        {
            System.out.println("Testcase passed : .png file is accepting");
        }
        else
        {
            System.out.println("Testcase failed :.png file is not accepting");
        }
        Thread.sleep(2000);

    }
    //To check that when the user uploads a **.jpg file** as a profile picture, it should be accepted without any error.
    @Test
    void adduser20() throws AWTException, InterruptedException
    {
        Launch lch = new Launch();
        lch.launch();
        Locators run = new Locators(driver);
        Actions actions = new Actions(driver);
        run.clickaddnewuser();
        Thread.sleep(2000);
        run.get_video_onprofile_jpg();
        Thread.sleep(2000);
        run.setfirstname(Launch.randomstring());
        run.setlastname(Launch.randomstring());
        run.setemail(Launch.randomemail());
        run.setUsername(Launch.randomstring());
        run.setphone(Launch.randomnumber());
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        run.clicksave();
        if(run.usercreated_displayed()==true)
        {
            System.out.println("Testcase passed : .jpg file is accepting");
        }
        else
        {
            System.out.println("Testcase failed :.jpg file is not accepting");
        }
        Thread.sleep(2000);

    }

//To check that when the user uploads a **.jpeg file** as a profile picture, it should be accepted without any error.
@Test
void adduser21() throws AWTException, InterruptedException
    {
        Launch lch = new Launch();
        lch.launch();
        Locators run = new Locators(driver);
        Actions actions = new Actions(driver);
        run.clickaddnewuser();
        Thread.sleep(2000);
        run.get_video_onprofile_jpeg();                                                                             
        Thread.sleep(2000);
        run.setfirstname(Launch.randomstring());
        run.setlastname(Launch.randomstring());
        run.setemail(Launch.randomemail());
        run.setUsername(Launch.randomstring());
        run.setphone(Launch.randomnumber());
        Thread.sleep(2000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        run.clicksave();
        if(run.usercreated_displayed()==true)
        {
            System.out.println("Testcase passed : .jpeg file is accepting");
        }
        else
        {
            System.out.println("Testcase failed :.jpeg file is not accepting");
        }
        Thread.sleep(2000);

    }

    @AfterClass
    void teardown() {
        driver.quit();

    }
}
