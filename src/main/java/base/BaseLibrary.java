package base;

import java.io.FileInputStream;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchWindowException;

public class BaseLibrary {

	String file = "C:\\Users\\HP\\eclipse-workspace\\FlipkartAutomation\\TestData\\config.properties";

	public static WebDriver driver;
	public static FileInputStream fis;
	public static WebDriverWait wait;
	public static Select sel;

	// ---------------------BROWSER LAUNCH--------------------------------------

	public void launchURL(String url) {
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Users\\HP\\eclipse-workspace\\FlipkartAutomation\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		implicitWait(10);
		driver.manage().window().maximize();
//		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='webklipper-publisher-widget-container-notification-frame']")));
		driver.findElement(By.xpath("//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser userLoggedOut']"))
				.click();

	}

	// -------------------------FILE CONFIGURATION------------------------------
	public String getdata(String key) {
		String value = "";
		try {
			fis = new FileInputStream(file);
			Properties prop = new Properties();
			prop.load(fis);
			value = prop.getProperty(key);
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return value;
	}

	// ---------------------------COMMON METHODS--------------------------------

	public void doubleclick(WebElement ele) {
		try {
			Actions act = new Actions(driver);
			act.doubleClick().perform();
		} catch (Exception e) {
			System.out.println("Issue occur while double click on element " + e);
		}
	}

	public void rightclick(WebElement ele) {
		try {
			Actions act = new Actions(driver);
			act.contextClick().perform();
		} catch (Exception e) {
			System.out.println("Issue occur while right click on element " + e);
		}
	}

	public static void clickMe(WebElement element) {
		try {

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].click();", element);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void dropdownTextContains(List<WebElement> element, String text) {
		try {
//			int count = 0;
			List<WebElement> options = element;
			for (WebElement ele : options) {
				String currentoption = ele.getText();
				if (currentoption.contains(text)) {
					ele.click();
//					count++;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Issue in drop down value selection");
			e.printStackTrace();
		}
	}

	public static void dropdownValue(WebElement element, String value) {
		try {
			sel = new Select(element);
			List<WebElement> ops = sel.getOptions();
			for (WebElement webElement : ops) {
				String val = webElement.getAttribute("value");
				if (val.equalsIgnoreCase(value)) {
					sel.selectByValue(val);
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Issue in dropdown value " + e);
		}
	}

	public void type(WebElement ele, String value) {
		ele.sendKeys(value);
	}

	public void ExplicitWait(WebDriver driver, String locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
		} catch (Exception e) {
			System.out.println("Exception in dynamic wait method.");
		}
	}

	public void pressEnter() {
		try {
			Actions act = new Actions(driver);
			act.sendKeys(Keys.ENTER).build().perform();
		} catch (Exception e) {
			System.out.println("Issue in pressEnter " + e);
		}
	}

	public void implicitWait(int Time) {
		driver.manage().timeouts().implicitlyWait(Time, TimeUnit.SECONDS);

	}

	public void alertClosure() {
		Alert alt = driver.switchTo().alert();
		alt.getText();
		alt.dismiss();
	}

	public static void switchToWindow(int index) {
		try {
			ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(tabs.get(index));
		} catch (NoSuchWindowException t) {
			System.out.println("No such Window. " + t.getMessage());
		}
	}

	// ---------------------------TEAR
	// DOWN------------------------------------------

	public void tearDown() {
		try {
			driver.quit();
		} catch (Exception e) {
			System.out.println("Getting issue while closing the browser " + e);
		}
	}

	// ==================Calendar-Date-Picker==========================

	public static void selectDate(WebDriver driver, String targetDate, String dateFormat) {
		Date formattedTargetDate;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat targetDateFormat = new SimpleDateFormat(dateFormat);
		

		try {

			targetDateFormat.setLenient(false);
			formattedTargetDate = targetDateFormat.parse(targetDate);
			calendar.setTime(formattedTargetDate);

			int targetDay = calendar.get(Calendar.DAY_OF_MONTH);
			int targetMonth = calendar.get(Calendar.MONTH);
			int targetYear = calendar.get(Calendar.YEAR);

			String actualDate = driver.findElement(By.className("//div[@class='DayPicker-Caption']")).getText();
			calendar.setTime(new SimpleDateFormat("MMM yyyy").parse(actualDate));

			int actualMonth = calendar.get(Calendar.MONTH);
			int actualYear = calendar.get(Calendar.YEAR);

			while (targetMonth < actualMonth || targetYear < actualYear) {
				driver.findElement(By.className("//span[@class='DayPicker-NavButton DayPicker-NavButton--prev']"))
						.click();
				actualDate = driver.findElement(By.className("")).getText();
				calendar.setTime(new SimpleDateFormat("MM yyyy").parse(actualDate));

				actualMonth = calendar.get(Calendar.MONTH);
				actualYear = calendar.get(Calendar.YEAR);
			}

			while (targetMonth > actualMonth || targetYear > actualYear) {
				driver.findElement(By.className("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']"))
						.click();
				actualDate = driver.findElement(By.className("")).getText();
				calendar.setTime(new SimpleDateFormat("MM yyyy").parse(actualDate));

				actualMonth = calendar.get(Calendar.MONTH);
				actualYear = calendar.get(Calendar.YEAR);
			}

			driver.findElement(By.xpath(
					"//table[@class='ui-datepicker-calendar']//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()="
							+ targetDay + "]"));
		} catch (Exception e) {
			System.out.println("Getting error in select calendar " + e);
		}
	}
}