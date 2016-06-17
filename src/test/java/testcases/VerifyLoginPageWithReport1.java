package testcases;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.HomePage;
import pages.LoginPage;
import utility.Helper;
import factory.BrowserFactory;
import factory.DataProviderFactory;

public class VerifyLoginPageWithReport1 {
	
	WebDriver driver;
	
	ExtentReports report;
	
	ExtentTest logger;
	
	@BeforeMethod
	public void setUP()
	{
		report = new ExtentReports(".\\Reports\\LoginPageReport.html", true);
		
		//logger = new ExtentTest("Verify login page","This page will verfiy sign out link");
		
		logger=report.startTest("verfiy test Login");
		
		 driver=BrowserFactory.getBrowser("firefox");
		 
		driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		
		logger.log(LogStatus.INFO, "Application is up and running");
	}
	
	@Test
	public void testHomePage()
	{
		//WebDriver driver=BrowserFactory.getBrowser("firefox");
		//driver.get(DataProviderFactory.getConfig().getApplicationUrl());
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		String title=home.getApplicationTiltle();
		
		System.out.println("My application title is"+title);
		
		Assert.assertTrue(title.contains("Demo Store"));
		
		logger.log(LogStatus.PASS, "Home page loaded and verified");
		
		home.clickOnSigninLink();
		
		logger.log(LogStatus.INFO, "Click on signout link");
		
		//BrowserFactory.closeBrowser(driver);
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		
		login.loginApplication(DataProviderFactory.getExcel().getData(0, 0, 0),
				DataProviderFactory.getExcel().getData(0, 0, 1));
		
		logger.log(LogStatus.INFO, "Login to Application");
		
		login.verifySignOutLink();
		
		logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenshot(driver, "validation2")));
		
		logger.log(LogStatus.PASS, "signout link is present");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result)
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String path=Helper.captureScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(path));
		}
		BrowserFactory.closeBrowser(driver);
		report.endTest(logger);
		report.flush();
	}

}

