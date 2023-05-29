package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	
	WebDriver driver;

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
//Elements
	@FindBy (xpath = "//span[text()='My Account']")
	WebElement lnkMyaccount;
	
	
	@FindBy (xpath = "(//a[@class='dropdown-item'])[4]")
	WebElement lnkRegister;
	
	@FindBy (xpath = "//a[text()='Login']")
	WebElement linklogin;
	
	
	
//Action Methods
	
	public void clickMyAccount() 
	{
		lnkMyaccount.click();
//		JavascriptExecutor js = (JavascriptExecutor)driver;		
//		js.executeScript("arguments[0].click();", lnkMyaccount);
	}
	
	public void clickRegister() 
	{
		lnkMyaccount.click();
//		JavascriptExecutor js = (JavascriptExecutor)driver;		
//		js.executeScript("arguments[0].click();", lnkRegister);
		
	}
	
	public void clicklogin() 
	{
		linklogin.click();
	}
}
