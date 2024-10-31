package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EquipmentPage extends BasePage {
    public EquipmentPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    @FindBy(xpath = "//a[@id='arrow-equipment']")
    private WebElement Equipmentsmenu;
    @FindBy(xpath = "//h2[normalize-space()='Equipment']")
    private WebElement equipemtstext;
    @FindBy(xpath = "//a[normalize-space()='Add Scanner']")
    private WebElement addscanner;
    @FindBy(xpath = "//h5[normalize-space()='Add Scanner']")
    private WebElement addscannertext;
    @FindBy(xpath = "//input[@id='scanner_number']")
    private WebElement scannernumber;
    @FindBy(xpath = "//input[@id='serial_no']")
    private WebElement serialnumber;
    @FindBy(xpath = "//input[@id='imei_no']")
    private WebElement IMEIno;
    @FindBy(xpath = "//input[@id='mobile_number']")
    private WebElement MobileNumber;
    @FindBy(xpath = "//select[@id='scanner_inventory']")
    private WebElement scannerInventory;
    @FindBy(xpath = "//button[@id='add_scanner_btn']")
    private WebElement addscannerbtn_2;
    @FindBy(xpath = "//button[@class='scanner_delete_btn btn btn-sm btn-outline-danger']")
    private List<WebElement> deleteBtn;
    @FindBy(xpath = "//button[normalize-space()='Yes']")
    private WebElement deleteYes;

    public void equipments() {
        Equipmentsmenu.click();
    }

    public String equipmenttext() {
        return equipemtstext.getText();
    }

    public void addscannerBtn() {
        addscanner.click();
    }

    public String addscannertextvalid() {
        return addscannertext.getText();
    }

    public void scannerNumber(String s) {
        scannernumber.sendKeys(s);
    }

    public void serialNumber(String serialNO) {
        serialnumber.sendKeys(serialNO);
    }

    public void emeino(String Emeino) {
        IMEIno.sendKeys(Emeino);
    }

    public void Mobileno(String mobno) {
        MobileNumber.sendKeys(mobno);
    }

    public void selectScannerInventory() {
        getSelect(scannerInventory).selectByVisibleText("Office");
    }

    public void addscannerBtn_2() {
        addscannerbtn_2.click();
    }

    public void deleteButton() throws InterruptedException {
        for (WebElement webElement : deleteBtn) {
            webElement.click();
            Thread.sleep(2000);
            deleteYes.click();
            Thread.sleep(2000);
        }
    }

}
