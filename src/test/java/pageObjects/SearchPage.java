package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends basePage {

	public SearchPage (WebDriver driver){
		
		super(driver);
	}
	//locate the element
	@FindBy(xpath="//input[@placeholder='Search']") WebElement search;
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']") WebElement searchIcon;
	@FindBy(xpath="//div[@class='caption']//a[contains(text(),'iMac')]") WebElement imacProduct;

   //action methods
	
	public void enterSearchField(String pname) {
		
		search.sendKeys(pname);
	}

	public void clickSearch() {
		
		searchIcon.click();
	}
	
    public void clickproductname() {
		
		imacProduct.click();
	}

}
