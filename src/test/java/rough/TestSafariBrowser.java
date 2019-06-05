package rough;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestSafariBrowser {
	public static IOSDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
//		capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.6.4-beta");
//		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.1");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Xʀ (12.2)");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		capabilities.setCapability(MobileCapabilityType.UDID, "E11C009C-3D7B-4596-90EC-8D37EF68F7ED");

		driver = new IOSDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("Hello Sagar from Appium!");
		
		Thread.sleep(4000);
		driver.quit();
	}

}
