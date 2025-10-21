package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends basePage {
	
	
	public HomePage(WebDriver driver ){
		super(driver);
	}

	//locate the elements 
	
	@FindBy(xpath= "//span[normalize-space()='My Account']") WebElement myAccountElement;
	@FindBy(xpath= "//a[normalize-space()='Register']") WebElement registerElement;
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
    	   WebElement loginlLink;
	//action methods
	
	public void clickMyAccount() {
		
		myAccountElement.click();
	}
    public void clickRegister() {
		
    	registerElement.click();
	}
    public void clicklogin() {
    	
    	loginlLink.click();
    }
	
}
