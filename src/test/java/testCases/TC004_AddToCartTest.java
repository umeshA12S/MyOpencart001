package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.AddToCartPage;
import pageObjects.SearchPage;

public class TC004_AddToCartTest extends BaseClass{ 

	//create obeject of search page
	@Test(groups = {"Regression", "Master"})
	
	public void varifyAddToCart() throws InterruptedException  {
		
	SearchPage obj = new SearchPage(driver);
	obj.enterSearchField("mac");
	obj.clickSearch();
	obj.clickproductname();

	
	AddToCartPage cart = new AddToCartPage(driver);
	
	cart.enterQt("2");
	cart.clickAddToCart();
	Thread.sleep(3000);
	cart.varifyconfMsg();
	cart.clickCartItemsbutton();
	cart.clickviewCart();
	cart.varifyShopingcartText();
	Thread.sleep(3000);
		
		if(cart.varifyShopingcartText().equals("Shopping Cart")) {
			
			Assert.assertTrue(true);
		}
		else {
			Assert.fail("Incorrect text");
		}
	
			
	}
	
	
}




