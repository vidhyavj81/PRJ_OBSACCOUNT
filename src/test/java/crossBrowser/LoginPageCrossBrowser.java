package crossBrowser;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import commonUtility.PropertyFileRead;
import excelUtility.ExcelRead;
import extendReport.ExtendTestManager;
import pomClasses.POMLogin;
import webdriverUtility.DriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;


public class LoginPageCrossBrowser extends ExtendTestManager  {
	public static WebDriver driver;

	SoftAssert asser = new SoftAssert();
	POMLogin objPOMLogin;

	static String url="https://qalegend.com/billing/public/login";
	

	

	@Test(priority=1,enabled=true)
	public void excel() throws IOException, InterruptedException {
		
	
	
	String username=ExcelRead.readStringData(1, 0);
	String password=ExcelRead.readNumbericData(1, 1);
	objPOMLogin.login(username, password);
	
	String currenturl=driver.getCurrentUrl();
	SoftAssert url=new SoftAssert();
	url.assertEquals(PropertyFileRead.readConfigFile("expectedurl") , currenturl);
	url.assertAll();
	}
	
  @BeforeTest()
  @Parameters({"browser1"})
  public void beforeTest(String browser1)throws InterruptedException {
	    DriverManager objlogin=new DriverManager();
		objlogin.launchBrowser(url,browser1);
		driver=objlogin.driver;
		objPOMLogin=new POMLogin(driver);
	
	}
  @AfterTest
  public void afterTest() {
	 driver.close();
  }
  }



