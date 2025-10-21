package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.myAccountPage;

public class TC002_loginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public void varify_login() {
		logger.info("*****Starting TC002_loginTest*****");
		
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clicklogin();
		
		
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		myAccountPage ap= new myAccountPage(driver);
		boolean status=ap.isMyAccountPageisExists();
		logger.info("validating the page*****");
		Assert.assertTrue(status);
		
		}
		catch(Exception e) {
			
		Assert.fail();
}
		logger.info("****fished TC002_loginTest *****");
	}
	
}
