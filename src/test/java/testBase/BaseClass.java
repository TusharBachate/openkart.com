package testBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public Logger logger; //for logging 
	
	
	public ResourceBundle rb;
	
	@BeforeClass (groups = {"Master","Sanity","Regression"})
	@Parameters("browser")
	public void setup( String br) 
	{
		
		rb = ResourceBundle.getBundle("config"); // Load config
		
		logger = LogManager.getLogger(this.getClass()); //logging
		
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("excludeSwitches",new String[] {"enable-automation"});
		
		WebDriverManager.chromedriver().setup();
		if(br.equals("chrome"))
		{
		driver=new ChromeDriver(options);
		}
		else if(br.equals("edge"))
		{
		driver=new EdgeDriver();
		}
		else
		{
			driver = new FirefoxDriver();
		}	
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	//	driver.get("https://demo.opencart.com/");
		driver.get(rb.getString("appURL2"));
		
		//https://demo.opencart.com/
		driver.manage().window().maximize();
	}
	
	@AfterClass (groups = {"Master","Sanity","Regression"})
	public void tearDown()
	{
		driver.quit();
	}
	
	public String randomeString() 
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}
	
	public String randomeNumber() 
	{
		String genratedString2 = RandomStringUtils.randomNumeric(10);
		return (genratedString2);
	}
	
	public String randomalphaNumeric() 
	{
		String num = RandomStringUtils.randomNumeric(4);
		String str = RandomStringUtils.randomAlphabetic(5);
		return (str+"@"+num);
	}
	
	public String captureScreen(String tname) throws IOException
	{
		
//		SimpleDateFormat df = new SimpleDateFormat("yyyymmddhhmmss");
//		
//		Date dt = new Date();
//		
//		String timestamp = df.format(dt);
		
		String timeStamp = new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		
		
		TakesScreenshot takeScreenShot = (TakesScreenshot)driver;
		File Source = takeScreenShot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenshots\\"+tname+"_"+timeStamp+".png";
		
		try  
		{
			FileUtils.copyFile(Source, new File(destination));
		}
		catch (Exception e)
		{
			e.getMessage();
		}
			return destination;
		
		}
		
	}
	


