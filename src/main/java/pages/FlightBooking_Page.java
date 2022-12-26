package pages;

import java.util.List;

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

	@FindBy(xpath = "//*[@id='react-autowhatever-1']/div/ul")
	private List<WebElement> SelectCityFrom;

	@FindBy(xpath = "//input[@placeholder='To']")
	private WebElement To;

	@FindBy(xpath = "//*[text()='BOM']/ancestor::li")
	private WebElement SelectCityTo;

	@FindBy(xpath = "//label[@for='departure']")
	private WebElement Departure;

	@FindBy(xpath = "//*[@class='DayPicker-Caption']")
	private WebElement DatePicker;

	

	public void isFlightBook() {
		clickMe(Flights);
		clickMe(OneWay);
		clickMe(From);
		type(From, "New Delhi");
		clickMe(cityFrom);
		From.sendKeys(Keys.TAB);
		type(To, "BOM");
		clickMe(SelectCityTo);
		Departure.sendKeys(Keys.TAB);
	}
}
