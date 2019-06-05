package mvnappiumautojar.testscripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestSwitchIOSAppRealDevice {
	public static IOSDriver driver;

	
	//https://pspdfkit.com/guides/ios/current/faq/finding-the-app-bundle-id/
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.UDID, "571e1c5acf8c4e0d47c6d146186d8749c8fab5b0");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1.3");

		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		capabilities.setCapability(MobileCapabilityType.APP,
				"/Users/rahularora/Library/Developer/Xcode/DerivedData/WebDriverAgent-brdadhpuduowllgivnnvuygpwhzy/Build/Products/Debug-iphoneos/IntegrationApp.app");

		capabilities.setCapability("xcodeOrgId", "LUBWEAQUT4");

		capabilities.setCapability("xcodeSigningId", "iPhone Developer");
	
		
		
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

		// Activate WhatApp
		HashMap<String, String> param = new HashMap<String, String>();
		param.put("bundleId", "net.whatsapp.WhatsApp");
		driver.executeScript("mobile: launchApp", param);
		driver.findElement(MobileBy.AccessibilityId("Sagar Dodia")).click();

		Thread.sleep(3000);
		// ReActivate Integration App
		param.put("bundleId", "com.facebook.wda.integrationApp");
		driver.executeScript("mobile: activateApp", param);

		Thread.sleep(3000);
		// Activate PhotoAlbum
		param.put("bundleId", "com.apple.mobileslideshow");
		driver.executeScript("mobile: launchApp", param);

		Thread.sleep(3000);
		driver.quit();
	}

}
