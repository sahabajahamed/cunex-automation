package testCases;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.BasePage;
import pageObjects.DashboardPage;
import pageObjects.EquipmentPage;
import pageObjects.LoginPage;

public class Equipment extends BaseTest {
    @Test(priority = 1)
    public void addEquipmenttest() throws InterruptedException {
        LoginPage l1 = new LoginPage(driver);
        l1.loginPerform("Dhl", "Dhl123456@");
        DashboardPage d1 = new DashboardPage(driver);
        d1.clickAssets();
        EquipmentPage e1 = new EquipmentPage(driver);
        e1.equipments();
        Thread.sleep(2000);
        Assert.assertEquals(e1.equipmenttext(), "Equipment", "Equipment page is not opening");
        int createCount = 10;
        while (createCount != 0) {
            e1.addscannerBtn();
            Thread.sleep(2000);
            Assert.assertEquals(e1.addscannertextvalid(), "Add Scanner");
            e1.scannerNumber(randomNumber(5));
            e1.serialNumber(randomNumber(6));
            e1.emeino(randomNumber(4));
            e1.Mobileno(randomNumber(10));
            e1.selectScannerInventory();
            Thread.sleep(2000);
            e1.addscannerBtn_2();
            Thread.sleep(2000);

            createCount--;
        }

    }


    @Test(priority = 2)
    public void deleteEquipment() throws InterruptedException {
        LoginPage l1 = new LoginPage(driver);
        l1.loginPerform("Dhl", "Dhl123456@");
        DashboardPage d1 = new DashboardPage(driver);
        d1.clickAssets();
        EquipmentPage e1 = new EquipmentPage(driver);
        e1.equipments();
        Thread.sleep(2000);
        Assert.assertEquals(e1.equipmenttext(), "Equipment", "Equipment page is not opening");
        e1.deleteButton();

    }



    

}
