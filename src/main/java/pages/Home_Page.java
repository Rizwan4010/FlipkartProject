package pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseLibrary;

public class Home_Page extends BaseLibrary {

	public Home_Page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@alt='Make My Trip']")
	private WebElement Logo;

	@FindBy(xpath = "//li[@class='makeFlex perfectCenter makeRelative']")
	private WebElement OfferButton;

	@FindBy(xpath = "//li[@class='active latoBlack ']")
	private WebElement AllOffer;

	@FindBy(xpath = "//li[@id='showBizUpgradePopup']")
	private WebElement IntroBizButton;

	@FindBy(xpath = "//p[@class='latoBold blackText appendBottom10']")
	private WebElement AlertPopup;

	@FindBy(xpath = "//span[@class='mybizLoginClose']")
	private WebElement AlertPopupClose;

	public boolean isLogoDisplayed() {
		try {
			if (Logo.isDisplayed()) {
				System.out.println("Logo is present");
			}
		} catch (Exception e) {
			System.out.println("Error while getting logo");
		}
		return false;

	}

	public void isSpecialOfferPresent() {
		try {
			clickMe(OfferButton);
			String actualElementText = AllOffer.getText();
			String expectedElementText = "ALL OFFERS";
			assertEquals(actualElementText, expectedElementText);
		} catch (Exception e) {
			System.out.println("Facing Issue in SpecialOffer: " + e);
		}

	}

	public void isIndroBiz() {
		try {
			clickMe(IntroBizButton);
			String actualWebElement = AlertPopup.getText();
			String expectedWebElement = "Work Email";
			assertEquals(actualWebElement, expectedWebElement);
			clickMe(AlertPopupClose);
		} catch (Exception e) {
			System.out.println("Facing Issue in IntroBiz: " + e);
		}

	}
}
