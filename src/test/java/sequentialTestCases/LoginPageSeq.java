	package sequentialTestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commonUtility.PropertyFileRead;
import excelUtility.ExcelRead;
import pomClasses.POMLogin;
import webdriverUtility.DriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginPageSeq {
	POMLogin objPOMLogin;
	static String urllogin=PropertyFileRead.readConfigFile("urllogin");
	static String browser=PropertyFileRead.readConfigFile("browser");
	public static WebDriver driver;

	@Test(priority=1,enabled=true)
	public void excel() throws Exception {
		
	String username=ExcelRead.readStringData(1, 0);
	String password=ExcelRead.readNumbericData(1, 1);
	objPOMLogin.login(username, password);
	
	String currenturl=driver.getCurrentUrl();
	SoftAssert url=new SoftAssert();
	url.assertEquals(PropertyFileRead.readConfigFile("expectedurl") , currenturl);
	url.assertAll();
	}
	
  @BeforeTest
  public void beforeTest()throws InterruptedException {
		
		DriverManager objlogin=new DriverManager();
		objlogin.launchBrowser(urllogin,browser);
		driver=objlogin.driver;
		objPOMLogin=new POMLogin(driver);
  }
 
  }



