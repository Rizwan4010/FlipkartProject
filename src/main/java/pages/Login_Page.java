package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseLibrary;

public class Login_Page extends BaseLibrary {

	public Login_Page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser userLoggedOut']")
	private WebElement LoginButton;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement UserID;
	
	@FindBy(xpath = "//*[@class='capText font16']")
	private WebElement ContinueButton;

	@FindBy(xpath = "//input[@id='password']")
	private WebElement Password;

	@FindBy(xpath = "//button[@class='capText font16']")
	private WebElement Login;

	public void pageLogin() {
		clickMe(LoginButton);
		type(UserID, "rizwan.dev6@gmail.com");
		pressEnter();
		type(Password, "Rizwan@1234");
		pressEnter();
	}

}
