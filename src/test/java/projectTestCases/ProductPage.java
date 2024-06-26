package projectTestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commonUtility.PropertyFileRead;
import excelUtility.ExcelRead;
import pomClasses.POMLogin;
import pomClasses.POMProduct;

import webdriverUtility.DriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class ProductPage {

	
	POMLogin objPOMLogin;
	POMProduct objPOMProduct;

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
	url.assertEquals(PropertyFileRead.readConfigFile("expectedurl") ,currenturl);
	url.assertAll();
	}
	  @Test(priority=2,enabled=true)
public void productDetailsAdd() throws InterruptedException {	
objPOMProduct.addProductDetails("anoki", "Nestle","food","100","6","9");
	
		}

  
	  @BeforeTest	
	  public void beforeTest()throws InterruptedException {
			
			DriverManager objUnit=new DriverManager();
			objUnit.launchBrowser(url,browser);
			driver=objUnit.driver;
			objPOMLogin=new POMLogin(driver);
			objPOMProduct=new POMProduct(driver);
	  }
  @AfterTest
  public void afterTest() {
  }

}
