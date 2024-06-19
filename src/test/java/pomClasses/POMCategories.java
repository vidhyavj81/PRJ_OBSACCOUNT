package pomClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import waitUtility.WaitUtilitys;
import webdriverUtility.WebDriverActions;

public class POMCategories {
	WebDriverActions objDriverActions;
	WaitUtilitys objWait;
	
	WebDriver driver;
	

	
public POMCategories(WebDriver driver)
	{
		this.driver=driver;
		objDriverActions = new WebDriverActions(driver);
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath="//*[@id='tour_step5']/ul/li[9]/a/span")
		public WebElement Categories;
		@FindBy(xpath="/html/body/div[2]/div[1]/section[2]/div[1]/div[1]/div/button")
		public WebElement AddCat;
		@FindBy(xpath="//*[@id='name']")
		public WebElement CategoryName;
		@FindBy(xpath="//*[@id='short_code']")
		public WebElement CategoryCode;
		@FindBy(xpath="//*[@id='category_add_form']/div[3]/button[1]")
		public WebElement SaveCategory;
		@FindBy(xpath="//*[@id='toast-container']/div")
		public WebElement CategorySuccessMessage;
		@FindBy(xpath="//*[@id='category_table_filter']/label/input")
		public WebElement SearchCategory;
	
		@FindBy(xpath="//*[@id='category_table']/tbody/tr[1]/td[1]")
		public WebElement WebtableCat;
		@FindBy(xpath="//*[@id='category_table']/tbody/tr[1]/td[3]/button[2]")

		public WebElement Delete;
		@FindBy(xpath="/html/body/div[4]/div/div[4]/div[2]/button")
		public WebElement OKbutton;
		@FindBy(xpath="//*[@id='toast-container']/div")
		public WebElement Deletemessagecat;
		


public void categoriesdetails() throws InterruptedException {
	Thread.sleep(3000);
	objDriverActions.click(Categories);
	Thread.sleep(5000);
}
	public void addcategoriesdetails(String namecat,String codecat) throws InterruptedException {
		Thread.sleep(3000);
	objDriverActions.click(AddCat);
	Thread.sleep(3000);
	objDriverActions.sendkeys(CategoryName, namecat);
	objDriverActions.sendkeys(CategoryCode, codecat);
	objDriverActions.click(SaveCategory);
	objWait=new WaitUtilitys(driver);
	objWait.presenceOfElementLocated(By.xpath("//*[@id='toast-container']/div"),5);
	}
	public String verifySuccessMessageCat() {
		String message=objDriverActions.getText(CategorySuccessMessage);

		System.out.println("Successmessage="+message);

		return message;
	}
	public boolean searchcategoriesDetails(String messagecat) throws InterruptedException {	
		objDriverActions.click(SearchCategory);
		objDriverActions.sendkeys(SearchCategory,messagecat);
		Thread.sleep(3000);
		String tablenamecat=objDriverActions.getText(WebtableCat);
		Thread.sleep(3000);
		if(tablenamecat.equalsIgnoreCase(messagecat))
		{
			return true;
			
		}
		else
		{
			return false;
		}

		}
	public void deletecategoriesDetails() throws InterruptedException {	
		objDriverActions.click(Delete);
		Thread.sleep(3000);
		objDriverActions.click(OKbutton);
		objWait.presenceOfElementLocated(By.xpath("//*[@id='toast-container']/div"),5);
		
	}
	public String verifyDeleteMessageCat() {

	String messagedeletem=objDriverActions.getText(Deletemessagecat);
	System.out.println("Deletemessage="+messagedeletem);

	return messagedeletem;

	}
	}
		