package makemytrip_testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseLibrary;
import pages.FlightBooking_Page;

public class FlightBooking_Test extends BaseLibrary {
	FlightBooking_Page ob;

	@BeforeTest
	public void glaunchURL() {
		launchURL(getdata("URL"));
	}

	@Test
	public void isFlightBooked() {
		ob = new FlightBooking_Page();
		ob.isFlightBook();
	}

	@AfterTest
	public void quit() {
		tearDown();
	}

}
