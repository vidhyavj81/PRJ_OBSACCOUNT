package sequentialTestCases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import commonUtility.PropertyFileRead;
import excelUtility.ExcelRead;
import pomClasses.POMBrand;
import pomClasses.POMCategories;
import pomClasses.POMLogin;
import pomClasses.POMUnit;
import webdriverUtility.Driver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class CategoriesPageSeq {
	POMLogin objPOMLogin;
	POMCategories objPOMCategories;
	LoginPageSeq objloginSeq=new LoginPageSeq();
	SoftAssert softassert=new SoftAssert();
	
	public static WebDriver driver;		
	
	@Test(priority=1,enabled=true,dataProvider="testdata")
	public void categoriesAdd(String namecat,String codecat)throws InterruptedException{
		objPOMLogin=new POMLogin(objloginSeq.driver);		
		objPOMCategories=new POMCategories(objloginSeq.driver);
		objPOMCategories.categoriesdetails();
		String objCatName=namecat;
		String objCatCode=codecat;
		objPOMCategories.addcategoriesdetails(namecat,codecat);	
		String actualmessage=objPOMCategories.verifySuccessMessageCat();
		String expectedmessage="Category added successfully";
		Assert.assertTrue(expectedmessage.contains(actualmessage));
		
		}
		@Test(priority=2,enabled=true)
		public void categoriesSearch()throws InterruptedException{
		
		boolean value1=objPOMCategories.searchcategoriesDetails(PropertyFileRead.readConfigFile("searchdetailscategory"));
		softassert.assertEquals(value1, true);
		softassert.assertAll();
		}
		@Test(priority=3,enabled=true)
		public void deletecategoriesDetails() throws Exception {
			objPOMCategories.deletecategoriesDetails();
			String actualmessage=objPOMCategories.verifyDeleteMessageCat();
			String expectedmessage="Category deleted successfully";
			softassert.assertTrue(expectedmessage.contains(actualmessage));
			softassert.assertAll();
			
		}
	
	 @AfterTest
	 public void afterTest() {
		 objloginSeq.driver.close();
	 }
	
  @DataProvider(name="testdata")
  public Object[][]TestDataFeed(){
	  //Create object array with 2 rows and 2 column-first parameter is row and second is column
	  Object[][] twitterdata=new Object[1][2];
	  //Enter data to row 0 column 0
	  twitterdata[0][0]="utensils";
	  //Enter data to row 0 column 1
	  twitterdata[0][1]="abc";
return twitterdata;
	  }

  }
  
