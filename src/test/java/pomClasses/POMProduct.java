package pomClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import waitUtility.WaitUtilitys;
import webdriverUtility.WebDriverActions;

public class POMProduct {
	WebDriverActions objDriverActions;
	WebDriver driver;
	WaitUtilitys objWait;
	public POMProduct(WebDriver driver)
	{
		this.driver=driver;
		objDriverActions = new WebDriverActions(driver);//insta
		PageFactory.initElements(driver, this);//elements intialize
	}
		@FindBy(xpath="//*[@id=\"tour_step5\"]/ul/li[2]/a")
		public WebElement AddProduct;
		@FindBy(xpath="//*[@id='name']")
		public WebElement Productname;
		@FindBy(xpath="//*[@id='select2-brand_id-container']")
		public WebElement Brand;
		@FindBy(xpath="/html/body/span/span/span[1]/input")
		public WebElement BrandSelect;
		@FindBy(xpath="//ul[@id='select2-brand_id-results']/li[1]")
		public WebElement BrandSearch;
		@FindBy(xpath="//*[@id='select2-category_id-container']")
		public WebElement Category;
		@FindBy(xpath="/html/body/span/span/span[1]/input")
		public WebElement CategorySelect;
		@FindBy(xpath="//ul[@id='select2-category_id-results']/li[1]")
		public WebElement CategorySearch;
		
	
		
		@FindBy(xpath="//*[@id='alert_quantity']")
		public WebElement Alertquantity;
		@FindBy(xpath="//*[@id='expiry_period']")
		public WebElement ExpiryDate;
		@FindBy(xpath="//*[@id='single_dpp']")
		public WebElement Tax;
		@FindBy(xpath="//*[@id=\"product_add_form\"]/div[4]/div/div/div/button[4]")
		public WebElement Save;

public void addProductDetails(String name,String brandname,String categoryname,String alertnum,String month,String tax) throws InterruptedException {	
Thread.sleep(3000);
objDriverActions.click(AddProduct);
Thread.sleep(3000);
objDriverActions.sendkeys(Productname,name);
Thread.sleep(3000);
objDriverActions.click(Brand);
Thread.sleep(3000);
objDriverActions.sendkeys(BrandSelect,brandname);
objDriverActions.click(BrandSearch);
Thread.sleep(3000);
objDriverActions.click(Category);
Thread.sleep(3000);
objDriverActions.sendkeys(CategorySelect, categoryname);
Thread.sleep(3000);
objDriverActions.click(CategorySearch);
Thread.sleep(3000);

objDriverActions.sendkeys(Alertquantity, alertnum);
Thread.sleep(3000);
objDriverActions.sendkeys(ExpiryDate, month);
Thread.sleep(3000);
objDriverActions.sendkeys(Tax,tax);
Thread.sleep(3000);
objDriverActions.click(Save);
Thread.sleep(3000);

}}