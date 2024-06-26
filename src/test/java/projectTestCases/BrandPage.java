package projectTestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commonUtility.PropertyFileRead;
import excelUtility.ExcelRead;
import pomClasses.POMBrand;
import pomClasses.POMCategories;
import pomClasses.POMLogin;
import pomClasses.POMUnit;
import webdriverUtility.DriverManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;


public class BrandPage {
POMLogin objPOMLogin;
POMBrand objPOMBrand;
	
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
	url.assertEquals(PropertyFileRead.readConfigFile("expectedurl") ,currenturl);
	url.assertAll();
	}
	
	@Test(priority=2,enabled=true,dataProvider="testdata")
	public void brandAdd(String namebrand,String descbrand)throws InterruptedException{
		objPOMBrand.branddetails();
		String objNameBrand=namebrand;
		String objDescBrand=descbrand;
		objPOMBrand.addbranddetails(namebrand,descbrand);	
	    String expectedmessage="Brand added successfully";
		String actualmessage=objPOMBrand.brandmessage;
		Assert.assertTrue(expectedmessage.contains(actualmessage));
	}
		
		@Test(priority=3,enabled=true)
		public void brandSearch()throws InterruptedException{
		
		boolean value2=objPOMBrand.isSearchBrandDetails(PropertyFileRead.readConfigFile("searchdetailsbrand"));
		Assert.assertEquals(value2, true);
		}
	
	
  @BeforeTest
  public void beforeTest()throws InterruptedException {
		
		DriverManager objUnit=new DriverManager();
		objUnit.launchBrowser(urllogin,browser);
		driver=objUnit.driver;
		objPOMLogin=new POMLogin(driver);
		objPOMBrand=new POMBrand(driver);
  }
  @AfterTest
  public void afterTest() {
	  driver.close();
  }
  @DataProvider(name="testdata")
  public Object[][]TestDataFeed(){
	  //Create object array with 2 rows and 2 column-first parameter is row and second is column
	  Object[][] twitterdata=new Object[1][2];
	  //Enter data to row 0 column 0
	  twitterdata[0][0]="celto";
	  //Enter data to row 0 column 1
	  twitterdata[0][1]="kitchen";
return twitterdata;
	  }

  }
