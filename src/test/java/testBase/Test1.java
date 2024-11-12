package testBase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test1 {
	WebDriver driver;

	// Driver is open
	@BeforeMethod
	public void setup() {
		try {
			ChromeOptions options = new ChromeOptions();
			Map<String, Object> prefs = new HashMap<>();

			// Disable notifications permission pop-up
			prefs.put("profile.default_content_setting_values.notifications", 2);

			// Set these preferences into ChromeOptions
			options.setExperimentalOption("prefs", prefs);

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);

			// Maximize window and set implicit wait
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			// Navigate to the login page
			driver.get("https://staging.groundmetrx.com/");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// driver is close 
	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test(priority = 1)
	public void timedasbordPerform() throws InterruptedException, AWTException

	{
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Thread.sleep(5000);
		// js.executeScript("document.body.style.zoom = '0.7';");
		Robot robot = new Robot();
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		driver.findElement(By.xpath("//input[@id='exampleInputUsername']")).sendKeys(" Cunex Inc.");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("123456");

		Thread.sleep(5000);

		driver.findElement(By.xpath("//button[@class='btn full-btn']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='step-human-resources']")).click();
		WebElement scrollableElement = driver
				.findElement(By.xpath("//div[@class='dashbord-left-menu-wraper blue-bg']"));

		js.executeScript("window.scrollBy(0,200)");
		js.executeScript("window.scrollBy(0,200);", scrollableElement);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='arrow-time-dashboard']")).click();
		Thread.sleep(5000);
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='filter_paygroup']"));
		Select select = new Select(dropdown);
		Thread.sleep(5000);
		select.selectByVisibleText("Office");
		Thread.sleep(5000);
		js.executeScript("document.body.style.zoom = '0.8';");

		List<WebElement> ls = driver.findElements(By.xpath("//button[text()='Approve']"));

		if (ls.isEmpty()) {
			System.out.println("No 'Approve' buttons found.");
		} else {
			for (WebElement button : ls) {
				button.click();

				String errorMessage = driver.findElement(By.id("swal2-html-container")).getText();

				if (errorMessage.contains("Please resolve those to continue.")) {
					driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
					List<WebElement> driveLink = driver.findElements(By.xpath("//td[@class='sorting_1'] //a[@href]"));
					for (WebElement webElement : driveLink) {
						webElement.click();
						Thread.sleep(5000);
						String mainWindowHandle = driver.getWindowHandle();
						Set<String> allWindowHandles = driver.getWindowHandles();
						for (String windowHandle : allWindowHandles) {
							if (!windowHandle.equals(mainWindowHandle)) {
								driver.switchTo().window(windowHandle);
								driver.findElement(By.xpath(
										"//div[@class='d-flex justify-content-end align-items-center mb-3']//button[@id='expand_btn']"))
										.click();
								List<WebElement> markasNoCritical = driver
										.findElements(By.xpath("//button[@title='Mark as no critical']"));
								for (WebElement markNocritical : markasNoCritical) {
									Thread.sleep(5000);
									try {
										WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
										WebElement refreshedButton = wait.until(ExpectedConditions
												.refreshed(ExpectedConditions.elementToBeClickable(markNocritical)));
										refreshedButton.click();

									} catch (StaleElementReferenceException e) {
										System.out.println("Encountered a stale element, retrying...");
									}
									// markNocritical.click();
									Thread.sleep(5000);
									WebElement select2 = driver
											.findElement(By.xpath("//select[@id='critical_reason_id']"));
									Select sel = new Select(select2);
									sel.selectByVisibleText("Incorrect Schedule");
									driver.findElement(By.id("no_critical_note")).sendKeys("exx");
									driver.findElement(
											By.xpath("//button[@class='custom_btn_sm mark_as_no_critical_btn']"))
											.click();

								}

								driver.navigate().back();
							}
						}

					}
				} else if (errorMessage.contains("Non-Critical Exception")) {
					driver.findElement(By.xpath("//button[@class='swal2-confirm swal2-styled swal2-default-outline']"))
							.click();
				} else if (errorMessage.contains("The data has been updated successfully.")) {
					driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
				} else {
					System.out.println("Unexpected error message: " + errorMessage);
				}
			}
			//button[normalize-space()='Ok']

		}

	}

	@Test
	public void VerifyAddReimbursement() throws InterruptedException, AWTException {

		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Thread.sleep(5000);
		// js.executeScript("document.body.style.zoom = '0.7';");
		Robot robot = new Robot();
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		driver.findElement(By.xpath("//input[@id='exampleInputUsername']")).sendKeys(" Cunex Inc.");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@class='btn full-btn']")).click();
		driver.findElement(By.xpath("//a[@id='step-human-resources']")).click();
		driver.findElement(By.xpath("//a[@id='arrow-employees']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='reimbursements']")).click();
		String mainWindow = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window); // Switch to new window
				break;
			}

		}
		Thread.sleep(5000);
		int countreim = 3;
		while (countreim != 0) {
			driver.findElement(By.xpath("//button[@data-bs-toggle='modal']")).click();
			Thread.sleep(5000);
			driver.findElement(By.id("select2-user_id-container")).click();
			Thread.sleep(5000);
			List<WebElement> SuggestionName = driver.findElements(By.xpath("//ul[@id='select2-user_id-results']//li"));

			Random random2 = new Random();
			int randomName = random2.nextInt(SuggestionName.size());
			WebElement randomSuggestion = SuggestionName.get(randomName);
			randomSuggestion.click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//input[@id='date']")).click();
			List<WebElement> allDates = driver
					.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td[@data-event='click']"));
			if (!allDates.isEmpty()) {
				Random random = new Random();
				int randomIndex = random.nextInt(allDates.size());
				WebElement randomDate = allDates.get(randomIndex);
				randomDate.click();

			} else {
				System.out.println("No selectable dates found.");
			}
			driver.findElement(By.xpath("//input[@id='amount']")).sendKeys("230");
			driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("Automate selenium script ");
			WebElement chouseImage = driver.findElement(By.xpath("//input[@id='images']"));
			File file = new File("src/images/screenshot-staging_groundmetrx_com-2024_11_04-16_59_47.png");
			String absoulutePath = file.getAbsolutePath();
			chouseImage.sendKeys(absoulutePath);
			driver.findElement(By.xpath("//button[normalize-space()='Create']")).click();
			Thread.sleep(8000);
			countreim--;
		}

	}

	@Test
	public void verifyAdminApproveOrRejectReim() throws InterruptedException, AWTException {
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Thread.sleep(5000);
		// js.executeScript("document.body.style.zoom = '0.7';");
		Robot robot = new Robot();
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		driver.findElement(By.xpath("//input[@id='exampleInputUsername']")).sendKeys(" Cunex Inc.");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@class='btn full-btn']")).click();
		driver.findElement(By.xpath("//a[@id='step-human-resources']")).click();
		driver.findElement(By.xpath("//a[@id='arrow-employees']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='reimbursements']")).click();
		String mainWindow = driver.getWindowHandle();

		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window); // Switch to new window
				break;
			}

		}
		Thread.sleep(5000);

		List<WebElement> viewALLbutton = driver.findElements(By.xpath("//tbody//tr//td//button[text()='View']"));

		for (WebElement viewButton : viewALLbutton) {
			try {
				viewButton.click();
				Thread.sleep(4000);
				WebElement approveButton = driver.findElement(By.xpath("//button[normalize-space()='Approve']"));
				WebElement rejecteButton = driver.findElement(By.xpath("//button[normalize-space()='Reject']"));

				if (new Random().nextBoolean()) {
					approveButton.click();
					Thread.sleep(4000);
					driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
					Thread.sleep(5000);
					System.out.println("Approve Button click Sucessfully");
				} else {
					rejecteButton.click();
					driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
					Thread.sleep(5000);
					System.out.println("Reimbursement is Rejected ");
				}

			} catch (StaleElementReferenceException e) {
				System.out.println("Encountered StaleElementReferenceException, retrying...");
				viewALLbutton = driver.findElements(By.xpath("//tbody//tr//td//button[text()='View']"));

			}

		}

	}

	@Test
	public void addedTimeInTimecard() throws InterruptedException, AWTException {
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// Thread.sleep(5000);
		// js.executeScript("document.body.style.zoom = '0.7';");
		Robot robot = new Robot();
		Thread.sleep(5000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyPress(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_SUBTRACT);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		driver.findElement(By.xpath("//input[@id='exampleInputUsername']")).sendKeys(" Cunex Inc.");
		driver.findElement(By.xpath("//input[@placeholder='Enter password']")).sendKeys("123456");
		driver.findElement(By.xpath("//button[@class='btn full-btn']")).click();
		driver.findElement(By.xpath("//a[@id='step-human-resources']")).click();
		WebElement scrollableElement = driver
				.findElement(By.xpath("//div[@class='dashbord-left-menu-wraper blue-bg']"));

		js.executeScript("window.scrollBy(0,200)");
		js.executeScript("window.scrollBy(0,200);", scrollableElement);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@id='arrow-time-dashboard']")).click();
		Thread.sleep(5000);
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='filter_paygroup']"));
		Select select = new Select(dropdown);
		Thread.sleep(5000);
		select.selectByVisibleText("P&D NJ");
		Thread.sleep(5000);
		js.executeScript("document.body.style.zoom = '0.8';");
		List<WebElement> driveLink = driver.findElements(By.xpath("//td[@class='sorting_1'] //a[@href]"));
		for (WebElement webElement : driveLink) 
		{
			webElement.click();
			Thread.sleep(5000);
			String mainWindowHandle = driver.getWindowHandle();
			Set<String> allWindowHandles = driver.getWindowHandles();
			for (String windowHandle : allWindowHandles) {
				if (!windowHandle.equals(mainWindowHandle)) {
					driver.switchTo().window(windowHandle);
					List<WebElement> allday = driver.findElements(By.xpath("//div[@class='accordion-item']"));

					for (WebElement alldayClick : allday) {
						wait.until(ExpectedConditions.elementToBeClickable(alldayClick)).click();
						
						markAsNoCritical();
						// addedHour();
						// regularHourAdded();

					}

				}

			}
		}
	}

	public void addedHour() throws InterruptedException {

		List<WebElement> addhourButton = driver.findElements(
				By.xpath("//button[@class='custom_btn_sm add_time_schedule' and @data-type='add']"));
		List<WebElement> updateButton = driver.findElements(
				By.xpath("//button[@class='custom_btn_sm add_time_schedule' and @data-type='update']"));
		List<WebElement> markAsNoCritical = driver
				.findElements(By.xpath("//button[@title='Mark as no critical']"));
		if (!addhourButton.isEmpty() && updateButton.isEmpty()) {
			for (WebElement addhourButtonClick : addhourButton) {

				try {
					addhourButtonClick.click();
					WebElement selectdropDowb = driver.findElement(By.xpath("//select[@id='swal2-select']"));
					Select sel = new Select(selectdropDowb);
					sel.selectByVisibleText("Holiday/Vac/Sick Hour");
					driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
					WebElement holidaySIckLevae = driver
							.findElement(By.xpath("//select[@id='hours_earning_code']"));
					Thread.sleep(5000);
					Select sel2 = new Select(holidaySIckLevae);
					Thread.sleep(5000);
					sel2.selectByVisibleText("VAC");
					Thread.sleep(5000);
					driver.findElement(By.xpath("//input[@id='total_hours']")).sendKeys("8");
					Thread.sleep(5000);
					driver.findElement(By.xpath("//button[@type='submit'][normalize-space()='Add Hour']"))
							.click();
					Thread.sleep(5000);

				} catch (StaleElementReferenceException e) {
					System.out.println("Stale Element Reference Exception encountered, re-fetching elements.");
					break;
				}

			}
		}

	}

	public void regularHourAdded() throws AWTException, InterruptedException {
		List<WebElement> addhourButton = driver.findElements(
				By.xpath("//button[@class='custom_btn_sm add_time_schedule' and @data-type='add']"));
		List<WebElement> updateButton = driver.findElements(
				By.xpath("//button[@class='custom_btn_sm add_time_schedule' and @data-type='update']"));
		List<WebElement> markAsNoCritical = driver
				.findElements(By.xpath("//button[@title='Mark as no critical']"));
		if (!addhourButton.isEmpty() && updateButton.isEmpty()) {
			for (WebElement addhourButtonClick : addhourButton) {

				try {
					addhourButtonClick.click();
					WebElement selectdropDowb = driver.findElement(By.xpath("//select[@id='swal2-select']"));
					Select sel = new Select(selectdropDowb);
					sel.selectByVisibleText("Regular Hour");
					driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
					Thread.sleep(5000);
					driver.findElement(
							By.xpath("(//table[@class='ui-datepicker-calendar']//td[@data-event='click'])[1]")).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath("//input[@placeholder='Start Time']")).sendKeys("12:00 AM");
					Thread.sleep(5000);
					// robot.keyPress(KeyEvent.VK_DOWN);
					// robot.keyRelease(KeyEvent.VK_DOWN);
					// robot.keyPress(KeyEvent.VK_ENTER);
					// robot.keyRelease(KeyEvent.VK_ENTER);

					driver.findElement(By.xpath("//input[@id='punch_end_time']")).sendKeys("08:00 PM");

					driver.findElement(By.xpath(
							"//div[@class='col-md-12 text-center']//button[@type='submit'][normalize-space()='Update Time']"))
							.click();
					Thread.sleep(5000);

				} catch (StaleElementReferenceException e) {
					System.out.println("Stale Element Reference Exception encountered, re-fetching elements.");
					break;
				}
			}
		}
	}

	public void markAsNoCritical() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// try {
		// 	List<WebElement> addhourButton = driver.findElements(
		// 			By.xpath("//button[@class='custom_btn_sm add_time_schedule' and @data-type='add']"));
		// 	List<WebElement> updateButton = driver.findElements(
		// 			By.xpath("//button[@class='custom_btn_sm add_time_schedule' and @data-type='update']"));
			List<WebElement> markAsNoCritical = driver.findElements(By.xpath("//button[@title='Mark as no critical']"));

			if (!markAsNoCritical.isEmpty()) {
				for (WebElement markAsNoElement : markAsNoCritical) {
					int retryCount = 0;
					boolean clicked = false;

					while (!clicked && retryCount < 3) { // Retry up to 3 times if StaleElementReferenceException occurs
						try {
							wait.until(ExpectedConditions.elementToBeClickable(markAsNoElement)).click();
							WebElement select2 = wait.until(ExpectedConditions
									.visibilityOfElementLocated(By.xpath("//select[@id='critical_reason_id']")));
							Select sel = new Select(select2);
							sel.selectByVisibleText("Incorrect Schedule");

							driver.findElement(By.id("no_critical_note")).sendKeys("exx");
							driver.findElement(By.xpath("//button[@class='custom_btn_sm mark_as_no_critical_btn']"))
									.click();
							clicked = true; // Set to true if click is successful

						} catch (StaleElementReferenceException e) {
							// Handle stale element by refetching markAsNoCritical list
							retryCount++;
							System.out.println("Retrying due to stale element - Attempt " + retryCount);
							markAsNoCritical = driver.findElements(By.xpath("//button[@title='Mark as no critical']"));
							if (retryCount >= markAsNoCritical.size())
								break; // Avoid out of bounds
							markAsNoElement = markAsNoCritical.get(retryCount);
						}
					}
				}
			}
		// } catch (Exception e) {
		// 	System.out.println("An error occurred: " + e.getMessage());
		// }

	}
}
