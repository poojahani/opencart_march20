package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class Tc_005_Blog extends BaseClass{
	@Test(groups={"Regression"}) 
	public void get_BlogTitle() throws InterruptedException{
		logger.info("*****Starting TC_005_LoginTest*******");
		Thread.sleep(2000);
		HomePage hp =new HomePage(driver);
		hp.clickOnBlog();
		Thread.sleep(2000);
		MyAccountPage map= new  MyAccountPage(driver);
		String title= map.get_BlogTitle();
	    System.out.println("Print the Title of the blog"+title);
		Thread.sleep(1000);
		Assert.assertEquals(title, "Welcome to OpenCart Ecommerce Blog");
		Thread.sleep(1000);
		
	}
}
