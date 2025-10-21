package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends basePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath ="//input[@id='input-email']") WebElement txtEmailAdress;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//input[@value='Login']") WebElement loginBtn;
	
	
	public void setEmail(String email) {
		txtEmailAdress.sendKeys(email);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin() {
		
		loginBtn.click();
	}
}
