package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	//Elements
	
	@FindBy (xpath = "//input[@name='firstname']")
	WebElement txtFirstname;
	
	@FindBy (xpath = "//input[@name='lastname']")
	WebElement txtLastname;
	
	@FindBy (xpath = "//input[@name='email']")
	WebElement txtemail;
	
	//@FindBy (xpath = "")
	//WebElement txtTelephone;
	
	@FindBy (xpath = "//input[@name='password']")
	WebElement txtPassword;
	
	@FindBy (xpath = "(//input[@name='newsletter'])[2]")
	WebElement newsletter;
	
	@FindBy (xpath = "//input[@type='checkbox']")
	WebElement Chkdpolicy;
	
	@FindBy (xpath = "//button[text()='Continue']")
	WebElement btnContinue;
	
	@FindBy (xpath = "")
	WebElement msgConfirmation;
	
	public void setFirstname(String fname) 
	{
		txtFirstname.sendKeys(fname);
	}
	public void setLastname (String lname)
	{
		txtLastname.sendKeys(lname);
	}	
	
	public void setEmail(String email)
	{
		txtemail.sendKeys(email);
	}
	
	public void setNewsletter() 
	{
		newsletter.click();
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
//	public void setconfirmPassword(String pwd)
//	{
//		txtconfirmPassword.sendKeys();
//	}	
	
	public void setPrivacyPolicy()
	{
		Chkdpolicy.click();
		
	}
	
	public void clickContinue() 
	{
		btnContinue.click();
	}
	
	public String getconfirmationMsg()
	{
		try {
		return (msgConfirmation.getText());
		}
		catch(Exception e) 
		{
			return (e.getMessage());
		}
		
	}
}
