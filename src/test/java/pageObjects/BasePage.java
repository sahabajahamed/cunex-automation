package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public static WebDriver driver;
	private WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);

	}

	public Select getSelect(WebElement dropdownElement) {
		return new Select(dropdownElement);
	}

	public WebElement performClick(WebElement locator) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
		return element;

	}

	// Scroll the page to the specified element
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Scroll the page up by the specified number of pixels
	public void scrollUp(int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -" + pixels + ");");
	}

	// Scroll the page down by the specified number of pixels
	public void scrollDown(int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, " + pixels + ");");
	}

	// scroll the page to the bottom
	public void scrollToBottom() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	// scroll the page to the top
	public void scrollToTop() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0)");
	}

	// Scroll the page to the specified element and click on it
	public void scrollToElementAndClick(WebElement element) {
		scrollToElement(element);
		element.click();
	}

	// Scroll the page to the specified element and click on it
	public void scrollToElementAndClick(WebElement element, int pixels) {
		scrollDown(pixels);
		element.click();
	}

	// Scroll the page to the specified element and click on it
	public void scrollToElementAndClick(WebElement element, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + ", " + y + ");");
		element.click();
	}

	// Scroll the page to the specified element and click on it
	public void scrollToElementAndClick(WebElement element, int x, int y, int pixels) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + ", " + y + ");");
		scrollDown(pixels);
		element.click();
	}

	// Scroll the page to the specified element and click on it
	public void scrollToElementAndClick(WebElement element, int x, int y, int pixels, int x1, int y1) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + x + ", " + y + ");");
		scrollDown(pixels);
		js.executeScript("window.scrollBy(" + x1 + ", " + y1 + ");");
		element.click();
	}

	
}

