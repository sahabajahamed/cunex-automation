package Cunex;

import java.awt.AWTException;
import java.util.List;
import java.util.NoSuchElementException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.events.MouseEvent;

public class Locators {

    public static WebDriverWait wait;
    WebDriver driver;

    public Locators(WebDriver driver) {
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    // Login Page

    @FindBy(xpath = "//input[@id='exampleInputUsername']")
    private WebElement username;
    @FindBy(xpath = "//input[@id='exampleInputPassword1']")
    private WebElement password;
    @FindBy(xpath = "//button[normalize-space()='Login']")
    private WebElement loginButton;
    @FindBy(xpath = "//a[@id='step-human-resources']")
    private WebElement humanResources;
    @FindBy(xpath = "//a[@id='arrow-applicant-tracking-system']")
    private WebElement ATS;
    @FindBy(xpath = "//a[contains(text(),'Add')]")
    private WebElement AddNewJob;
    @FindBy(xpath = "//select[@id='job_type']")
    private WebElement JobType;
    @FindBy(xpath = "//select[@id='department']")
    private WebElement Department;
    @FindBy(xpath = "//input[@id='pay_from']")
    private WebElement PayFrom;
    @FindBy(xpath = "//input[@id='pay_to']")
    private WebElement PayTo;
    @FindBy(xpath = "//select[@id='pay_type']")
    private WebElement Paytype;
    @FindBy(xpath = "//input[@id='position']")
    private WebElement Position;
    @FindBy(xpath = "//input[@id='this_location']")
    private WebElement Location;
    @FindBy(xpath = "(//button[text()='No'])[2]")
    private WebElement warning;
    @FindBy(xpath = "//input[@id='type_of_truck']")
    private WebElement TruckType;
    @FindBy(xpath = "//input[@id='qualifications']")
    private WebElement Qualification;
    @FindBy(xpath = "(//div[@class='note-editable'])[1]")
    private WebElement abtCompany;
    @FindBy(xpath = "(//div[@class='note-editable'])[2]")
    private WebElement jobDescription;
    @FindBy(xpath = "(//div[@class='note-editable'])[3]")
    private WebElement Responsibility;
    @FindBy(xpath = "(//div[@class='note-editable'])[4]")
    private WebElement Benefits;
    @FindBy(xpath = "//select[@id='job_status']")
    private WebElement JobStatus;
    @FindBy(xpath = "//select[@id='entity_id']")
    private WebElement Entity;
    @FindBy(xpath = "//input[@id='experienceCheckbox']")
    private WebElement experienceCheckbox;
    @FindBy(xpath = "//button[normalize-space()='Add Job']")
    private WebElement AddJob;
    @FindBy(xpath = "//button[text()='Yes']")
    private WebElement Yeswarning;
    @FindBy(xpath = "//h2[text()='Job Position added successfully']")
    private WebElement Sucessfullmsg;
    @FindBy(xpath = "//button[@id='edit_mode_tab']")
    private WebElement editMode;

    // questionbank
    @FindBy(xpath = "(//a[@title='Questions'])[1]")
    private WebElement questions;
    @FindBy(xpath = "//input[@id='set_ques_1']")
    private WebElement questionsCheckbox;
    @FindBy(xpath = "//button[@id='save_ques_btn']")
    private WebElement Savequestion;
    @FindBy(xpath = "//h2[text()='Questions Saved Successfully']")
    private WebElement QuestionSaved;
    @FindBy(xpath = "(//span[text()='Remove'])[1]")
    private WebElement remove;
    @FindBy(xpath = "//h2[text()='No questions to save']")
    private WebElement Noquestions;
    @FindBy(xpath = "//a[@id='add_question_btn']")
    private WebElement addQuestion;
    @FindBy(xpath = "(//select[@class='form-select question_type'])[1]")
    private WebElement selectQuestionType;
    @FindBy(xpath = "(//input[@placeholder='option'])[1]")
    private WebElement Option1;
    @FindBy(xpath = "(//input[@placeholder='option'])[2]")
    private WebElement Option2;
    @FindBy(xpath = "(//input[@placeholder='Write your question'])[1]")
    private WebElement WriteYourQuestion;
    @FindBy(xpath = "(//select[@class='form-select screening_type'])[1]")
    private WebElement selectScreeningType;
    @FindBy(xpath = "//a[normalize-space()='Question Bank']")
    private WebElement QuestionBank;
    @FindBy(xpath = "//a[contains(text(), 'Add Set')]") ///// ////h2[text()='Question Bank']/following-sibling::a
    private WebElement addset;
    @FindBy(xpath = "//input[@id='set_name']")
    private WebElement setname;
    @FindBy(xpath = "//button[@id='add_question_bank_set_btn']")
    private WebElement createbutton;
    @FindBy(xpath = "//button[normalize-space()='Edit Set Name']")
    private WebElement editSetname;
    @FindBy(xpath = "//div[@id='v-mmr-tab']")
    private WebElement questionTab;
    @FindBy(xpath = "//button[@id='update_question_bank_set_btn']")
    private WebElement updateSet;
    @FindBy(xpath = "//form[@id='update_question_bank_set_form']")
    private WebElement enterquestionset;

    // offboarding
    @FindBy(xpath = "//a[@id='arrow-employees']")
    private WebElement employees;
    @FindBy(xpath = "//body[1]/main[1]/div[1]/div[2]/div[1]/div[2]/div[4]/div[1]/div[2]/div[3]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[15]/button[1]")
    private WebElement active;
    @FindBy(xpath = "//select[@id='swal2-select']")
    private WebElement selectStatus;
    @FindBy(xpath = "//button[normalize-space()='Update']")
    private WebElement updateBtn;
    @FindBy(xpath = "//button[normalize-space()='Yes']")
    private WebElement offboardingYes;
    @FindBy(xpath = "//div[text()='Moved to Offboarding Successfully']")
    private WebElement offConfirmationMsg;
    @FindBy(xpath = "//button[normalize-space()='OK']")
    private WebElement ok;
    @FindBy(xpath = "//table[@id='drivers_list_table']/thead/tr/th[15]")
    private WebElement statusColumn;
    @FindBy(xpath = "//table[@id='drivers_list_table']/tbody/tr")
    private List<WebElement> tableRows;
    @FindBy(xpath = "(//button[text()='Active'])[2]")
    private WebElement activeBtns;
    @FindBy(xpath = "//a[@id='arrow-onboarding-system']")
    private WebElement offboarding;
    @FindBy(xpath = "//button[@id='offboarding_tab']")
    private WebElement OffTab;
    @FindBy(xpath = "//table[@id='pending_driver_offboarders_list_table']/tbody/tr[1]/td[1]")
    private WebElement firstnameList;
    @FindBy(xpath = "//button[@id='offboarding_info_edit_btn']")
    private WebElement offboarderEdit;
    @FindBy(xpath = "//select[@id='company_termination_reason_id']")
    private WebElement TerminationReason;
    @FindBy(xpath = "//input[@id='termination_date']")
    private WebElement TerminationDate;
    @FindBy(xpath = "//input[@id='last_working_date']")
    private WebElement LastWorkday;
    @FindBy(xpath = "//select[@id='rehirable']")
    private WebElement Rehirable;
    @FindBy(xpath = "//select[@id='company_termination_type_id']")
    private WebElement TerminationType;
    @FindBy(xpath = "//input[@type='checkbox']")
    private List<WebElement> Checklists;
    @FindBy(xpath = "//button[@id='offboarding_info_update_btn']")
    private WebElement offUpdate;
    @FindBy(xpath = "//h2[text()='Submitted Successfully']")
    private WebElement offToast;
    @FindBy(xpath = "//button[@id='offboarding_documents_info_tab']")
    private WebElement OffDocument;
    @FindBy(xpath = "(//a[@title='Set Required Fields'])[1]")
    private WebElement Sf23Setfields;
    @FindBy(xpath = "//input[@id='authorized_officer_name']")
    private WebElement ofcName;
    @FindBy(xpath = "//input[@id='business_contact_name']")
    private WebElement Business_contact_name;
    @FindBy(xpath = "//input[@id='authorized_officer_print']")
    private WebElement authorized_officer_name;
    @FindBy(xpath = "(//button[@type='submit'])[1]")
    private WebElement Sf23Savefields;
    @FindBy(xpath = "(//button[@type='button'])[3]")
    private WebElement Sf23Sign;
    @FindBy(xpath = "//input[@id='hr_signature_text']")
    private WebElement sf23_hr_signature;
    @FindBy(xpath = "//button[text()='Submit Sign']")
    private WebElement sf23_submit_sign;
    @FindBy(xpath = "(//a[@title='Set Required Fields'])[2]")
    private WebElement Term_letter;
    @FindBy(xpath = "//input[@id='position']")
    private WebElement position;
    @FindBy(xpath = "//input[@id='policy_name']")
    private WebElement policy_name;
    @FindBy(xpath = "//textarea[@id='details_of_terminating_event']")
    private WebElement details_of_terminating_event;
    @FindBy(xpath = "//input[@id='manager_name']")
    private WebElement hr_representative;
    @FindBy(xpath = "//button[@id='save_termination_letter_set_required_fields_btn']")
    private WebElement Termination_savefields;
    @FindBy(xpath = "(//button[@type='button'])[4]")
    private WebElement termination_sign;
    @FindBy(xpath = "//canvas[@id='termination_letter_signature_canvas']")
    private WebElement signature_pad;
    @FindBy(xpath = "//button[normalize-space()='Yes']")
    private WebElement sf23_confirmation;
    @FindBy(xpath = "//button[@id='termination_letter_sign_and_finish_btn']")
    private WebElement acceptandsign;
    @FindBy(xpath = "//button[normalize-space()='Yes']")
    private WebElement sign_confirmation;
    @FindBy(xpath = "//button[@id='terminate_button']")
    private WebElement Terminate;
    @FindBy(xpath ="//button[normalize-space()='Yes']")
    private WebElement Terminate_confirmation;

    // Login Page
    public void enterUsername() {
        username.sendKeys("Cunex Inc.");
    }

    public void enterPassword() {
        password.sendKeys("123456");
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public void clickHumanResources() {
        humanResources.click();
    }

    public void clickAts() {
        ATS.click();
    }

    public void clickAddNewJob() {
        AddNewJob.click();
    }

    public void selectJobType() {
        JobType.click();
        Select s1 = new Select(JobType);
        s1.selectByVisibleText("Full Time");

    }

    public void selectDepartment() {
        Department.click();
        Select s2 = new Select(Department);
        s2.selectByVisibleText("Linehaul");
    }

    public void enterPayFrom() {
        PayFrom.sendKeys(Basepage.randomnumber());
    }

    public void enterPayTo() {
        PayTo.sendKeys(Basepage.randomnumber());
    }

    public void selectPayType() {
        Paytype.click();
        Select s3 = new Select(Paytype);
        s3.selectByVisibleText("Hour");
    }

    public void enterPosition() {
        Position.sendKeys(Basepage.randomstring());
    }

    public void enterLocation() throws InterruptedException {
        Location.sendKeys(Basepage.randomlocation());
        Thread.sleep(2000);
        Location.sendKeys(Keys.ARROW_DOWN);
        Location.sendKeys(Keys.ENTER);

    }

    public void clickWarning() {
        warning.click();
    }

    public void enterTruckType() {
        TruckType.sendKeys(Basepage.randomstring());
    }

    public void enterQualification() {
        Qualification.sendKeys(Basepage.randomstring());
    }

    public void aboutCompany() {
        abtCompany.sendKeys(
                "Cunex Inc. is a trucking company that provides transportation services to the United States and Canada. We are a family-owned business that has been in operation for over 20 years. Our mission is to provide safe, reliable, and efficient transportation services to our customers. We are committed to delivering exceptional service and building long-term relationships with our customers. Our team of experienced drivers and staff are dedicated to providing the highest level of service and ensuring the satisfaction of our customers. We take pride in our work and strive to exceed the expectations of our customers. At Cunex Inc., we are committed to excellence in everything we do.");
    }

    public void jobDescription() {
        jobDescription.sendKeys(
                "Cunex Inc. is a trucking company that provides transportation services to the United States and Canada. We are a family-owned business that has been in operation for over 20 years. Our mission is to provide safe, reliable, and efficient transportation services to our customers. We are committed to delivering exceptional service and building long-term relationships with our customers. Our team of experienced drivers and staff are dedicated to providing the highest level of service and ensuring the satisfaction of our customers. We take pride in our work and strive to exceed the expectations of our customers. At Cunex Inc., we are committed to excellence in everything we do.");
    }

    public void enterResponsibility() {
        Responsibility.sendKeys("Health, Dental, Vision, Life, and Disability Insurance");

    }

    public void enterBenefits() {
        Benefits.sendKeys("Health, Dental, Vision, Life, and Disability Insurance");

    }

    public void selectJobStatus() {
        JobStatus.click();
        Select s4 = new Select(JobStatus);
        s4.selectByVisibleText("Published");
    }

    public void selectEntity() {
        Entity.click();
        Select s5 = new Select(Entity);
        s5.selectByVisibleText("Cunex Inc.");
    }

    public void ClickexperienceCheckbox() {
        experienceCheckbox.click();
    }

    public void clickAddJob() {
        AddJob.click();
    }

    public void clickYesWarning() {
        Yeswarning.click();
    }

    public void getSucessfullmsg() {
        String actualMsg = Sucessfullmsg.getText();
        if (actualMsg.equals("Job Position added successfully")) {
            System.out.println("Job Position added successfully");
        } else {
            System.out.println("Job Position not added successfully");
        }

    }

    // questiobank
    public void clickQuestion() {
        questions.click();
    }

    public void clickEditMode() {
        editMode.click();
    }

    public void clickQuestionsCheckbox() {
        questionsCheckbox.click();
    }

    public void clickSavequestion() {
        Savequestion.click();
    }

    public void getQuestionSaved() {
        String actualMsg = QuestionSaved.getText();
        if (actualMsg.equals("Questions Saved Successfully")) {
            System.out.println("Questions Saved Successfully");
        } else {
            System.out.println("Questions not Saved Successfully");
        }
    }

    public void clickRemove() {
        remove.click();
    }

    public void getNoquestions() {
        String actualMsg = Noquestions.getText();
        if (actualMsg.equals("No questions to save")) {
            System.out.println("No questions to save");
        } else {
            System.out.println("Questions are saved");
        }
    }

    public void clickAddQuestion() {
        addQuestion.click();
    }

    public void selectQuestionType() {
        selectQuestionType.click();
        Select s6 = new Select(selectQuestionType);
        s6.selectByVisibleText("Options");
    }

    public void displayOptions() {
        if (Option1.isDisplayed() && Option2.isDisplayed()) {
            System.out.println("Options are displayed");
        } else {
            System.out.println("Options are not displayed");
        }
        Option1.sendKeys(Basepage.randomstring());
        Option2.sendKeys(Basepage.randomstring());
    }

    public void enterWriteYourQuestion() {
        WriteYourQuestion.sendKeys(Basepage.randomstring());
    }

    public void selectScreeningType() {
        selectScreeningType.click();
        Select s6 = new Select(selectScreeningType);
        s6.selectByVisibleText("Enquiry Question");
    }

    public void clickQuestionBank() {
        QuestionBank.click();
    }

    public void clickAddset() {
        addset.click();
    }

    public String EnterSetName() {
        // setname.sendKeys(Basepage.randomstring());
        String set = Basepage.randomstring();
        setname.sendKeys(set);
        return set;

    }

    public void clickCreateButton() {
        createbutton.click();
    }

    public void editSetName() {
        editSetname.click();

    }

    public String getQuestionTab() {
        String text = questionTab.getText();
        return text;

    }

    public void clickUpadteset() {
        updateSet.click();

    }

    public String updateQuestionSet() {
        enterquestionset.click();
        enterquestionset.clear();
        String editSet = Basepage.randomstring();
        enterquestionset.sendKeys(editSet);
        return editSet;

    }

    // offboarding
    public void clickEmployees() {
        employees.click();
    }

    public void clickactive() {
        active.click();
    }

    public void SelectStatus() {
        Select s1 = new Select(selectStatus);
        s1.selectByVisibleText("Terminated");
    }

    public void clickupdateBtn() {
        updateBtn.click();
    }

    public void clickoffboardingYes() {
        offboardingYes.click();
    }

    public void checkOffMsg() {
        if (offConfirmationMsg.isDisplayed()) {
            System.out.println("employee successfully moved to offboarding");
        } else {
            System.out.println("employee hasn't moved to offboarding");
        }
    }

    public void clickok() {
        ok.click();
    }

    public void clickFirstActiveButton() {
        activeBtns.click();
    }

    public void clickOffboarding() {
        offboarding.click();
    }

    public void clickofftab() {
        OffTab.click();
    }

    public void clickonFirstname() {
        firstnameList.click();
    }

    public void clickOffboarderEdit() {
        offboarderEdit.click();
    }

    public void selectTermReason() {
        Select s1 = new Select(TerminationReason);
        s1.selectByVisibleText("Reason 1");
    }

    public void pickTermDate() {
        TerminationDate.sendKeys("03/28/2025");
    }

    public void EnterLastWorkdate() {
        LastWorkday.sendKeys("03/28/2025");
    }

    public void SelectRehirable() {
        Select s1 = new Select(Rehirable);
        s1.selectByVisibleText("Yes");
    }

    public void selectTermType() {
        Select s1 = new Select(TerminationType);
        s1.selectByVisibleText("Involuntary");
    }

    public void SelectChecklists() {
        for (WebElement checkbox : Checklists) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
        System.out.println("All checkboxes are checked successfully.");
    }

    public void ClickOffUpdate() {
        offUpdate.click();
    }

    public void checkOffToast() {
        if (offToast.isDisplayed()) {
            System.out.println("Offboarder profile is updated");
        } else {
            System.out.println("Offboarder profile is not updated");
        }
    }

    public void clickOffdoc() {
        OffDocument.click();
    }

    public void clickSfSetfield() {
        Sf23Setfields.click();
    }

    public void EnterofcName() {
        ofcName.sendKeys(Basepage.randomstring());
    }

    public void Enter_Business_contact_name() {
        Business_contact_name.sendKeys(Basepage.randomstring());
    }

    public void Enter_authorized_officer_name() {
        authorized_officer_name.sendKeys(Basepage.randomstring());
    }

    public void Click_sf23_savefield() {
        Sf23Savefields.click();
    }

    public void Click_sf23_sign() {
        Sf23Sign.click();
    }

    public void Enter_sf23_signature() {
        sf23_hr_signature.sendKeys(Basepage.randomstring());
    }

    public void Click_sf23_submit_sign() {
        sf23_submit_sign.click();
    }

    public void click_Termination_letter() {
        Term_letter.click();
    }

    public void Enter_position() {
        position.sendKeys(Basepage.randomstring());
    }

    public void Enter_policy_name() {
        policy_name.sendKeys(Basepage.randomstring());
    }

    public void Enter_details_Termination_Event() {
        details_of_terminating_event.sendKeys(Basepage.randomstring());
    }

    public void Enter_hr_representative() {
        hr_representative.sendKeys(Basepage.randomstring());
    }

    public void click_termination_save_fields() {
        Termination_savefields.click();
        ;
    }

    public void click_termination_sign() {
        termination_sign.click();
    }

    public void perform_sign() throws AWTException, InterruptedException {
        //
        Robot r1 = new Robot();

        // Move to initial position
        int startX = 1000; // Adjust as per screen/signature pad
        int startY = 600;
        r1.mouseMove(startX, startY);
        Thread.sleep(500);

        // Press the left mouse button (click and hold)
        r1.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        Thread.sleep(500);

        // Move mouse down (adjust Y value)
        int endY = startY + 200; // Moves 200 pixels downward
        for (int i = startY; i <= endY; i += 5) { // Smooth movement
            r1.mouseMove(startX, i);
            Thread.sleep(10); // Small delay for a smoother drag effect
        }

        // Release the left mouse button
        r1.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

    }

    public void click_sf23_confirmation() {
        sf23_confirmation.click();
    }

    public void click_acceptandsign() {
        acceptandsign.click();
    }

    public void click_sign_confirmation() {
        sign_confirmation.click();
    }
    public void click_terminate()
    {
        Terminate.click();
    }
    public void click_terminate_confirmation()
    {
        Terminate_confirmation.click();
    }

}
