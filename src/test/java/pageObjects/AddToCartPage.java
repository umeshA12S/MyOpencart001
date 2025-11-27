package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends basePage {

	public AddToCartPage(WebDriver driver) {
		super(driver);
	}
		//locate the elements
		

		@FindBy(xpath="//input[@id='input-quantity']") WebElement Qty;
		@FindBy(xpath="//button[@id='button-cart']") WebElement addToCart;
		@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement confMsg;
		@FindBy(xpath="//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']") WebElement CartItemsbutton;
		@FindBy(xpath="//strong[normalize-space()='View Cart']") WebElement viewCart;
		@FindBy(xpath="//a[contains(text(),'Shopping Cart')]") WebElement ShopingcartText;
		
		
		//action methods
		
		public void enterQt(String numOfQty) {
		 Qty.clear();
	      Qty.sendKeys(numOfQty);
		}
		
		public void clickAddToCart() {
			
			addToCart.click();
		}
		
	public boolean varifyconfMsg() {
		 
		return confMsg.isDisplayed();
     }

	public void clickCartItemsbutton() {
		
		CartItemsbutton.click();
	}
	
	public void clickviewCart() {
			
		viewCart.click();
	}
		
	public String varifyShopingcartText() {
		
		return ShopingcartText.getText();
	}
	

}
