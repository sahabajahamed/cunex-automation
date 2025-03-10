package Cunex;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

public class JobListing {
    @BeforeMethod
    void signin() {
        Basepage bp = new Basepage();
        bp.signIn();
        TestLogin tl = new TestLogin();
        tl.login();
    }

    @Test
    void Joblisting() throws InterruptedException {
        Locators input = new Locators(Basepage.driver);
        input.clickHumanResources();
        input.clickAts();
        input.clickAddNewJob();
        input.selectJobType();
        input.selectDepartment();
        input.enterPayFrom();
        input.enterPayTo();
        input.selectPayType();
        input.enterPosition();
        input.enterLocation();
        Thread.sleep(2000);
        input.clickWarning();
        input.enterTruckType();
        input.enterQualification();
        Thread.sleep(2000);
        input.aboutCompany();
        Actions act = new Actions(Basepage.driver);
        act.sendKeys(Keys.PAGE_DOWN).perform();
        input.jobDescription();
        input.enterResponsibility();
        act.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        input.enterBenefits();
        input.selectJobStatus();
        input.selectEntity();
        input.ClickexperienceCheckbox();
        input.clickAddJob();
        input.clickYesWarning();
        input.getSucessfullmsg();

    }

    // To check that when user choose the question and click on save button then
    // sucessfull message should be display
    @Test
    void questionbank() throws InterruptedException {
        Locators input = new Locators(Basepage.driver);
        input.clickHumanResources();
        input.clickAts();
        input.clickQuestion();
        input.clickEditMode();
        input.clickQuestionsCheckbox();
        Thread.sleep(2000);
        input.clickSavequestion();
        input.getQuestionSaved();
    }

    // To check that if user remove the question from question list and then click
    // on save button then error message should bedisplay
    @Test
    void questionbank1() throws InterruptedException {
        Locators input = new Locators(Basepage.driver);
        input.clickHumanResources();
        input.clickAts();
        input.clickQuestion();
        input.clickEditMode();
        input.clickQuestionsCheckbox();
        Thread.sleep(2000);
        Actions act = new Actions(Basepage.driver);
        act.sendKeys(Keys.PAGE_DOWN).perform();
        input.clickRemove();
        input.clickSavequestion();
        act.sendKeys(Keys.PAGE_UP).perform();
        input.getNoquestions();

    }

    // To check that when user add question then sucuessfull message should be
    // display
    @Test
    void questionbank2() {
        Locators input = new Locators(Basepage.driver);
        input.clickHumanResources();
        input.clickAts();
        input.clickQuestion();
        input.clickEditMode();
        Actions act = new Actions(Basepage.driver);
        act.sendKeys(Keys.PAGE_DOWN).perform();
        input.clickAddQuestion();
        input.selectQuestionType();
        input.displayOptions();
        input.enterWriteYourQuestion();
        input.selectScreeningType();
        act.sendKeys(Keys.PAGE_UP).perform();
        input.clickSavequestion();
        input.getQuestionSaved();
    }

    // To check that when user add set then that set name should be visible in the
    // left
    @Test

    void questionbank3() throws InterruptedException {
        Locators input = new Locators(Basepage.driver);
        input.clickHumanResources();
        input.clickAts();
        input.clickQuestionBank();
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

        input.clickAddset();
        String one = input.EnterSetName();
        System.out.println(one);
        input.clickCreateButton();
        Thread.sleep(2000);
        String two = input.getQuestionTab();
        if (two.contains(one)) {
            System.out.println("set added properly");
        } else {
            System.out.println("set not added properly");
        }

    }

    // To check that when user edit setname then that set name should be visible in
    // the left
    @Test
    void Questionbank4() throws InterruptedException {
        Locators input = new Locators(Basepage.driver);
        input.clickHumanResources();
        input.clickAts();
        input.clickQuestionBank();
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
        input.editSetName();
        Thread.sleep(2000);
        String editset1 = input.updateQuestionSet();

        input.clickUpadteset();
        Thread.sleep(2000);
        String set2 = input.getQuestionTab();
        if (set2.contains(editset1)) {
            System.out.println("set added properly");
        } else {
            System.out.println("set not added properly");
        }

    }


    // @AfterMethod
    // void close() {
    //     Basepage.driver.quit();
    // }

}
