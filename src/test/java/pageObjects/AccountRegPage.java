package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegPage extends basePage{
	
	public AccountRegPage(WebDriver driver){
		super(driver);
	}
	
	//locate the page elements
	
	@FindBy(xpath= "//input[@id='input-firstname']")WebElement txtFirstName;
	@FindBy(xpath= "//input[@id='input-lastname']") WebElement txtLastName;
	@FindBy(xpath= "//input[@id='input-email']")    WebElement txtEmail;
	@FindBy(xpath= "//input[@id='input-telephone']")WebElement txtTelephone;
	@FindBy(xpath= "//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath ="//input[@id='input-confirm']") WebElement txtConfPassword;
	@FindBy(xpath= "//input[@name='agree']")        WebElement chkPrivacy;
	@FindBy(xpath="//input[@value='Continue']")  WebElement btnContinue;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement conftext;
	//xpath="//input[@name='agree']"
	

	
	//Action methods 
	
	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}
	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}
	public void setEmail(String ename) {
		txtEmail.sendKeys(ename);
	}
	public void setTelephone(String telenum) {
		txtTelephone.sendKeys(telenum);
	}
	public void setPwd(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	public void setConfpwd(String pwd) {
		txtConfPassword.sendKeys(pwd);
	}
	public void clickPrivacy() {
		chkPrivacy.click();
	}
	public void clickContinuebtn() {
		btnContinue.click();
	}
	
	public String getConfmessage() {
		try {
		return(conftext.getText());
	}
		catch(Exception e) {
			return e.getMessage();
		}
		}
}
