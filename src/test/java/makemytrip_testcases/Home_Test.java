package makemytrip_testcases;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseLibrary;
import pages.Home_Page;

public class Home_Test extends BaseLibrary{

	Home_Page ob;
	
	@BeforeTest
	public void glaunchURL() {
		launchURL(getdata("URL"));
	}
	
	@Test (priority = 1)
	public void islogovisible() {
		ob = new Home_Page();
		ob.isLogoDisplayed();	
	}
	
	@Test (priority = 2)
	public void verifySpecialOffer() {
		ob.isSpecialOfferPresent();
	}
	
	@Test (priority = 3)
	public void verifyIntroBiz() {
		ob.isIndroBiz();
	}
	
	
	@AfterTest
	public void quit() {
		tearDown();
	}

}
