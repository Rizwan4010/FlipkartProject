package makemytrip_testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseLibrary;
import pages.Login_Page;

public class Login_Test extends BaseLibrary {
	Login_Page ob;

	@BeforeTest
	public void glaunchURL() {
		launchURL(getdata("URL"));
	}

	@Test
	public void homePageLogin() {
		ob = new Login_Page();
		ob.pageLogin();
	}

	@AfterTest
	public void quit() {
		tearDown();
	}
}