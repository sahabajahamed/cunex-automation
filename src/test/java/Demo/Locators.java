package Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.util.Assert;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.awt.AWTException;
import java.util.List;
import java.awt.Robot;
import org.openqa.selenium.interactions.Actions;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;

public class Locators {

    public static WebDriverWait wait;
    public static JavascriptExecutor js;

    public Locators(WebDriver driver) {

        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.js = (JavascriptExecutor) driver;

    }

    @FindBy(xpath = "//input[@placeholder='Username or Email']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='your-password']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement signin;
    @FindBy(xpath = "//span[text()='Users']")
    private WebElement users;
    @FindBy(xpath = "//a[normalize-space()='Users List']")
    private WebElement userslist;
    @FindBy(xpath = "//a[@class='btn btn-primary text-sm btn-sm px-12 py-12 radius-8 d-flex align-items-center gap-2']")
    private WebElement addnewuser;
    @FindBy(xpath = "//a[normalize-space()='Add User']")
    private WebElement adduser;

    String userimage = "src/test/java/Demo/image/Placeholder_Person.jpg";
    @FindBy(xpath = "//label[@for='imageUpload']")
    private WebElement cameraicon;
    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement firstname;
    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement lastname;
    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;
    @FindBy(xpath = "//input[@id='username']")
    private WebElement Username;
    @FindBy(xpath = "//input[@id='phone']")
    private WebElement phone;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement save;
    @FindBy(xpath = "//div[text()='User created successfully!']")
    private WebElement uesrcreated;
    @FindBy(xpath = "//button[normalize-space()='»']")
    private WebElement next;
    @FindBy(xpath = "(//iconify-icon[@icon='majesticons:eye-line'])[8]")
    private WebElement edit;
    @FindBy(xpath = "//select[@id='google_folder']")
    private WebElement googlefolderdropdown;
    @FindBy(xpath = "//button[normalize-space()='Save']")
    private WebElement editsavebutton;
    @FindBy(xpath = "//div[text()='User updated successfully!']")
    private WebElement userupdated;
    @FindBy(xpath = "(//iconify-icon[@icon='mingcute:delete-2-line'])[8]")
    private WebElement deleteicon;
    @FindBy(xpath = "//button[normalize-space()='Yes, delete it!']")
    private WebElement deleteconfirmation;
    @FindBy(xpath = "(//iconify-icon[@icon='majesticons:eye-line'])[1]")
    private WebElement statusedit;
    @FindBy(xpath = "//select[@id='status']")
    private WebElement statusdropdown;
    @FindBy(xpath = "//input[@class='dt-input']")
    private WebElement search;
    @FindBy(xpath = "//button[contains(text(),'›')]")
    private WebElement nextpage;

    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement searchname;

    @FindBy(xpath = "//table[@id='userTable']/tbody/tr/td[5]")
    private WebElement statuscheck;

    @FindBy(xpath = "//select[@id='statusFilter']")
    private WebElement statusfilter;

    @FindBy(xpath = "//table[@id='userTable']/tbody/tr/td[5]")
    private List<WebElement> Allstatuscheck;

    @FindBy(xpath = "//span[normalize-space()='Folder']")
    private WebElement folder;
    @FindBy(xpath = "//span[normalize-space()='Add Folder']")
    private WebElement addfolder;
    @FindBy(xpath = "//input[@id='folder_name']")
    private WebElement foldername;
    @FindBy(xpath = "//button[normalize-space()='Submit']")
    private WebElement FolderSubmit;
    @FindBy(xpath = "//body[1]/main[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/a[1]/iconify-icon[1]")
    private WebElement editfolder;
    @FindBy(xpath = "//input[@id='folder_names']")
    private WebElement Editfoldername;
    @FindBy(xpath = "//div[@id='folderModal']")
    private WebElement submitButton;
    @FindBy(xpath = "(//iconify-icon[@icon='mingcute:delete-2-line'])[1]")
    private WebElement FolderDeleteIcon;

    // settings

    @FindBy(xpath = "//span[text()='Settings']")
    private WebElement settings;
    @FindBy(xpath = "//input[@name='title']")
    private WebElement Title;
    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement Description;
    @FindBy(xpath = "//input[@name='from_email']")
    private WebElement settingsEmail;
    @FindBy(xpath = "//input[@name='fbapp_id']")
    private WebElement fbAppId;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    private WebElement settingsSavechanges;

    // inline error message for add user section
    @FindBy(xpath = "//p[text()='First name is required.']")
    private WebElement Fname_msg;
    @FindBy(xpath = "//p[text()='Last name is required.']")
    private WebElement Lname_msg;
    @FindBy(xpath = "//p[text()='Username is required.']")
    private WebElement User_name_msg;
    @FindBy(xpath = "//p[text()='Phone number is required.']")
    private WebElement Ph_no_msg;
    @FindBy(xpath = "//p[text()='Email is required.']")
    private WebElement Email_msg;
    @FindBy(xpath = "//p[text()='First name must contain only letters.']")
    private WebElement Fname_msg_2;
    @FindBy(xpath = "//p[text()='Last name must contain only letters.']")
    private WebElement Lname_msg_2;
    @FindBy(xpath = "//table[@id='userTable']/tbody/tr[1]/td[3]")
    private WebElement usertable_email;
    @FindBy(xpath = "//p[text()='Email is already registered.']")
    private WebElement Email_msg2;
    @FindBy(xpath = "//p[text()='Username must be between 3 and 20 characters.']")
    private WebElement user_name_msg2;

    @FindBy(xpath = "//p[text()='Username can only contain letters, numbers, underscores, and hyphens.']")
    private WebElement user_name_msg3;
    @FindBy(xpath = "//p[text()='This username is already taken.']")
    private WebElement user_name_msg4;
    @FindBy(xpath = "//p[text()='Invalid phone number format.']")
    private WebElement phone_msg;

    @FindBy(xpath = "//p[text()='Profile image must be a .png, .jpg, or .jpeg file.']")
    private WebElement profile_msg;
    // Editprofile username
    @FindBy(xpath = "//input[@id='username']")
    private WebElement editprofile_username;

    public void setusername(String user) {
        username.sendKeys(user);
    }

    public void setpassword(String pass) {
        password.sendKeys(pass);
    }

    public void clicksignin() {
        signin.click();
    }

    public void clickusers() {
        users.click();
    }

    public void clickuserlist() {
        userslist.click();
    }

    public void clickaddnewuser() {
        addnewuser.click();
    }

    public void clickcameraicon() throws AWTException, InterruptedException {

        cameraicon.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='imageUpload']")));
        Robot rb = new Robot();
        rb.delay(200);
        rb.mouseMove(500, 450);
        Thread.sleep(2000);
        rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        String word = "Screenshot"; // Change this to the word you want to type

        for (char c : word.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            if (KeyEvent.CHAR_UNDEFINED == keyCode) {
                throw new RuntimeException("Key code not found for character '" + c + "'");
            }

            rb.keyPress(keyCode);
            rb.keyRelease(keyCode);
        }
        Thread.sleep(2000);
        rb.keyPress(KeyEvent.VK_DOWN);
        rb.keyRelease(KeyEvent.VK_DOWN);
        rb.keyPress(KeyEvent.VK_DOWN);
        rb.keyRelease(KeyEvent.VK_DOWN);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

    }

