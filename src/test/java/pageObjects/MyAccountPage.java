package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath = "//h2[text()='My Account']") // MyAccount Page heading
	WebElement msgHeading;
	
	@FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
	WebElement lnkLogout;
	@FindBy(xpath = "//h1[normalize-space()='Welcome to OpenCart Ecommerce Blog']")
	WebElement getBlog;
	@FindBy(xpath = "//div[@class='page-header']")
	WebElement getfeatures;
	
	
	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}

	public void clickLogout() {
		lnkLogout.click();

	}

	public String get_BlogTitle() {
		String ss=getBlog.getText();
		return ss;
	}
	public String get_FeatureTitle() {
		String ss=getfeatures.getText();
		return ss;
	}
	


}
