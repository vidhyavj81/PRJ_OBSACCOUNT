package webdriverUtility;

import java.io.File;

import java.util.Calendar;
import java.util.Date;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class WebDriverActions {
	public WebDriver driver;
	private String iframe;
	static String project = System.getProperty("user.dir");

	public WebDriverActions(WebDriver driver) {
		this.driver = driver;

	}

	public void iframes(WebElement element) {
		// driver.findElement(value);
		driver.switchTo().frame(element);
	}

//For AlertBox(AlertClass)
	public void Alertaccept() {
		org.openqa.selenium.Alert objalert = driver.switchTo().alert();
		objalert.accept();

	}

	public void Alertdismiss() {
		org.openqa.selenium.Alert objalert = driver.switchTo().alert();
		objalert.dismiss();
	}

//Implementation for Click, Scrolldown, ScrollInto using JavaScript

	public void javascriptClick(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void javascriptScrollElement(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);

	}

	public void javascriptScrollPixel(int pixel) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Vertical scroll – down by 150 pixels

		js.executeScript("window.scrollBy(0,pixel)");

	}

	public void screenshot() throws Exception {

		Calendar cal = Calendar.getInstance();
		Date time = cal.getTime();
		String timestamp = time.toString().replace(":", "").replace(" ", "");

		System.out.println(time);
		System.out.println(timestamp);

		// Convert web driver object to TakeScreenshot
		TakesScreenshot scrShot = ((TakesScreenshot) driver);

		// Call getScreenshotAs method to create image file
		File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);

		// Move image file to new destination
		File DestFile = new File(project + "\\src\\test\\resources\\screenshot\\" + timestamp + "test.png");

		// Copy file at destination
		FileUtils.copyFile(SrcFile, DestFile);
	}
	// TimeStamp

// Common method implementation for webelement

	public void click(WebElement value) {
		value.click();
	}

	public void sendkeys(WebElement value, String value1) {
		value.clear();
		value.sendKeys(value1);
	}

	public void dropdownselectByvalue(WebElement dropdown, String value) {
		Select objSelect = new Select(dropdown);
		objSelect.selectByValue(value);

	}

	public void dropdownselectByIndex(WebElement dropdown, int value) {
		Select objSelect = new Select(dropdown);
		objSelect.selectByIndex(value);

	}

	public void dropdownselectByVisibleText(WebElement dropdown, String value) {
		Select objSelect = new Select(dropdown);
		objSelect.selectByVisibleText(value);
	}

	public String getText(WebElement successMessage) {
		String Value = successMessage.getText();
		return Value;
	}
}