    public void setfirstname(String fname) {
        this.firstname.sendKeys(fname);

    }

    public void setlastname(String lname) {
        this.lastname.sendKeys(lname);
    }

    public void setemail(String mail) {
        this.email.sendKeys(mail);
    }

    public void setUsername(String uname) {
        this.Username.sendKeys(uname);
    }

    public void setphone(String phn) {
        this.phone.sendKeys(phn);
    }

    public void clicksave() {
        this.save.click();
    }

    public void usercreated() {

        String actualmesg = uesrcreated.getText();
        String expectedmesg = "User created successfully!";
        if (actualmesg.equals(expectedmesg)) {
            System.out.println("User created successfully");
        } else {
            System.out.println("User not created");
        }
    }

    public void clicknext() {
        next.click();
    }

    public void clickedit() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("(//iconify-icon[@icon='majesticons:eye-line'])[8]")));
        edit.click();
    }

    public void selectgooglefolder(String folder) {
        Select select = new Select(googlefolderdropdown);
        select.selectByVisibleText(folder);
    }

    public void clickeditsavebutton() {
        editsavebutton.click();
    }

    public void userupdated() {
        String actualmesg = userupdated.getText();
        String expectedmesg = "User updated successfully!";
        if (actualmesg.equals(expectedmesg)) {
            System.out.println("User updated successfully");
        } else {
            System.out.println("User not updated");
        }
    }

    public void clickdeleteicon() {
        deleteicon.click();
    }

    public void clickdeleteconfirmation() {
        deleteconfirmation.click();
    }

    public void clickstatusedit() {
        statusedit.click();
    }

    public String selectstatus() {
        Select select = new Select(statusdropdown);
        select.selectByVisibleText("Inactive");
        String inact = statusdropdown.getText();
        return inact;
    }

    public String dropdowntext() {
        Select select1 = new Select(statusdropdown);
        String inact = statusdropdown.getText();
        return inact;
    }

    public void copyfirstName() throws AWTException, InterruptedException {
        searchname.click();
        Thread.sleep(2000);
        Robot rb1 = new Robot();
        rb1.keyPress(KeyEvent.VK_CONTROL);
        rb1.keyPress(KeyEvent.VK_A);
        rb1.keyRelease(KeyEvent.VK_A);
        rb1.keyRelease(KeyEvent.VK_CONTROL);
        rb1.keyPress(KeyEvent.VK_CONTROL);
        rb1.keyPress(KeyEvent.VK_C);
        rb1.keyRelease(KeyEvent.VK_C);
        rb1.keyRelease(KeyEvent.VK_CONTROL);
    }

    public void pastefirstname() throws AWTException {
        search.click();
        Robot rb2 = new Robot();
        rb2.keyPress(KeyEvent.VK_CONTROL);
        rb2.keyPress(KeyEvent.VK_V);
        rb2.keyRelease(KeyEvent.VK_V);
        rb2.keyRelease(KeyEvent.VK_CONTROL);

    }

    public void seeStatusCheck() {
        String status = statuscheck.getText();
        System.out.println(status);
        if (status.equals("Inactive")) {
            System.out.println("Status updated successfully");
        } else {
            System.out.println("Status not updated");
        }
    }

    public void selectstatusfilter() {
        Select select = new Select(statusfilter);
        select.selectByVisibleText("Active");
    }

    public Void AreAllstatuscheck() {

        List<WebElement> statusList = Allstatuscheck;
        boolean datastatus = false;

        for (WebElement element : statusList) {

            String value = element.getText();
            // System.out.println(value);
            if (value.contains("Inactive")) {
                datastatus = true;
            } else {
                datastatus = false;
                System.out.println("all status is active");
            }

        }

        return null;
    }

    public void clickNextPage() {
        nextpage.click();
    }

    public void clickFolder() {
        folder.click();

    }

    public void clickAddFolder() {
        addfolder.click();
    }

    public void setFolderName(String fname) {
        foldername.sendKeys(fname);
    }

    public void clickFolderSubmit() {
        FolderSubmit.click();
    }

    public void clickEditFolder() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(
                        "//body[1]/main[1]/div[2]/div[2]/div[2]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[3]/a[1]/iconify-icon[1]")));
        editfolder.click();
    }

    public void EditFolderName() throws AWTException, InterruptedException {

        // js.executeScript("arguments[0].removeAttribute('disabled');",
        // Editfoldername);
        Thread.sleep(500);
        Editfoldername.click();
        Editfoldername.clear();
        Editfoldername.sendKeys(Launch.randomstring());

        Thread.sleep(2000);
        // Robot rb3 = new Robot();

        // rb3.keyPress(KeyEvent.VK_CONTROL);
        // rb3.keyPress(KeyEvent.VK_A);
        // rb3.keyRelease(KeyEvent.VK_A);
        // rb3.keyRelease(KeyEvent.VK_CONTROL);
        // rb3.keyPress(KeyEvent.VK_BACK_SPACE);
        // Editfoldername.sendKeys(Launch.randomstring());
    }

    public void clicksubmit() {
        submitButton.click();
    }

    public void clickFolderDeleteIcon() {
        FolderDeleteIcon.click();
    }

    // settings

    public void clicksettings() {
        settings.click();

    }

    public void setTitle(String title) {
        Title.clear();

        Title.sendKeys(title);
    }

    public void setDescription(String desc) {
        Description.clear();
        Description.sendKeys(desc);

    }

    public void setEmail(String email) {
        settingsEmail.clear();
        settingsEmail.sendKeys(email);
    }

    public void setFbAppid(String FbAppId) {
        fbAppId.clear();
        fbAppId.sendKeys(FbAppId);

    }

    public void clicksettingsSavechanges() {
        settingsSavechanges.click();
    }

    // add user e inline error msg validation
    public void check_fname() {

        String expectedError = "First name is required.";
        String actualError = Fname_msg.getText();
        ;

        if (actualError.equals(expectedError)) {
            System.out.println("Test Passed: Correct inline error displayed.");
        } else {
            System.out.println("Test Failed: Expected '" + expectedError + "' but got '" + actualError + "'");
        }
    }

    public void check_Lname() {
        String expectedError = "Last name is required.";
        String actualError = Lname_msg.getText();
        ;

        if (actualError.equals(expectedError)) {
            System.out.println("Test Passed: Correct inline error displayed.");
        } else {
            System.out.println("Test Failed: Expected '" + expectedError + "' but got '" + actualError + "'");
        }
    }

    public void check_email() {
        String expectedError = "Email is required.";
        String actualError = Email_msg.getText();
        ;

        if (actualError.equals(expectedError)) {
            System.out.println("Test Passed: Correct inline error displayed.");
        } else {
            System.out.println("Test Failed: Expected '" + expectedError + "' but got '" + actualError + "'");
        }
    }

    public void check_username() {
        String expectedError = "Username is required.";
        String actualError = User_name_msg.getText();
        ;

        if (actualError.equals(expectedError)) {
            System.out.println("Test Passed: Correct inline error displayed.");
        } else {
            System.out.println("Test Failed: Expected '" + expectedError + "' but got '" + actualError + "'");
        }
    }

    public void check_phone() {
        String expectedError = "Phone number is required.";
        String actualError = Ph_no_msg.getText();
        ;

        if (actualError.equals(expectedError)) {
            System.out.println("Test Passed: Correct inline error displayed.");
        } else {
            System.out.println("Test Failed: Expected '" + expectedError + "' but got '" + actualError + "'");
        }
    }

    public void check_fname_2() {
        String expectedError = "First name must contain only letters.";
        String actualError = Fname_msg_2.getText();
        ;

        if (actualError.equals(expectedError)) {
            System.out.println("Test Passed: Correct inline error displayed.");
        } else {
            System.out.println("Test Failed: Expected '" + expectedError + "' but got '" + actualError + "'");
        }
    }

    public void check_Lname_2() {
        String expectedError = "Last name must contain only letters.";
        String actualError = Lname_msg_2.getText();

        if (actualError.equals(expectedError)) {
            System.out.println("Test Passed: Correct inline error displayed.");
        } else {
            System.out.println("Test Failed: Expected '" + expectedError + "' but got '" + actualError + "'");
        }
    }

    public void clear_firstname() {
        firstname.clear();
    }

    public void clear_lastname() {
        lastname.clear();
    }

    public void Email_tooltip() {

        String tooltipMessage = (String) js.executeScript("return arguments[0].validationMessage;", email);

        // ✅ Expected tooltip message
        String expectedMessage = "Please include an '@' in the email address. 'fgfgdg' is missing an '@'.";

        // ✅ Using if-else instead of Assert
        if (tooltipMessage.equals(expectedMessage)) {
            System.out.println("Test Passed: Tooltip message is correct.");
        } else {
            System.out.println("Test Failed: Expected - " + expectedMessage + ", but got - " + tooltipMessage);
        }
    }

    public void clear_email() {
        email.clear();
    }

    public void Email_tooltip2() {
        String tooltipMessage = (String) js.executeScript("return arguments[0].validationMessage;", email);

        // ✅ Expected tooltip message
        String expectedMessage = "'.' is used at a wrong position in '.com'.";

        // ✅ Using if-else instead of Assert
        if (tooltipMessage.equals(expectedMessage)) {
            System.out.println("Test Passed: 2nd Tooltip message is correct.");
        } else {
            System.out.println("Test Failed: Expected - " + expectedMessage + ", but got - " + tooltipMessage);
        }
    }

    public String check_email2() {
        String print_email = usertable_email.getText();
        return print_email;
    }

    public void check_email3() {
        String expectedError = "Email is already registered.";
        String actualError = Email_msg2.getText();

        if (actualError.equals(expectedError)) {
            System.out.println(expectedError + "  Test Passed: Correct inline error displayed.");
        } else {
            System.out.println("Test Failed: Expected '" + expectedError + "' but got '" + actualError + "'");
        }
    }

    public void check_username2() {
        String expectedError = "Username must be between 3 and 20 characters.";
        String actualError = user_name_msg2.getText();

        if (actualError.equals(expectedError)) {
            System.out.println(expectedError + "  Test Passed: Correct inline error displayed.");
        } else {
            System.out.println("Test Failed: Expected '" + expectedError + "' but got '" + actualError + "'");
        }
    }

    public void clear_username() {
        Username.clear();
    }

    public void check_username3() {

        String expectedError = "Username can only contain letters, numbers, underscores, and hyphens.";
        String actualError = user_name_msg3.getText();

        if (actualError.equals(expectedError)) {
            System.out.println(expectedError + "  Test Passed: Correct inline error displayed.");
        } else {
            System.out.println("Test Failed: Expected '" + expectedError + "' but got '" + actualError + "'");
        }
    }

    public String get_editprofile_username() {
        String username_value = editprofile_username.getAttribute("value");
        return username_value;
    }

    public void check_username4() {
        String expectedError = "This username is already taken.";
        String actualError = user_name_msg4.getText();

        if (actualError.equals(expectedError)) {
            System.out.println(expectedError + "  Test Passed: Correct inline error displayed.");
        } else {
            System.out.println("Test Failed: Expected '" + expectedError + "' but got '" + actualError + "'");
        }
    }

    public void click_adduser() {
        adduser.click();
    }

    public void check_phone_msg() {
        String expectedError = "Invalid phone number format.";
        String actualError = phone_msg.getText();

        if (actualError.equals(expectedError)) {
            System.out.println(expectedError + "  Test Passed: Correct inline error displayed.");
        } else {
            System.out.println("Test Failed: Expected '" + expectedError + "' but got '" + actualError + "'");
        }
    }

    public void clear_phoneno() {
        phone.clear();
    }

    public void get_video_onprofile() throws AWTException, InterruptedException {
        cameraicon.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='imageUpload']")));
        Robot rb = new Robot();
        rb.delay(200);
        rb.mouseMove(500, 450);
        Thread.sleep(2000);
        rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        rb.keyPress(KeyEvent.VK_DOWN);
        rb.keyRelease(KeyEvent.VK_DOWN);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        String word = "Screencast"; // Change this to the word you want to type

        for (char c : word.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            if (KeyEvent.CHAR_UNDEFINED == keyCode) {
                throw new RuntimeException("Key code not found for character '" + c + "'");
            }

            rb.keyPress(keyCode);
            rb.keyRelease(keyCode);
        }
        Thread.sleep(2000);
        rb.keyPress(KeyEvent.VK_DOWN);
        rb.keyRelease(KeyEvent.VK_DOWN);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }

    public void check_profile_msg() {
        String expectedError = "Profile image must be a .png, .jpg, or .jpeg file.";
        String actualError = profile_msg.getText();

        if (actualError.equals(expectedError)) {
            System.out.println(expectedError + "  Test Passed: Correct inline error displayed.");
        } else {
            System.out.println("Test Failed: Expected '" + expectedError + "' but got '" + actualError + "'");
        }
    }

    public void get_video_onprofile_png() throws AWTException, InterruptedException {
        cameraicon.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='imageUpload']")));
        Robot rb = new Robot();
        rb.delay(200);
        rb.mouseMove(500, 450);
        Thread.sleep(2000);
        rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        rb.keyPress(KeyEvent.VK_DOWN);
        rb.keyRelease(KeyEvent.VK_DOWN);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        String word = ".png"; // Change this to the word you want to type

        for (char c : word.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            if (KeyEvent.CHAR_UNDEFINED == keyCode) {
                throw new RuntimeException("Key code not found for character '" + c + "'");
            }

            rb.keyPress(keyCode);
            rb.keyRelease(keyCode);
        }
        Thread.sleep(2000);
        rb.keyPress(KeyEvent.VK_DOWN);
        rb.keyRelease(KeyEvent.VK_DOWN);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }

    public boolean usercreated_displayed() {

        Boolean toast = uesrcreated.isDisplayed();
        return toast;
    }

    public void get_video_onprofile_jpg() throws AWTException, InterruptedException {
        cameraicon.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='imageUpload']")));
        Robot rb = new Robot();
        rb.delay(200);
        rb.mouseMove(500, 450);
        Thread.sleep(2000);
        rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        rb.keyPress(KeyEvent.VK_DOWN);
        rb.keyRelease(KeyEvent.VK_DOWN);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);
        String word = ".jpg"; // Change this to the word you want to type

        for (char c : word.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            if (KeyEvent.CHAR_UNDEFINED == keyCode) {
                throw new RuntimeException("Key code not found for character '" + c + "'");
            }

            rb.keyPress(keyCode);
            rb.keyRelease(keyCode);
        }
        Thread.sleep(2000);
        rb.keyPress(KeyEvent.VK_DOWN);
        rb.keyRelease(KeyEvent.VK_DOWN);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }

    public void get_video_onprofile_jpeg() throws AWTException, InterruptedException {
        cameraicon.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='imageUpload']")));
        Robot rb = new Robot();
        rb.delay(200);
        rb.mouseMove(550, 550);
        Thread.sleep(2000);
        rb.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(2000);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_TAB);
        rb.keyRelease(KeyEvent.VK_TAB);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(2000);
        String word = ".jpeg"; // Change this to the word you want to type

        for (char c : word.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            if (KeyEvent.CHAR_UNDEFINED == keyCode) {
                throw new RuntimeException("Key code not found for character '" + c + "'");
            }

            rb.keyPress(keyCode);
            rb.keyRelease(keyCode);
        }
        Thread.sleep(2000);
        rb.keyPress(KeyEvent.VK_DOWN);
        rb.keyRelease(KeyEvent.VK_DOWN);
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
    }

}
