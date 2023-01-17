package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Maqdoomec_Page {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://maqdoomec.github.io/test.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void TestData() {
		String Fname = "William";
		String Lname = "Moss";
		String FirstName = driver.findElement(By.xpath("//table[@id='personaldata']//tr//td[text()="+Fname+"]")).getText();
		String LastName = driver.findElement(By.xpath("//table[@id='personaldata']//tr//td[text()="+Lname+"]")).getText();
		System.out.println(FirstName+LastName);
	}
	
	@AfterTest
	public void ShutDown() {
		driver.quit();
	}
	
	
	
	public static void main(String[] args) {
		Maqdoomec_Page ob = new Maqdoomec_Page();
		ob.setup();
		ob.TestData();
		ob.ShutDown();
	}
}
