
package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.accountRegistration;
import testBase.BaseClass;

public class Tc_001_AccountRegistration extends BaseClass{

	@Test
	public void test_account_registration() throws Exception {
	//	try {
			
		logger.info("*****Starting TC_001_AccountRegistration ***");
	
	HomePage hp =new HomePage(driver);
	logger.info("get the home page data");
	hp.clickRegister();
	Thread.sleep(10000);
	logger.info("click on the Register");
	accountRegistration ac =new accountRegistration(driver);
	ac.setUserName(randomString());
	logger.info("Enter the username");
	ac.setFirsrName(randomString().toUpperCase());
	logger.info("Enter the firstname");
	ac.setLastName(randomString().toUpperCase());
	logger.info("Enter the second name");
	ac.setemail(randomString()+"gmail.com");
	logger.info("Enter the email");
	ac.dropdown();
	logger.info("Select the dropdown as India");
	ac.setpassword(randomAlpanumeric());
	logger.info("Set the password");
	
	String cfnMsg=ac.getConfirmationMsg();
	logger.info("Validating the Confermation message");
	Assert.assertEquals(cfnMsg, "Your account has been Created!","Test failed");
	//	}
	/*	catch(Exception e) {
			logger.error("Test failed");
			//Assert.fail();
		}
	logger.info("****TC_001_AccountRegistration Finished ");
	}*/
	}	
}
