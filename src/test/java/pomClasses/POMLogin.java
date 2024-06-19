package pomClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import waitUtility.WaitUtilitys;
import webdriverUtility.WebDriverActions;

public class POMLogin {
	WebDriverActions objDriverActions;
	WebDriver driver;
	public POMLogin(WebDriver driver)
	
	
	{
		this.driver=driver;
		objDriverActions = new WebDriverActions(driver);
		PageFactory.initElements(driver, this);
	}
		@FindBy(id="username")
		public WebElement Webusername;
		@FindBy(id="password")
		public WebElement Webpassword;
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/form/div[4]/div/button")
		public WebElement WebLoginButton;
		@FindBy(xpath="//*[@id=\"step-0\"]/div[3]/button[3]")
		public WebElement EndTour;
		@FindBy(xpath="//*[@id=\"tour_step5_menu\"]")
		public WebElement Products;

public void login(String username, String password) throws InterruptedException {

	objDriverActions.sendkeys(Webusername,username);
	objDriverActions.sendkeys(Webpassword, password);
	objDriverActions.click(WebLoginButton);
	objDriverActions.click(EndTour);
	objDriverActions.click(Products);
	Thread.sleep(3000);
}
}