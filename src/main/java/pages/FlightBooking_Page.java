package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseLibrary;

public class FlightBooking_Page extends BaseLibrary {

	public FlightBooking_Page() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@class='menu_Flights']//a")
	private WebElement Flights;
	@FindBy(xpath = "//*[@class='selected']")
	private WebElement OneWay;
	@FindBy(xpath = "//input[@id='fromCity']")
	private WebElement From;
	@FindBy(xpath = "//div[@class='calc60']/p[text()='New Delhi, India']")
	private WebElement cityFrom;
	@FindBy(xpath = "//input[@placeholder='To']")
	private WebElement To;
	@FindBy(xpath = "//*[text()='BOM']/ancestor::li")
	private WebElement SelectCityTo;
	@FindBy(xpath = "//span[normalize-space()='RETURN']")
	private WebElement Return;
	@FindBy(xpath = "//p[@class='makeFlex vrtlCenter ']/a")
	private WebElement SearchBtn;
	@FindBy(xpath="//div[@class='stickyFlightDtl appendRight15']//p[contains(text(),'Departure')]")
	private WebElement departureflightname;
	
	public void isFlightBook() {
		try {
			clickMe(Flights);
			clickMe(OneWay);
			clickMe(From);
			type(From, "New Delhi");
			clickMe(cityFrom);
			From.sendKeys(Keys.TAB);
			type(To, "BOM");
			clickMe(SelectCityTo);
			selectDate("Tue Jan 10 2023", "January", "2023");
			clickMe(Return);
			selectDate("Wed Jan 11 2023", "January", "2023");
			clickMe(SearchBtn);
			String departureflightName = departureflightname.getText().replaceAll("Departure . ", "");
			System.out.println("Departure Flight Name: "+departureflightName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
