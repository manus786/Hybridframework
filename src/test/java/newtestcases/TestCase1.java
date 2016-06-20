package newtestcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.HomePage;
import factory.DataProviderFactory;
import Base.BaseClass;

public class TestCase1 extends BaseClass 
{

	@Parameters("Browser")
	@Test
	public void test1(String browser)
	{
	 driver=startBrowser(browser);
	 driver.get(DataProviderFactory.getConfig().getApplicationUrl());
	 HomePage home=PageFactory.initElements(driver, HomePage.class);
	 String title=home.getApplicationTiltle();
	 System.out.println("My application title is"+title);
	 Assert.assertTrue(title.contains("Demo Store"));
		
	}
}
