package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver ldriver)
	{
	this.driver=ldriver;

    }
	
	@FindBy(xpath="//a[text()='Sign In']") WebElement signInlink;
	@FindBy(xpath="//a[text()='My Account']") WebElement myAccountLink;
	@FindBy(xpath="//a[text()='My cart']") WebElement myCartlink;
	@FindBy(xpath="//a[text()='Checkout']") WebElement checkOutlink;
	
	public void clickOnSigninLink()
	{
		signInlink.click();
	}
	
	public void clickOnMyAccountLink()
	{
		myAccountLink.click();
	}
	public void clickOnMyCartlink()
	{
		myCartlink.click();
	}
	public void clickOnCheckOutlink()
	{
		checkOutlink.click();
	}
	public String getApplicationTiltle()
	{
		return driver.getTitle();
	}


	
}
