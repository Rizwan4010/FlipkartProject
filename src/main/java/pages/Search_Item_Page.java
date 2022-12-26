package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseLibrary;

public class Search_Item_Page extends BaseLibrary {
	
	
	public Search_Item_Page(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath="//input[@placeholder='Search for products, brands and more']")
	private WebElement SearchBar;
	
	
	public void ClickOnElement() {
		SearchBar.click();
		SearchBar.sendKeys("Iphone 14");
		pressEnter();
	}
}
