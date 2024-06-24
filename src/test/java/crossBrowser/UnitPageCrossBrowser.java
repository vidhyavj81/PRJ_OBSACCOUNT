package crossBrowser;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import commonUtility.PropertyFileRead;
import excelUtility.ExcelRead;
import pomClasses.POMLogin;
import pomClasses.POMUnit;
import webdriverUtility.Driver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class UnitPageCrossBrowser {
	
	
	
	POMLogin objPOMLogin;
	POMUnit objPOMUnit;
	SoftAssert softassert=new SoftAssert();
	
	
	static String url="https://qalegend.com/billing/public/login";
	

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
	public void unitAdd(String name,String shortname) throws Exception {
		objPOMUnit.unitDetails();
		//objPOMUnit.addunitDetails("vidya_unit", "vidhya" );
		String objName=name;
		String objShortName=shortname;
		objPOMUnit.addunitDetails(name,shortname);	
	String actualmessage=objPOMUnit.verifySuccessMessage();
	String expectedmessage="Unit added successfully";
	Assert.assertTrue(expectedmessage.contains(actualmessage));
	
	}
	@Test(priority=3,enabled=true)
	public void unitSearch() throws Exception {
	boolean value=objPOMUnit.searchunitDetails(PropertyFileRead.readConfigFile("searchdetails"));
	
	softassert.assertEquals(value, true);
	}	
	
	@Test(priority=4,enabled=true)
	public void deleteunit() throws Exception {
		objPOMUnit.deleteunitDetails();
		String actualmessage=objPOMUnit.verifyDeleteMessage();
		String expectedmessage="Unit deleted successfully";
	softassert.assertTrue(expectedmessage.contains(actualmessage));
		
	}
  @BeforeTest	
  @Parameters({"browser2"})
  public void beforeTest(String browser2)throws InterruptedException {
		
		Driver objUnit=new Driver();
		objUnit.launchBrowser(url,browser2);
		driver=objUnit.driver;
		objPOMLogin=new POMLogin(driver);
		objPOMUnit=new POMUnit(driver);
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
	  twitterdata[0][0]="vidya_unit";
	  //Enter data to row 0 column 1
	  twitterdata[0][1]="vidhya";
return twitterdata;
	  }

  }
