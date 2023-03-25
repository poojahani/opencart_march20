package testCases;

import static org.testng.Assert.expectThrows;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class Tc_003_LoginDDT extends BaseClass{
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void test_loginDDT(String email,String password,String exp)

	{
		logger.info("Starting TC_003_LoginTest");
		
		try {
			
		
		HomePage hp=new HomePage(driver);
		hp.clickLoginpage();
		
		LoginPage lp=new LoginPage(driver);
		
		lp.setEmail(email); // valid email, get it from properties file
		
		lp.setPassword(password); // valid password, get it from properties file
		
		lp.clickLogin();
		
		MyAccountPage macc=new MyAccountPage(driver);
		
		boolean targetpage=macc.isMyAccountPageExists();
					
		if(exp.equals("Valid"))
		{
			if(targetpage==true) {
				macc.clickLogout();
				Assert.assertTrue(true);
			}else
			{
				Assert.assertTrue(false);
			}
		
		}
		if(exp.equals("Invalid"))
		{
			if(targetpage==true) {
				macc.clickLogout();
				Assert.assertTrue(false);
			}else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("******Test is closed*****");
		
	}
}
