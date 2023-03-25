package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import testBase.BaseClass;

public class TC_004_Title extends BaseClass{
	@Test(groups= {"Regression","Master"}) 
	public void get_Title() throws InterruptedException{
		logger.info("Starting TC_003_LoginTest");
		Thread.sleep(2000);
	String title=	driver.getTitle();
	System.out.println(title);
		Thread.sleep(1000);
		Assert.assertEquals(title, "OpenCart - Open Source Shopping Cart Solution");
		Thread.sleep(1000);
		
	}
	
	
	{
		
	}
}
