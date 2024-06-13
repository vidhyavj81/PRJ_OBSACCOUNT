package pomClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriverUtility.WebDriverActions;

public class POMLogin {
	WebDriverActions objHandler;
	
 WebDriver driver;
	public POMLogin(WebDriver driver)
	{
		this.driver=driver;
		objHandler = new WebDriverActions(driver);
		PageFactory.initElements(driver, this);
	}
		@FindBy(id="username")
		public WebElement Webusername;
		@FindBy(id="password")
		public WebElement Webpassword;
		@FindBy(xpath="/html/body/div[3]/div/div/div/div[2]/form/div[4]/div/button")
		public WebElement WebLoginButton;


public void login(String username, String password) throws Exception
{
	objHandler.sendkeys(Webusername,username);
	objHandler.sendkeys(Webpassword, password);
	objHandler.click(WebLoginButton);
}

}






