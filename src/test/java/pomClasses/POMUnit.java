package pomClasses;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import waitUtility.WaitUtilitys;
import webdriverUtility.WebDriverActions;

public class POMUnit {
	WebDriverActions objDriverActions;
	public WebDriver driver;
	WaitUtilitys objWait;
	
	
	public POMUnit(WebDriver driver)
	
	{
		this.driver=driver;
		objDriverActions = new WebDriverActions(driver);
		PageFactory.initElements(driver, this);
	}
	
	
		@FindBy(xpath="//*[@id=\"tour_step5\"]/ul/li[8]/a/span")
		public WebElement Units;
		@FindBy(xpath="/html/body/div[2]/div[1]/section[2]/div[1]/div[1]/div/button")
		public WebElement Add;
		@FindBy(xpath="//*[@id=\"actual_name\"]")
		public WebElement Name;
		@FindBy(xpath="//*[@id=\"short_name\"]")
		public WebElement ShortName;
		@FindBy(xpath="//*[@id=\"allow_decimal\"]")
		public WebElement AllowDecimal;
		@FindBy(xpath="//button[@class='btn btn-primary']")
		public WebElement Save;
		@FindBy(xpath="//*[@id='toast-container']/div")
		public WebElement SuccessMessage;
		@FindBy(xpath="//*[@id=\"unit_table_filter\"]/label/input")
		public WebElement SearchBox;
		@FindBy(xpath="//table[@id='unit_table']/tbody/tr/td[1]")
		public WebElement Webtable;
		@FindBy(xpath="//*[@id='unit_table']/tbody/tr[1]/td[4]/button[2]")
		public WebElement Deletebutton;
		@FindBy(xpath="/html/body/div[4]/div/div[4]/div[2]/button")
		public WebElement OK;
		@FindBy(xpath="	//*[@id='toast-container']/div")
		public WebElement DeleteMessage;
	
public void unitDetails() throws InterruptedException
{
	objWait=new WaitUtilitys(driver);
	objWait.normalWait(3000);
	objDriverActions.click(Units);
	objWait.normalWait(3000);

}
public void addunitDetails(String name,String shortname) throws InterruptedException {	
objDriverActions.click(Add);
objWait.normalWait(3000);
objDriverActions.sendkeys(Name,name);
objDriverActions.sendkeys(ShortName,shortname );
objDriverActions.dropdownselectByIndex(AllowDecimal,1);
objDriverActions.click(Save);
objWait.presenceOfElementLocated(By.xpath("//*[@id='toast-container']/div"),5);
}
public String verifySuccessMessage() {
String message=objDriverActions.getText(SuccessMessage);

System.out.println("Successmessage="+message);

return message;

}
public boolean isSearchunitDetails(String message) throws InterruptedException {	
	objDriverActions.click(SearchBox);
	objDriverActions.sendkeys(SearchBox,message);
	Thread.sleep(3000);
String tablename=objDriverActions.getText(Webtable);
Thread.sleep(3000);
if(tablename.equalsIgnoreCase(message))
{
	return true;
	
}
else
{
	return false;
}}
public void deleteunitDetails() throws InterruptedException {	
	objDriverActions.click(Deletebutton);
	Thread.sleep(3000);
	objDriverActions.click(OK);
	objWait.presenceOfElementLocated(By.xpath("//*[@id='toast-container']/div"),5);
	
}
public String verifyDeleteMessage() {

String messagedeletem=objDriverActions.getText(DeleteMessage);
System.out.println("Deletemessage="+messagedeletem);

return messagedeletem;

}
}

