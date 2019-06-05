package mvnappiumautojar.testscripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestSwitches {

	public static IOSDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		/*
		//capabilities.setCapability(MobileCapabilityType.UDID, "571e1c5acf8c4e0d47c6d146186d8749c8fab5b0");
		capabilities.setCapability(MobileCapabilityType.UDID, "7ae544323f497983cf0729bc81d5e6128342a125");
		
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1.2");
		//capabilities.setCapability("xcodeOrgId", "LUBWEAQUT4");

		//capabilities.setCapability("xcodeSigningId", "iPhone Developer");
	
		
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		
		capabilities.setCapability(MobileCapabilityType.APP,
				"/Users/rahularora/Library/Developer/Xcode/DerivedData/WebDriverAgent-brdadhpuduowllgivnnvuygpwhzy/Build/Products/Debug-iphoneos/IntegrationApp.app");
		
		*/
		
		
		//capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 7 Plus");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1");
		
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		capabilities.setCapability(MobileCapabilityType.APP,
				"/Users/rahularora/Library/Developer/Xcode/DerivedData/WebDriverAgent-brdadhpuduowllgivnnvuygpwhzy/Build/Products/Debug-iphonesimulator/IntegrationApp.app");
	
	
		
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(MobileBy.AccessibilityId("Attributes")).click();

		WebElement switches = driver.findElement(By.className("XCUIElementTypeSwitch"));

		// Turn off the switch
		if (switches.getAttribute("value").equals("1")) {

			switches.click();
		}

		Thread.sleep(3000);

		// Turn on the switch
		if (switches.getAttribute("value").equals("0")) {

			switches.click();
		}

		Thread.sleep(3000);
		driver.quit();
	}

}

