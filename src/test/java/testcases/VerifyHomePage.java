package testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.HomePage;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyHomePage {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUP()
	{
		
		driver=BrowserFactory.getBrowser("firefox");
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	}
	
	@Test(groups={"smoke"})
	public void testHomePage()
	{
		//WebDriver driver=BrowserFactory.getBrowser("firefox");
		//driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		String title=home.getApplicationTiltle();
		System.out.println("My application title is"+title);
		Assert.assertTrue(title.contains("Demo Store"));
		//BrowserFactory.closeBrowser(driver);
	}
	
	@AfterMethod
	public void tearDown()
	{
		BrowserFactory.closeBrowser(driver);
	}

}

