package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.myAccountPage;
import utilities.DataProviders;


public class TC003_VarifyLoginDDT_Test extends BaseClass{

	
	@Test(dataProvider="420", dataProviderClass= DataProviders.class)
	public void varifyLogin(String Username, String Password,String result)

 {
	logger.info("*****Starting TC003_VarifyLoginDDT_Test *****");	
	try {
	//HomePage-Object	
	HomePage hp = new HomePage(driver);
	hp.clickMyAccount();
	hp.clicklogin();
	
	//LoginPage-Object
	LoginPage lp = new LoginPage(driver);
	lp.setEmail(Username);
	lp.setPassword(Password);
	lp.clickLogin();
	
	//myAccountPage -Object
	myAccountPage ap = new myAccountPage(driver);
	boolean targetpage =ap.isMyAccountPageisExists();
	
	/*Data is valid - login success -test pass - logout
	  Data is valid - login failed - test fail

	  Data is invalid -login success -test fail -logout
	  Data is invalid -login failed -test pass            */
	
	if(result.equalsIgnoreCase("Valid")) {
		if(targetpage==true) {
			ap.clickLogout();
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
	}
	}
		if(result.equalsIgnoreCase("Invalid")) {
		
			if(targetpage ==true) {
		
			ap.clickLogout();
			Assert.assertTrue(false);
		}
		else {
			Assert.assertTrue(true);
		}
	}
	}catch(Exception e) {
		Assert.fail();
	}
	
		logger.info("*****Finished TC003_VarifyLoginDDT_Test *****");
	}
}
