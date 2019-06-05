package mvnappiumautojar.testscripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestSafariOnRealDevice {

	
	public static IOSDriver driver;
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7 Plus");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.UDID, "571e1c5acf8c4e0d47c6d146186d8749c8fab5b0");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1.3");
		
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		

		
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
		driver.get("http://google.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.name("q")).sendKeys("Hello Appium");
		
		Thread.sleep(3000);
		
		driver.quit();
		

	}

}
