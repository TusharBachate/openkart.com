package testCases;





import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_Account_Registration_Test extends BaseClass  {
	
	
	 
	@Test (groups = {"Regression,Master"})
	public void test_account_Registration()
	{
		logger.debug("application logs..........");
		logger.info("**** Strarting TC_001_AccountRegistrationTest **** ");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		
		logger.info("CLICKED ON MY ACCOUNT ");
		
		hp.clickRegister();
		
		logger.info("CLICKED ON REGISTER");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("Providing customer data");
		
		regpage.setFirstname(randomeString().toUpperCase());
		
		regpage.setLastname(randomeString().toUpperCase());
		
		regpage.setEmail(randomeString()+"@gmail.com");
		
		regpage.setPassword(randomalphaNumeric());
		
		//for same password to confirm password
		//String password = randomAlphanumberic();
		//ragpage.setpassword(password);
		//regpage.setconfirmPassword(Password);
;		
		regpage.setNewsletter();
		
		regpage.setPrivacyPolicy();
		
		regpage.clickContinue();
		
		logger.info("CLICKED ON CONTINUE");
		
		String confmsg = regpage.getconfirmationMsg();
		
		logger.info("Validating expected message");
		//Assert.assertEquals( confmsg,"Your Account has been created","Not getting expected message);
	
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			Assert.fail();

		}
		
		logger.info("**** Finished TC_001_AccountRegistrationTest **** ");
	}
	
	
	
}
