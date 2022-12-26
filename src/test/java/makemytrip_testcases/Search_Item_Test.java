package makemytrip_testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.BaseLibrary;
import pages.Search_Item_Page;

public class Search_Item_Test extends BaseLibrary {
	
	Search_Item_Page ob;
	
	@BeforeTest
	public void getURL(){
		launchURL(getdata("URL"));
		System.out.println("Url Launched");
		ob = new Search_Item_Page();
	}
	
	@Test
	public void searchTest() {
		ob.ClickOnElement();
	}
	
	@AfterTest
	public void quit() {
		tearDown();
	}
}
