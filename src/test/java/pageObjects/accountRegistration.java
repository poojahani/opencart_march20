package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class accountRegistration extends BasePage {

	public accountRegistration(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='input-username']")
	WebElement user_name;
	@FindBy(name = "firstname")
	WebElement first_name;
	@FindBy(name = "lastname")
	WebElement last_name;
	@FindBy(name = "email")
	WebElement email;
	@FindBy(name = "password")
	WebElement pwd;
	@FindBy(xpath = "//div[@id='captcha']")
	WebElement captcha;
	@FindBy(id = "id=\"button-register\"")
	WebElement Register;
	@FindBy(xpath = "//h3[normalize-space()='Welcome to OpenCart, your account has been created']")
	WebElement msgConfirmation;
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement btnContinue;
	public void setUserName(String username) {
		user_name.sendKeys(username);
	}

	public void setFirsrName(String firstName) {

		first_name.sendKeys(firstName);
	}

	public void setLastName(String lastName) {

		last_name.sendKeys(lastName);
	}

	public void setemail(String eml) {

		email.sendKeys(eml);
	}

	public void setpassword(String pwrd) {

		pwd.sendKeys(pwrd);
	}

	public void setCaptch(String cap) {

		captcha.sendKeys(cap);
	}

	public void setReg(String Registr) {

		Register.sendKeys(Registr);
	}
	public void clickContinue() {

		btnContinue.click();
	}
	public void dropdown() {
		Select drpdwn = new Select(driver.findElement(By.id("input-country")));
		drpdwn.selectByVisibleText("India");
	}
	
 public String getConfirmationMsg(){

	 try {
		 return(msgConfirmation.getText());
		 
	 }catch(Exception e){
		 return (e.getMessage());
	 }
}
}