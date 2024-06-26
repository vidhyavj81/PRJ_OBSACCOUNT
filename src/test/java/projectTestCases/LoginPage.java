package projectTestCases;

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

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;


public class LoginPage extends ExtendTestManager  {
	public static WebDriver driver;
	SoftAssert objassert = new SoftAssert();
	POMLogin objPOMLogin;
	ExtentTest test;
	public ExtentReports extent;
	ExtendTestManager objTestManager;
	static String urllogin=PropertyFileRead.readConfigFile("urllogin");
	static String browser=PropertyFileRead.readConfigFile("browser");

	

	@Test(priority=1,enabled=true)
	public void excel() throws IOException, InterruptedException {
		test=extent.createTest("Validating login scenario");
		boolean Status;
	
	String username=ExcelRead.readStringData(1, 0);
	String password=ExcelRead.readNumbericData(1, 1);
	objPOMLogin.login(username, password);	
	String currenturl=driver.getCurrentUrl();
//	objassert.assertEquals(PropertyFileRead.readConfigFile("expectedurl") , currenturl);
//	objassert.assertAll();
	if(PropertyFileRead.readConfigFile("expectedurl").contains(currenturl))
	{
		
		objassert.assertTrue(true);
		Status=true;
	}
	else {
		objassert.assertTrue(false);
		Status=false;
	}
	
	objassert.assertAll();
	if(Status==true)
	{
		test.log(com.aventstack.extentreports.Status.PASS, "Login successfully to the application");
	}
	else if(Status==false) {
		test.log(com.aventstack.extentreports.Status.FAIL, "Login failed");
	}
	}
	
	@Test(priority = 2, enabled = true, groups={"failed"})
	public void logInFailed() throws IOException, InterruptedException {
		String username = ExcelRead.readStringData(1, 0);
		String password = ExcelRead.readNumbericData(1, 1);
		objPOMLogin.login(username, password);
		String current_url = driver.getCurrentUrl();
		objassert.assertEquals("123", current_url);
		objPOMLogin.signout();
		objassert.assertAll();
	}
	
  @BeforeTest(alwaysRun = true)
  public void beforeTest()throws InterruptedException {
	    DriverManager objlogin=new DriverManager();
		objlogin.launchBrowser(urllogin,browser);
		driver=objlogin.driver;
		objPOMLogin=new POMLogin(driver);
		objTestManager=new ExtendTestManager();
		extent=objTestManager.extendreportgenerate();
	}
  @AfterTest
  public void afterTest() {
	 driver.close();
  }
  }



