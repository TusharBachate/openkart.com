package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass{
	
	@Test (groups = {"Sanity","Master"})
	
	public void test_Login() 
	{
		try {
		logger.info("**** starting tc_002_logintest ****");
		
		HomePage hp = new HomePage(driver);
	
		hp.clickMyAccount();
		logger.info("Clicked on my Account");
		hp.clicklogin();
		logger.info("Clicked on login ");
		
		LoginPage lp = new LoginPage(driver);
		logger.info("providing login deatils");  
		lp.SetEmail(rb.getString("email"));
		lp.SetPassword(rb.getString("password"));
		lp.ClickonLogin();
		logger.info("Clicked on login btn");
		
		MyAccountPage macc = new MyAccountPage(driver);
		boolean targetpage =macc.isMyAccountPageExists();
		Assert.assertEquals(targetpage, true,"Login Failed");
		}
		catch (Exception e)
		{
			Assert.fail();
		}
		logger.info("**** Finished TC_002_LoginTest ****");
	}


}
