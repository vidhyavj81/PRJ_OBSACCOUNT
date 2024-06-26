package waitUtility;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtilitys {
	WebDriver driver;

	public WaitUtilitys(WebDriver driver) {
		this.driver = driver;
	}

	public void driverImplicitWait() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
	}

	public void elementToBeClickable(By driver2, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable((By) driver2));

	}

	public void waitAlert(int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.alertIsPresent());

	}

	public void presenceOfElementLocated(By driver2, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.presenceOfElementLocated((By)driver2));

	}

	public void visibilityOfElementLocated(By driver2, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOfElementLocated((By)driver2));

	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void waitAlertPresent() {
		// Declare and initialise a fluent wait
		FluentWait wait = new FluentWait(driver)
				// Specify the timout of the wait
				.withTimeout(Duration.ofSeconds(30))
				// Sepcify polling time
				.pollingEvery(Duration.ofSeconds(5))
				// Specify what exceptions to ignore
				.ignoring(NoSuchElementException.class);

		// This is how we specify the condition to wait on.
		// This is what we will explore more in this

		wait.until(ExpectedConditions.alertIsPresent());
	}

	public void normalWait(int sleepValue) throws InterruptedException {
		Thread.sleep(sleepValue);
	}
}
