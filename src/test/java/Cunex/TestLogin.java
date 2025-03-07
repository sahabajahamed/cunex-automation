package Cunex;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonSerializable.Base;

public class TestLogin extends Basepage {
    @BeforeMethod
    void setup() {
        Basepage bp = new Basepage();
        bp.signIn();
    }
    @Test
    void login()
    {
        Locators input = new Locators(driver);
        input.enterUsername();
        input.enterPassword();
        input.clickLoginButton();
        
    }

    @AfterMethod
    void tearDown() {
        driver.quit();
    }

}
