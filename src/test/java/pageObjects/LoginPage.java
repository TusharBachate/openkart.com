package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy (xpath = "'//input[@id='input-email']'")
	WebElement txtemailAdd;
	
	@FindBy (xpath = "//input[@type='password']")
	WebElement txtpassword;
	
	@FindBy (xpath = "//button[@type='submit']")
	WebElement btnlogin;
	

	public void SetEmail(String email)
	{
		txtemailAdd.sendKeys(email);
	}
	
	public void SetPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void ClickonLogin()
	{
		btnlogin.click();
	}
	
	
}
