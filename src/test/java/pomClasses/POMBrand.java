package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import waitUtility.WaitUtilitys;
import webdriverUtility.WebDriverActions;

public class POMBrand {


	
	
WebDriverActions objDriverActions;
WaitUtilitys objWait;
WebDriver driver;
public static String brandmessage="";
public POMBrand(WebDriver driver)
{
	this.driver=driver;
	objDriverActions = new WebDriverActions(driver);
	PageFactory.initElements(driver, this);
}
	@FindBy(xpath="//*[@id=\"tour_step5\"]/ul/li[10]/a")
	public WebElement Brands;
	@FindBy(xpath="/html/body/div[2]/div[1]/section[2]/div[1]/div[1]/div/button")
	public WebElement AddBrands;
	@FindBy(xpath="//*[@id=\"name\"]")
	public WebElement BrandName;
	@FindBy(xpath="//*[@id=\"description\"]")
	public WebElement BrandDesc;
	@FindBy(xpath="//*[@id=\"brand_add_form\"]/div[3]/button[1]")
	public WebElement BrandSave;
	@FindBy(xpath="/html/body/div[3]")
	public WebElement Brandmessage;
	@FindBy(xpath="//*[@id=\"brands_table_filter\"]/label/input")
	public WebElement Brandsearchbox;
	@FindBy(xpath="")
	public WebElement Webtablebrand;

	
public void branddetails() throws InterruptedException {
	Thread.sleep(3000);
	objDriverActions.click(Brands);
	Thread.sleep(5000);
}
	public void addbranddetails(String namebrand,String descbrand) throws InterruptedException {
		Thread.sleep(3000);
	objDriverActions.click(AddBrands);
	Thread.sleep(3000);
	objDriverActions.sendkeys(BrandName, namebrand);
	objDriverActions.sendkeys(BrandDesc, descbrand);
	objDriverActions.click(BrandSave);
	Thread.sleep(3000);
	brandmessage=objDriverActions.getText(Brandmessage);
	}
	public boolean searchBrandDetails(String messagebrand) throws InterruptedException {
		objDriverActions.click(Brandsearchbox);
		objDriverActions.sendkeys(Brandsearchbox,messagebrand);
		Thread.sleep(3000);
		String tablenamebrand=objDriverActions.getText(Webtablebrand);
		Thread.sleep(3000);
		if(tablenamebrand.equalsIgnoreCase(messagebrand))
		{
			return true;
			
		}
		else
		{
			return false;
		}

		
		
		
	}}