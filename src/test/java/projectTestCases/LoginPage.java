package projectTestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commonUtility.PropertyFileRead;
import excelUtility.ExcelRead;
import pomClasses.POMLogin;
import webdriverUtility.Driver;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;


public class LoginPage {
	POMLogin objPOMLogin;
	static String url="https://qalegend.com/billing/public/login";
	static String browser="chrome";

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
		
		Driver objlogin=new Driver();
		objlogin.launchBrowser(url,browser);
		driver=objlogin.driver;
		objPOMLogin=new POMLogin(driver);
  }
  @AfterTest
  public void afterTest() {
	 driver.close();
  }
  }



