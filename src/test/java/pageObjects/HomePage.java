package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	//Elements
	@FindBy(xpath = "//a[@class='btn btn-black navbar-btn']")
	WebElement lnk_Register;
	@FindBy(xpath = "//a[@class='btn btn-link navbar-btn']")
	WebElement lnk_Login;
	@FindBy(xpath = "//a[normalize-space()='Blog']")
	WebElement clk_Blog;
	@FindBy(xpath = "(//a[normalize-space()='Features'])[1]")
	WebElement clk_features;
	
	
	
	//Axtion methds
	
	public void clickRegister() {
		lnk_Register.click();
	}
	public void clickLoginpage(){
		lnk_Login.click();
	}
	public void clickOnBlog(){
		clk_Blog.click();
	}
	public void clickOnfeatures(){
		clk_features.click();
	}
	

}
