package Automate_1;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Scenario1_test {
	public AndroidDriver driver;

	@BeforeTest
	public void startApp() throws MalformedURLException {
		File f = new File("src/test/java/Resources");
		File fs = new File(f, "nopstationCart_4.40.apk");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "android");
		cap.setCapability("automationName", "UiAutomator2");
		cap.setCapability("deviceName", "Pixel_6_API_31");
		cap.setCapability("udid", "emulator-5554");
		cap.setCapability("app", fs.getAbsolutePath());
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void runApp() {
		WebElement el1 = (WebElement) driver.findElementById("com.nopstation.nopcommerce.nopstationcart:id/btnAccept");
		el1.click();
		WebElement el2 = (WebElement) driver.findElementByXPath(
				"//android.widget.TextView[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/navigation_bar_item_small_label_view\" and @text=\"Category\"]");
		el2.click();
		WebElement el3 = (WebElement) driver.findElementByXPath(
				"//android.widget.TextView[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/tvName\" and @text=\"Electronics\"]");
		el3.click();
		
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"Mattress Bedroom\"));");

		WebElement el4 = (WebElement) driver
				.findElementByXPath("//android.widget.TextView[@resource-id=\"com.nopstation.nopcommerce.nopstationcart:id/tvProductName\" and @text=\"Mattress Bedroom\"]");
		el4.click();
		 
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(text(\"Quantity\"));");
	

		WebElement el5 = (WebElement) driver.findElementById("com.nopstation.nopcommerce.nopstationcart:id/btnPlus");
		el5.click();
		WebElement el6 = (WebElement) driver
				.findElementById("com.nopstation.nopcommerce.nopstationcart:id/btnAddToCart");
		el6.click();

	}

	//@AfterTest
	//public void removeApp() {
		//driver.removeApp("com.nopstation.nopcommerce.nopstationcart");
	//}

}
