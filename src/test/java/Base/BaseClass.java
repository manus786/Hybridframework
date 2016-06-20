package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass 

{
    
	protected WebDriver driver;
	
	@Parameters("Browser")
	@BeforeMethod
	public WebDriver startBrowser(@Optional String browser)
	{
		
		if(driver==null)
		{
			if(browser.equalsIgnoreCase("Firefox"))
			{
				driver=new FirefoxDriver();
			}
			else
			{
				driver=new FirefoxDriver();
			}
		}
		
		driver.manage().window().maximize();
		return driver;
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
	
	
	
}
