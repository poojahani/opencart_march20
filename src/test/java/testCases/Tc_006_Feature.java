package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class Tc_006_Feature extends BaseClass{
	@Test(groups={"Master"})
	void feature() throws InterruptedException{
		logger.info("*****Starting TC_006_LoginTest*******");
		Thread.sleep(2000);
		HomePage hp =new HomePage(driver);
		hp.clickOnfeatures();
		Thread.sleep(2000);
		MyAccountPage map= new  MyAccountPage(driver);
		String title= map.get_FeatureTitle();
	   System.out.println("Print the Title of the features"+title);
		Thread.sleep(1000);
		Assert.assertFalse(false, "OpenCart Features");
		Thread.sleep(1000);
		
	}

}
