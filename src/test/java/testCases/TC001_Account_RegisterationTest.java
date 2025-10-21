package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.AccountRegPage;
import pageObjects.HomePage;

public class TC001_Account_RegisterationTest extends BaseClass {

	
	@Test(groups={"Sanity","Regression","Master"})
	
	public void varify_Account_registration() {
		
		logger.info("***Starting TC001_Account_RegisterationTest****");
		try {
			
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link");
		hp.clickRegister();
		logger.info("Clicked on Register Link");
		
		
		AccountRegPage rp = new AccountRegPage(driver);
		logger.info("Providing customer details....");
			rp.setFirstName(randomString());	
			rp.setLastName(randomString());
			rp.setEmail(randomString()+"@gmail.com");
			rp.setTelephone(randomNumber());
			
			String password=randomAlphaNumeric();
			rp.setPwd(password);
			rp.setConfpwd(password);
			rp.clickPrivacy();
			rp.clickContinuebtn();
	    logger.info("Validating expected message....");
	    
	   if(rp.getConfmessage().equals("Your Account Has Been Created!")) {
		   Assert.assertTrue(true);
	   }
	   else {
		   logger.error("Test Failed...");
		   logger.debug("Debug logs...");
		   Assert.assertTrue(false);
	   }
	//	Assert.assertEquals(rp.getConfmessage(), "Your Account Has Been Created!");
		}
		
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("finished TC001_Account_RegisterationTest ");
		}

}

	

